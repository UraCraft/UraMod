package fr.uracraft.uramod.items.tools;

import fr.uracraft.uramod.UraCreativeTabs;
import fr.uracraft.uramod.blocks.UraBlocks;
import fr.uracraft.uramod.enchantments.UraEnchantments;
import fr.uracraft.uramod.items.UraItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemHammer extends net.minecraft.item.ItemPickaxe {

    int repeat;
    int r2;

    public ItemHammer(ToolMaterial material, String name) {
        super(material);
        UraItems.setItemName(this, name);
        setCreativeTab(UraCreativeTabs.URAMOD);
    }

    public RayTraceResult rayTrace(double blockReachDistance, float partialTicks, World w, EntityLivingBase e) {
        Vec3d vec3d = e.getPositionEyes(partialTicks);
        Vec3d vec3d1 = e.getLook(partialTicks);
        Vec3d vec3d2 = vec3d.addVector(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
        return w.rayTraceBlocks(vec3d, vec3d2, false, false, true);
    }

    public boolean onBlockDestroyed(ItemStack breaker, World w, IBlockState state, BlockPos pos, EntityLivingBase e) {
        if (e instanceof EntityPlayer && !w.isRemote) {
            EntityPlayer p = (EntityPlayer) e;
            RayTraceResult r = this.rayTrace(5.0D, 0.0F, w, e);
            if (r.typeOfHit == RayTraceResult.Type.BLOCK) {
                int x = pos.getX();
                int y = pos.getY();
                int z = pos.getZ();
                EnumFacing side = r.sideHit;

                if (side == EnumFacing.DOWN || side == EnumFacing.UP) {
                    this.destroyAndDropBlock(w, p, breaker, x + 1, y, z - 1);
                    this.destroyAndDropBlock(w, p, breaker, x + 1, y, z);
                    this.destroyAndDropBlock(w, p, breaker, x + 1, y, z + 1);
                    this.destroyAndDropBlock(w, p, breaker, x, y, z - 1);

                    this.destroyAndDropBlock(w, p, breaker, x, y, z + 1);
                    this.destroyAndDropBlock(w, p, breaker, x - 1, y, z - 1);
                    this.destroyAndDropBlock(w, p, breaker, x - 1, y, z);
                    this.destroyAndDropBlock(w, p, breaker, x - 1, y, z + 1);
                } else if (side == EnumFacing.NORTH || side == EnumFacing.SOUTH) {
                    this.destroyAndDropBlock(w, p, breaker, x + 1, y + 1, z);
                    this.destroyAndDropBlock(w, p, breaker, x, y + 1, z);
                    this.destroyAndDropBlock(w, p, breaker, x - 1, y + 1, z);
                    this.destroyAndDropBlock(w, p, breaker, x + 1, y, z);

                    this.destroyAndDropBlock(w, p, breaker, x - 1, y, z);
                    this.destroyAndDropBlock(w, p, breaker, x + 1, y - 1, z);
                    this.destroyAndDropBlock(w, p, breaker, x, y - 1, z);
                    this.destroyAndDropBlock(w, p, breaker, x - 1, y - 1, z);
                } else if (side == EnumFacing.EAST || side == EnumFacing.WEST) {
                    this.destroyAndDropBlock(w, p, breaker, x, y + 1, z + 1);
                    this.destroyAndDropBlock(w, p, breaker, x, y + 1, z);
                    this.destroyAndDropBlock(w, p, breaker, x, y + 1, z - 1);
                    this.destroyAndDropBlock(w, p, breaker, x, y, z + 1);

                    this.destroyAndDropBlock(w, p, breaker, x, y, z - 1);
                    this.destroyAndDropBlock(w, p, breaker, x, y - 1, z + 1);
                    this.destroyAndDropBlock(w, p, breaker, x, y - 1, z);
                    this.destroyAndDropBlock(w, p, breaker, x, y - 1, z - 1);
                }
                return true;
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
        repeat++;
        if (repeat >= 4) {
            repeat = 0;
            if (UraEnchantments.hasEnchantment(breaker, 34)) {
                if (r2 >= EnchantmentHelper.getEnchantmentLevel(Enchantments.UNBREAKING, breaker)) {
                    breaker.setItemDamage(breaker.getItemDamage() + 1);
                    r2 = 0;
                }
                r2++;
            } else {
                breaker.setItemDamage(breaker.getItemDamage() + 1);
            }
        }
    }
}
