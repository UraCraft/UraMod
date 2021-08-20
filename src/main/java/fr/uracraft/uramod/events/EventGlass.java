package fr.uracraft.uramod.events;

import fr.uracraft.uramod.items.UraItems;
import fr.uracraft.uramod.utils.Random;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventGlass {

    Boolean glass;
    int meta;

    @SubscribeEvent
    public void onBreakBlock(BlockEvent.BreakEvent e) {
        if (e.getWorld().getBlockState(e.getPos()).getBlock() instanceof BlockStainedGlass || e.getWorld().getBlockState(e.getPos()).getBlock() instanceof BlockGlass) {
            if(e.getWorld().getBlockState(e.getPos()).getBlock() instanceof BlockStainedGlass){
                meta = e.getWorld().getBlockState(e.getPos()).getBlock().getMetaFromState(e.getWorld().getBlockState(e.getPos()));
            }else{
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
            if(glass && !e.isSilkTouching()){
                e.getDrops().add(new ItemStack(UraItems.GLASS_SHARD, Random.roll(1, 4), meta+1));
            }
        }
    }
}
