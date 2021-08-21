package fr.uracraft.uramod.events;

import fr.uracraft.uramod.blocks.UraBlocks;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventFertilizedDirt {

    @SubscribeEvent
    public void useHoe(UseHoeEvent event) {
        if (event.getWorld().getBlockState(event.getPos()).getBlock() == UraBlocks.FERTILIZED_DIRT) {
            event.setResult(Event.Result.ALLOW);
            event.getWorld().setBlockState(event.getPos(), UraBlocks.FERTILIZED_DIRT_TILLED.getDefaultState());
        }
    }
}