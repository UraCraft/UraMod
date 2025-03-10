package fr.uracraft.uramod.tileentity;

import fr.uracraft.uramod.blocks.BlockUraFurnace;
import fr.uracraft.uramod.container.ContainerUraFurnace;
import fr.uracraft.uramod.items.ItemUpgrade;
import fr.uracraft.uramod.items.UraItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

import java.util.Random;

public class TileEntityUraFurnace extends TileEntityLockable implements ITickable, ISidedInventory {
    private static final int[] SLOTS_TOP = new int[]{0};
    private static final int[] SLOTS_BOTTOM = new int[]{2};
    private static final int[] SLOTS_SIDES = new int[]{1, 4};
    private NonNullList<ItemStack> furnaceItemStacks = NonNullList.<ItemStack>withSize(5, ItemStack.EMPTY);
    private int furnaceBurnTime;
    private int currentItemBurnTime;
    private int cookTime;
    private int totalCookTime;
    private String furnaceCustomName;


    public int getSizeInventory() {
        return 5;
    }


    public boolean isEmpty() {
        for (ItemStack itemstack : this.furnaceItemStacks) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public ItemStack getStackInSlot(int index) {
        if (index < this.furnaceItemStacks.size())
            return this.furnaceItemStacks.get(index);
        return ItemStack.EMPTY;
    }

    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.furnaceItemStacks, index, count);
    }

    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.furnaceItemStacks, index);
    }

    public void setInventorySlotContents(int index, ItemStack stack) {
        ItemStack itemstack = this.furnaceItemStacks.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
        this.furnaceItemStacks.set(index, stack);

        if (stack.getCount() > this.getInventoryStackLimit()) {
            stack.setCount(this.getInventoryStackLimit());
        }

        if (index == 0 && !flag) {
            this.totalCookTime = this.getCookTime(stack);
            this.cookTime = 0;
            this.markDirty();
        }
    }

    public String getName() {
        return this.hasCustomName() ? this.furnaceCustomName : I18n.format("container.uramod.ura_furnace");
    }

    public boolean hasCustomName() {
        return this.furnaceCustomName != null && !this.furnaceCustomName.isEmpty();
    }

    public void setCustomInventoryName(String p_145951_1_) {
        this.furnaceCustomName = p_145951_1_;
    }

    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.furnaceItemStacks = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.furnaceItemStacks);
        this.furnaceBurnTime = compound.getInteger("BurnTime");
        this.cookTime = compound.getInteger("CookTime");
        this.totalCookTime = compound.getInteger("CookTimeTotal");
        this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks.get(1));

        if (compound.hasKey("CustomName", 8)) {
            this.furnaceCustomName = compound.getString("CustomName");
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("BurnTime", (short) this.furnaceBurnTime);
        compound.setInteger("CookTime", (short) this.cookTime);
        compound.setInteger("CookTimeTotal", (short) this.totalCookTime);
        ItemStackHelper.saveAllItems(compound, this.furnaceItemStacks);

        if (this.hasCustomName()) {
            compound.setString("CustomName", this.furnaceCustomName);
        }

        return compound;
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public boolean isBurning() {
        return this.furnaceBurnTime > 0;
    }

    public static boolean isUpgrade(ItemStack stack) {
        return stack.getItem() instanceof ItemUpgrade;
    }

    public boolean asFuel() {
        return !this.furnaceItemStacks.get(1).isEmpty() || !this.furnaceItemStacks.get(4).isEmpty();
    }

    public void useUpgrade() {
        int level = 0;
        if (this.furnaceItemStacks.get(3) != ItemStack.EMPTY)
            if (EnchantmentHelper.getEnchantments(this.furnaceItemStacks.get(3)).get(Enchantments.UNBREAKING) != null)
                level = EnchantmentHelper.getEnchantmentLevel(Enchantments.UNBREAKING, this.furnaceItemStacks.get(3));
        if (!negateDamage(this.furnaceItemStacks.get(3), level, new Random())) {
            this.furnaceItemStacks.get(3).setItemDamage(this.furnaceItemStacks.get(3).getItemDamage() + 1);
        }
    }

    public static boolean negateDamage(ItemStack stack, int level, Random rand) {
        if (stack.getItem() instanceof ItemUpgrade && rand.nextFloat() < 0.6F) {
            return false;
        } else {
            return rand.nextInt(level + 1) > 0;
        }
    }

    public int getFuelIndex() {
        if (!this.furnaceItemStacks.get(1).isEmpty())
            return 1;
        return 4;
    }

    @SideOnly(Side.CLIENT)
    public static boolean isBurning(IInventory inventory) {
        return inventory.getField(0) > 0;
    }

    public void update() {
        boolean flag = this.isBurning();
        boolean flag1 = false;

        if (this.isBurning()) {
            --this.furnaceBurnTime;
        }

        if (!this.world.isRemote) {
            if (!this.furnaceItemStacks.get(3).isEmpty() && isUpgrade(this.furnaceItemStacks.get(3))) {


                if (this.furnaceItemStacks.get(3).getItem() == UraItems.URA_UPGRADE) {
                    totalCookTime = 75;
                } else if (this.furnaceItemStacks.get(3).getItem() == UraItems.IRIDIUM_UPGRADE) {
                    totalCookTime = 5;
                } else if (this.furnaceItemStacks.get(3).getItem() == UraItems.NEODYMIUM_UPGRADE) {
                    totalCookTime = 50;
                } else if (this.furnaceItemStacks.get(3).getItem() == UraItems.DIAMOND_UPGRADE) {
                    totalCookTime = 150;
                } else if (this.furnaceItemStacks.get(3).getItem() == UraItems.SILVER_UPGRADE) {
                    totalCookTime = 125;


                }
            } else {
                totalCookTime = 200;
            }


            if (this.isBurning() || asFuel() && !((ItemStack) this.furnaceItemStacks.get(0)).isEmpty()) {
                ItemStack itemstack = this.furnaceItemStacks.get(getFuelIndex());
                if (!this.isBurning() && this.canSmelt()) {
                    this.furnaceBurnTime = getItemBurnTime(itemstack);
                    this.currentItemBurnTime = this.furnaceBurnTime;

                    if (this.isBurning()) {
                        flag1 = true;

                        if (!itemstack.isEmpty()) {
                            Item item = itemstack.getItem();
                            itemstack.shrink(1);

                            if (itemstack.isEmpty()) {
                                ItemStack item1 = item.getContainerItem(itemstack);
                                this.furnaceItemStacks.set(1, item1);
                            }
                        }
                    }
                }

                if (this.isBurning() && this.canSmelt()) {
                    ++this.cookTime;

                    if (this.cookTime >= this.totalCookTime) {
                        this.useUpgrade();
                        this.cookTime = 0;
                        this.totalCookTime = this.getCookTime(this.furnaceItemStacks.get(0));
                        this.smeltItem();
                        flag1 = true;
                    }
                } else {
                    this.cookTime = 0;
                }
            } else if (!this.isBurning() && this.cookTime > 0) {
                this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
            }

            if (flag != this.isBurning()) {
                flag1 = true;
                BlockUraFurnace.setState(this.isBurning(), this.world, this.pos);
            }
        }

        if (flag1) {
            this.markDirty();
        }
    }

    public int getCookTime(ItemStack stack) {
        return 200;
    }

    private boolean canSmelt() {
        if (((ItemStack) this.furnaceItemStacks.get(0)).isEmpty()) {
            return false;
        } else {
            ItemStack itemstack = FurnaceRecipes.instance().getSmeltingResult(this.furnaceItemStacks.get(0));

            if (itemstack.isEmpty()) {
                return false;
            } else {
                ItemStack itemstack1 = this.furnaceItemStacks.get(2);

                if (itemstack1.isEmpty()) {
                    return true;
                } else if (!itemstack1.isItemEqual(itemstack)) {
                    return false;
                } else if (itemstack1.getCount() + itemstack.getCount() <= this.getInventoryStackLimit() && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize())  // Forge fix: make furnace respect stack sizes in furnace recipes
                {
                    return true;
                } else {
                    return itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize(); // Forge fix: make furnace respect stack sizes in furnace recipes
                }
            }
        }
    }

    public void smeltItem() {
        if (this.canSmelt()) {
            ItemStack itemstack = this.furnaceItemStacks.get(0);
            ItemStack itemstack1 = FurnaceRecipes.instance().getSmeltingResult(itemstack);
            ItemStack itemstack2 = this.furnaceItemStacks.get(2);

            if (itemstack2.isEmpty()) {
                this.furnaceItemStacks.set(2, itemstack1.copy());
            } else if (itemstack2.getItem() == itemstack1.getItem()) {
                itemstack2.grow(itemstack1.getCount());
            }

            if (itemstack.getItem() == Item.getItemFromBlock(Blocks.SPONGE) && itemstack.getMetadata() == 1 && !((ItemStack) this.furnaceItemStacks.get(1)).isEmpty() && ((ItemStack) this.furnaceItemStacks.get(1)).getItem() == Items.BUCKET) {
                this.furnaceItemStacks.set(1, new ItemStack(Items.WATER_BUCKET));
            }

            itemstack.shrink(1);
        }
    }

    public static int getItemBurnTime(ItemStack stack) {
        if (stack.isEmpty()) {
            return 0;
        } else {
            int burnTime = net.minecraftforge.event.ForgeEventFactory.getItemBurnTime(stack);
            if (burnTime >= 0) return burnTime;
            Item item = stack.getItem();

            if (item == Item.getItemFromBlock(Blocks.WOODEN_SLAB)) {
                return 150;
            } else if (item == Item.getItemFromBlock(Blocks.WOOL)) {
                return 100;
            } else if (item == Item.getItemFromBlock(Blocks.CARPET)) {
                return 67;
            } else if (item == Item.getItemFromBlock(Blocks.LADDER)) {
                return 300;
            } else if (item == Item.getItemFromBlock(Blocks.WOODEN_BUTTON)) {
                return 100;
            } else if (Block.getBlockFromItem(item).getDefaultState().getMaterial() == Material.WOOD) {
                return 300;
            } else if (item == Item.getItemFromBlock(Blocks.COAL_BLOCK)) {
                return 16000;
            } else if (item instanceof ItemTool && "WOOD".equals(((ItemTool) item).getToolMaterialName())) {
                return 200;
            } else if (item instanceof ItemSword && "WOOD".equals(((ItemSword) item).getToolMaterialName())) {
                return 200;
            } else if (item instanceof ItemHoe && "WOOD".equals(((ItemHoe) item).getMaterialName())) {
                return 200;
            } else if (item == Items.STICK) {
                return 100;
            } else if (item != Items.BOW && item != Items.FISHING_ROD) {
                if (item == Items.SIGN) {
                    return 200;
                } else if (item == Items.COAL) {
                    return 1600;
                } else if (item == Items.LAVA_BUCKET) {
                    return 20000;
                } else if (item != Item.getItemFromBlock(Blocks.SAPLING) && item != Items.BOWL) {
                    if (item == Items.BLAZE_ROD) {
                        return 2400;
                    } else if (item instanceof ItemDoor && item != Items.IRON_DOOR) {
                        return 200;
                    } else {
                        return item instanceof ItemBoat ? 400 : 0;
                    }
                } else {
                    return 100;
                }
            } else {
                return 300;
            }
        }
    }

    public static boolean isItemFuel(ItemStack stack) {
        return getItemBurnTime(stack) > 0;
    }

    public boolean isUsableByPlayer(EntityPlayer player) {
        if (this.world.getTileEntity(this.pos) != this) {
            return false;
        } else {
            return player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
        }
    }

    public void openInventory(EntityPlayer player) {
    }

    public void closeInventory(EntityPlayer player) {
    }

    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if (index == 2) {
            return false;
        } else if (index == 3) {
            ItemStack itemstack = this.furnaceItemStacks.get(3);
            if (itemstack != ItemStack.EMPTY && stack.getItem() instanceof ItemUpgrade)
                return true;
        }

        if (index == 1 || index == 4) {
            ItemStack itemstack = this.furnaceItemStacks.get(index);
            return isItemFuel(stack) || SlotFurnaceFuel.isBucket(stack) && itemstack.getItem() != Items.BUCKET;
        }
        return true;
    }

    public int[] getSlotsForFace(EnumFacing side) {
        if (side == EnumFacing.DOWN) {
            return SLOTS_BOTTOM;
        } else {
            return side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES;
        }
    }

    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
        return this.isItemValidForSlot(index, itemStackIn);
    }

    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        if (direction == EnumFacing.DOWN && index == 1) {
            Item item = stack.getItem();

            if (item != Items.WATER_BUCKET && item != Items.BUCKET) {
                return false;
            }
        }

        return true;
    }

    public String getGuiID() {
        return "uramod:ura_furnace";
    }

    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return new ContainerUraFurnace(playerInventory, this);
    }

    public int getField(int id) {
        switch (id) {
            case 0:
                return this.furnaceBurnTime;
            case 1:
                return this.currentItemBurnTime;
            case 2:
                return this.cookTime;
            case 3:
                return this.totalCookTime;
            default:
                return 0;
        }
    }

    public void setField(int id, int value) {
        switch (id) {
            case 0:
                this.furnaceBurnTime = value;
                break;
            case 1:
                this.currentItemBurnTime = value;
                break;
            case 2:
                this.cookTime = value;
                break;
            case 3:
                this.totalCookTime = value;
        }
    }

    public int getFieldCount() {
        return 4;
    }

    public void clear() {
        this.furnaceItemStacks.clear();
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return this.getCapability(capability, facing) != null;
    }

    IItemHandler handlerTop = new SidedInvWrapper(this, EnumFacing.UP);
    IItemHandler handlerBottom = new SidedInvWrapper(this, EnumFacing.DOWN);
    IItemHandler handlerSide = new SidedInvWrapper(this, EnumFacing.WEST);

    @SuppressWarnings("unchecked")
    @Override
    @javax.annotation.Nullable
    public <T> T getCapability(Capability<T> capability, @javax.annotation.Nullable EnumFacing facing) {
        if (facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            if (facing == EnumFacing.DOWN)
                return (T) handlerBottom;
            else if (facing == EnumFacing.UP)
                return (T) handlerTop;
            else
                return (T) handlerSide;
        return super.getCapability(capability, facing);
    }

}
