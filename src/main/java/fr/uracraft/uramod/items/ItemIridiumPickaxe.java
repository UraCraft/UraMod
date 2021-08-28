package fr.uracraft.uramod.items;

import fr.uracraft.uramod.UraCreativeTabs;
import fr.uracraft.uramod.UraMod;
import fr.uracraft.uramod.blocks.UraBlocks;
import fr.uracraft.uramod.items.tools.UraToolMaterials;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.Objects;

public class ItemIridiumPickaxe extends net.minecraft.item.ItemPickaxe {

    public static String VARIANTS[][] = new String[][]{
            {"iridium_pickaxe", "0"},
            {"pickaxe_of_the_gods", "1"}};

    public ItemIridiumPickaxe() {
        super(Objects.requireNonNull(UraToolMaterials.IRIDIUM_TOOL_MATERIAL));
        UraItems.setItemName(this, "iridium_pickaxe");
        setCreativeTab(UraCreativeTabs.URAMOD);
        setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item." + UraMod.MODID + "." + byMetadata(stack.getMetadata());
    }

    @Override
    public void getSubItems(final CreativeTabs tab, final NonNullList<ItemStack> subItems) {
        if (this.isInCreativeTab(tab)) {
            for (int i = 0; i < VARIANTS.length; i++) {
                subItems.add(new ItemStack(this, 1, i));
            }
        }
    }

    public static String byMetadata(int meta) {
        return VARIANTS[meta][0];
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (playerIn.isSneaking()) {
            ItemStack stack = playerIn.getHeldItem(handIn);
            if (stack.getMetadata() == 1) {
                if (!stack.hasTagCompound()) {
                    stack.setTagCompound(new NBTTagCompound());
                }
                byte mode = stack.getTagCompound().getByte("mode");
                mode++;
                if (mode == 5) {
                    mode = 0;
                }
                stack.getTagCompound().setByte("mode", mode);
                if (!worldIn.isRemote) {
                    playerIn.sendMessage(new TextComponentString(I18n.format(mode == 0 ? "pickaxe_of_the_gods.mode.normal" : mode == 1 ? "pickaxe_of_the_gods.mode.tunnel" : mode == 2 ? "pickaxe_of_the_gods.mode.hammer.3x3x1" : mode == 3 ? "pickaxe_of_the_gods.mode.hammer.3x3x3" : "pickaxe_of_the_gods.mode.hammer.5x5x1")));
                }
            }
        } else {
            super.onItemRightClick(worldIn, playerIn, handIn);
        }
        return new ActionResult<>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }

    public RayTraceResult rayTrace(double blockReachDistance, float partialTicks, World w, EntityLivingBase e) {
        Vec3d vec3d = e.getPositionEyes(partialTicks);
        Vec3d vec3d1 = e.getLook(partialTicks);
        Vec3d vec3d2 = vec3d.addVector(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
        return w.rayTraceBlocks(vec3d, vec3d2, false, false, true);
    }

    public boolean onBlockDestroyed(ItemStack breaker, World w, IBlockState state, BlockPos pos, EntityLivingBase e) {
        if (!breaker.hasTagCompound()) {
            breaker.setTagCompound(new NBTTagCompound());
        }
        if (breaker.getTagCompound().getByte("mode") == 1 || breaker.getTagCompound().getByte("mode") == 2 || breaker.getTagCompound().getByte("mode") == 4) {
            if (e instanceof EntityPlayer && !w.isRemote) {
                EntityPlayer p = (EntityPlayer) e;
                RayTraceResult r = this.rayTrace(5.0D, 0.0F, w, e);
                if (r.typeOfHit == RayTraceResult.Type.BLOCK) {
                    int x = pos.getX();
                    int y = pos.getY();
                    int z = pos.getZ();
                    EnumFacing side = r.sideHit;
                    if (side == EnumFacing.DOWN || side == EnumFacing.UP) {
                        if (breaker.getTagCompound().getByte("mode") != 1) {
                            this.destroyAndDropBlock(w, p, breaker, x + 1, y, z - 1);
                            this.destroyAndDropBlock(w, p, breaker, x + 1, y, z);
                            this.destroyAndDropBlock(w, p, breaker, x + 1, y, z + 1);
                            this.destroyAndDropBlock(w, p, breaker, x, y, z - 1);
                            //Middle Block
                            this.destroyAndDropBlock(w, p, breaker, x, y, z + 1);
                            this.destroyAndDropBlock(w, p, breaker, x - 1, y, z - 1);
                            this.destroyAndDropBlock(w, p, breaker, x - 1, y, z);
                            this.destroyAndDropBlock(w, p, breaker, x - 1, y, z + 1);
                            if (breaker.getTagCompound().getByte("mode") == 4) {
                                this.destroyAndDropBlock(w, p, breaker, x - 1, y, z + 2);
                                this.destroyAndDropBlock(w, p, breaker, x - 2, y, z + 2);
                                this.destroyAndDropBlock(w, p, breaker, x, y, z + 2);
                                this.destroyAndDropBlock(w, p, breaker, x + 1, y, z + 2);
                                this.destroyAndDropBlock(w, p, breaker, x + 2, y, z + 2);

                                this.destroyAndDropBlock(w, p, breaker, x - 1, y, z - 2);
                                this.destroyAndDropBlock(w, p, breaker, x - 2, y, z - 2);
                                this.destroyAndDropBlock(w, p, breaker, x, y, z - 2);
                                this.destroyAndDropBlock(w, p, breaker, x + 1, y, z - 2);
                                this.destroyAndDropBlock(w, p, breaker, x + 2, y, z - 2);

                                this.destroyAndDropBlock(w, p, breaker, x + 2, y, z - 1);
                                this.destroyAndDropBlock(w, p, breaker, x + 2, y, z);
                                this.destroyAndDropBlock(w, p, breaker, x + 2, y, z + 1);

                                this.destroyAndDropBlock(w, p, breaker, x - 2, y, z - 1);
                                this.destroyAndDropBlock(w, p, breaker, x - 2, y, z);
                                this.destroyAndDropBlock(w, p, breaker, x - 2, y, z + 1);
                            }
                        }
                    } else if (side == EnumFacing.NORTH || side == EnumFacing.SOUTH) {
                        this.destroyAndDropBlock(w, p, breaker, x, y - 1, z);
                        if (breaker.getTagCompound().getByte("mode") != 1) {
                            this.destroyAndDropBlock(w, p, breaker, x + 1, y + 1, z);
                            this.destroyAndDropBlock(w, p, breaker, x, y + 1, z);
                            this.destroyAndDropBlock(w, p, breaker, x - 1, y + 1, z);
                            this.destroyAndDropBlock(w, p, breaker, x + 1, y, z);
                            //Middle Block
                            this.destroyAndDropBlock(w, p, breaker, x - 1, y, z);
                            this.destroyAndDropBlock(w, p, breaker, x + 1, y - 1, z);

                            this.destroyAndDropBlock(w, p, breaker, x - 1, y - 1, z);
                            if (breaker.getTagCompound().getByte("mode") == 4) {
                                this.destroyAndDropBlock(w, p, breaker, x - 1, y + 2, z);
                                this.destroyAndDropBlock(w, p, breaker, x - 2, y + 2, z);
                                this.destroyAndDropBlock(w, p, breaker, x, y + 2, z);
                                this.destroyAndDropBlock(w, p, breaker, x + 1, y + 2, z);
                                this.destroyAndDropBlock(w, p, breaker, x + 2, y + 2, z);

                                this.destroyAndDropBlock(w, p, breaker, x - 1, y - 2, z);
                                this.destroyAndDropBlock(w, p, breaker, x - 2, y - 2, z);
                                this.destroyAndDropBlock(w, p, breaker, x, y - 2, z);
                                this.destroyAndDropBlock(w, p, breaker, x + 1, y - 2, z);
                                this.destroyAndDropBlock(w, p, breaker, x + 2, y - 2, z);

                                this.destroyAndDropBlock(w, p, breaker, x + 2, y - 1, z);
                                this.destroyAndDropBlock(w, p, breaker, x + 2, y, z);
                                this.destroyAndDropBlock(w, p, breaker, x + 2, y + 1, z);

                                this.destroyAndDropBlock(w, p, breaker, x - 2, y - 1, z);
                                this.destroyAndDropBlock(w, p, breaker, x - 2, y, z);
                                this.destroyAndDropBlock(w, p, breaker, x - 2, y + 1, z);
                            }
                        }
                    } else if (side == EnumFacing.EAST || side == EnumFacing.WEST) {
                        this.destroyAndDropBlock(w, p, breaker, x, y - 1, z);
                        if (breaker.getTagCompound().getByte("mode") != 1) {
                            this.destroyAndDropBlock(w, p, breaker, x, y + 1, z + 1);
                            this.destroyAndDropBlock(w, p, breaker, x, y + 1, z);
                            this.destroyAndDropBlock(w, p, breaker, x, y + 1, z - 1);
                            this.destroyAndDropBlock(w, p, breaker, x, y, z + 1);
                            //Middle Block
                            this.destroyAndDropBlock(w, p, breaker, x, y, z - 1);
                            this.destroyAndDropBlock(w, p, breaker, x, y - 1, z + 1);

                            this.destroyAndDropBlock(w, p, breaker, x, y - 1, z - 1);
                            if (breaker.getTagCompound().getByte("mode") == 4) {
                                this.destroyAndDropBlock(w, p, breaker, x, y + 2, z - 1);
                                this.destroyAndDropBlock(w, p, breaker, x, y + 2, z - 2);
                                this.destroyAndDropBlock(w, p, breaker, x, y + 2, z);
                                this.destroyAndDropBlock(w, p, breaker, x, y + 2, z + 1);
                                this.destroyAndDropBlock(w, p, breaker, x, y + 2, z + 2);

                                this.destroyAndDropBlock(w, p, breaker, x, y - 2, z - 1);
                                this.destroyAndDropBlock(w, p, breaker, x, y - 2, z - 2);
                                this.destroyAndDropBlock(w, p, breaker, x, y - 2, z);
                                this.destroyAndDropBlock(w, p, breaker, x, y - 2, z + 1);
                                this.destroyAndDropBlock(w, p, breaker, x, y - 2, z + 2);

                                this.destroyAndDropBlock(w, p, breaker, x, y - 1, z + 2);
                                this.destroyAndDropBlock(w, p, breaker, x, y, z + 2);
                                this.destroyAndDropBlock(w, p, breaker, x, y + 1, z + 2);

                                this.destroyAndDropBlock(w, p, breaker, x, y - 1, z - 2);
                                this.destroyAndDropBlock(w, p, breaker, x, y, z - 2);
                                this.destroyAndDropBlock(w, p, breaker, x, y + 1, z - 2);
                            }
                        }
                    }
                }
            }
        } else if (breaker.getTagCompound().getByte("mode") == 3) {
            if (e instanceof EntityPlayer && !w.isRemote) {
                if (this.rayTrace(5.0D, 0.0F, w, e).typeOfHit == RayTraceResult.Type.BLOCK) {
                    for (int x = -1; x < 2; x++) {
                        for (int y = -1; y < 2; y++) {
                            for (int z = -1; z < 2; z++) {
                                this.destroyAndDropBlock(w, (EntityPlayer) e, breaker, pos.getX() + x, pos.getY() + y, pos.getZ() + z);
                            }
                        }
                    }
                }
            }
        }
        return super.onBlockDestroyed(breaker, w, state, pos, e);
    }

    private void destroyAndDropBlock(World w, EntityPlayer p, ItemStack breaker, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        if (w.getBlockState(pos).getBlock() == Blocks.STONE || w.getBlockState(pos).getBlock() == UraBlocks.BLOCK_STONE) {
            w.getBlockState(pos).getBlock().harvestBlock(w, p, pos, w.getBlockState(pos), w.getTileEntity(pos), breaker);
            w.setBlockToAir(pos);
        }
    }
}