package fr.uracraft.uramod.events;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventGrass {

    @SubscribeEvent
    public void changeBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getEntityPlayer() != null) {
            World world = event.getEntityPlayer().world;
            if (world.getBlockState(event.getPos()) == Blocks.DIRT.getDefaultState()) {
                ItemStack stack = event.getEntityPlayer().getHeldItem(EnumHand.MAIN_HAND);
                if (stack.getItem() instanceof ItemSpade) {
                    world.setBlockState(event.getPos(), Blocks.GRASS_PATH.getDefaultState());
                    stack.damageItem(1, event.getEntityPlayer());
                    world.playSound(event.getEntityPlayer(), event.getPos(), SoundEvents.BLOCK_GRAVEL_HIT, SoundCategory.AMBIENT, 1.0F, 0.8F);
                }
                if (stack.getItem() == Items.DYE && stack.getMetadata() == 15) {
                    world.setBlockState(event.getPos(), Blocks.GRASS.getDefaultState());
                    stack.setCount(stack.getCount() - 1);
                    event.setCanceled(true);
                }
            }
        }
    }
}
