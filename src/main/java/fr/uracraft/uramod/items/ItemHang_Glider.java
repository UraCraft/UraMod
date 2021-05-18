package fr.uracraft.uramod.items;

import fr.uracraft.uramod.UraCreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class ItemHang_Glider extends Item
{

    public static List<EntityPlayer> usingHangGliderClient = new ArrayList<EntityPlayer>();
    public static List<EntityPlayer> usingHangGliderServer = new ArrayList<EntityPlayer>();

    public ItemHang_Glider() {
        super();
        UraItems.setItemName(this, "hang_glider");
        setCreativeTab(UraCreativeTabs.URAMOD);
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handin) {

        ItemStack stack = player.getHeldItem(handin);

        if (world.isRemote) {
            if (!usingHangGliderClient.contains(player)) {
                usingHangGliderClient.add(player);
                return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
            }
            usingHangGliderClient.remove(player);
        }
        if (!world.isRemote) {
            if (!usingHangGliderServer.contains(player)) {
                usingHangGliderServer.add(player);
                return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
            }
            usingHangGliderServer.remove(player);
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_) {
        super.onUpdate(stack, world, entity, p_77663_4_, p_77663_5_);
        if (!(entity instanceof EntityPlayer)) return;
        EntityPlayer player = (EntityPlayer)entity;
        if(player.world.isRemote) {
            if(player.collidedVertically || (player.inventory.getCurrentItem() == null || player.inventory.getCurrentItem().getItem() == null || player.inventory.getCurrentItem().getItem() != UraItems.HANG_GLIDER)) usingHangGliderClient.remove(player);
            if(usingHangGliderClient.contains(player) && player.motionY < 0.0D) {
                double horizontalSpeed, verticalSpeed;
                if (player.isSneaking()) {
                    horizontalSpeed = 0.1D;
                    verticalSpeed = 0.9D;
                } else {
                    horizontalSpeed = 0.03D;
                    verticalSpeed = 0.7D;
                }
                player.motionY *= verticalSpeed;
                double x = Math.cos(Math.toRadians((player.rotationYawHead + 90.0F))) * horizontalSpeed;
                double z = Math.sin(Math.toRadians((player.rotationYawHead + 90.0F))) * horizontalSpeed;
                player.motionX += x;
                player.motionZ += z;
                player.fallDistance = 0.1F;
            }
        }
        if (!player.world.isRemote) {
            if (player.collidedVertically || (player.inventory.getCurrentItem() == null || player.inventory.getCurrentItem().getItem() == null || player.inventory.getCurrentItem().getItem() != UraItems.HANG_GLIDER)) usingHangGliderServer.remove(player);
            if (usingHangGliderServer.contains(player) && player.motionY < 0.0D) {
                double horizontalSpeed, verticalSpeed;
                if (player.isSneaking()) {
                    horizontalSpeed = 0.1D;
                    verticalSpeed = 0.7D;
                } else {
                    horizontalSpeed = 0.03D;
                    verticalSpeed = 0.4D;
                }
                player.motionY *= verticalSpeed;
                double x = Math.cos(Math.toRadians((player.rotationYawHead + 90.0F))) * horizontalSpeed;
                double z = Math.sin(Math.toRadians((player.rotationYawHead + 90.0F))) * horizontalSpeed;
                player.motionX += x;
                player.motionZ += z;
                player.fallDistance = 0.1F;
            }
        }
    }
}
