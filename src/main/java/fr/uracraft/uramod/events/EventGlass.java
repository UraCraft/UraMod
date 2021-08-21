package fr.uracraft.uramod.events;

import fr.uracraft.uramod.items.UraItems;
import fr.uracraft.uramod.utils.Random;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventGlass {

    Boolean glass;
    int type = 0;
    int meta;

    @SubscribeEvent
    public void onBreakBlock(BlockEvent.BreakEvent e) {
        if (e.getWorld().getBlockState(e.getPos()).getBlock() instanceof BlockStainedGlass || e.getWorld().getBlockState(e.getPos()).getBlock() instanceof BlockGlass || e.getWorld().getBlockState(e.getPos()).getBlock() instanceof BlockStainedGlassPane || e.getWorld().getBlockState(e.getPos()).getBlock() == Blocks.GLASS_PANE) {
            if (e.getWorld().getBlockState(e.getPos()).getBlock() instanceof BlockStainedGlass || e.getWorld().getBlockState(e.getPos()).getBlock() instanceof BlockStainedGlassPane) {
                if (e.getWorld().getBlockState(e.getPos()).getBlock() instanceof BlockStainedGlass) {
                    type = 0;
                } else {
                    type = 1;
                }
                meta = e.getWorld().getBlockState(e.getPos()).getBlock().getMetaFromState(e.getWorld().getBlockState(e.getPos()));
            } else {
                if (e.getWorld().getBlockState(e.getPos()).getBlock() instanceof BlockGlass) {
                    type = 0;
                } else {
                    type = 1;
                }
                meta = -1;
            }
            glass = true;
        } else {
            glass = false;
        }
    }

    @SubscribeEvent
    public void onHarvestDrops(BlockEvent.HarvestDropsEvent e) {
        if ((e.getHarvester() != null)) {
            if (glass && !e.isSilkTouching()) {
                if(type == 0){
                    e.getDrops().add(new ItemStack(UraItems.GLASS_SHARD, Random.roll(1, 4), meta + 1));
                }else {
                    e.getDrops().add(new ItemStack(UraItems.GLASS_SHARD, Random.roll(1, 2), meta + 1));
                }
            }
        }
    }
}
