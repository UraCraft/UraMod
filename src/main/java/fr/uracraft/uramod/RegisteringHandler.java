package fr.uracraft.uramod;

import fr.uracraft.uramod.items.UraItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RegisteringHandler {
    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(

        );
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                UraItems.URA_INGOT
        );
    }

    public static void registerEntities() {

    }

    public static void registerRecipes() {

    }
}
