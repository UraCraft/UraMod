package fr.uracraft.uramod;

import fr.uracraft.uramod.blocks.UraBlocks;
import fr.uracraft.uramod.items.UraItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class RegisteringHandler {
    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                UraBlocks.COPPER_ORE,
                UraBlocks.SILVER_ORE,
                UraBlocks.URA_ORE,
                UraBlocks.TIN_ORE,
                UraBlocks.NEODYMIUM_ORE
        );
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                UraItems.URA_INGOT,
                UraItems.NEODYMIUM,
                UraItems.SILVER_INGOT,
                UraItems.COPPER_INGOT,
                UraItems.TIN_INGOT,
                UraItems.COPPER_ORE_ITEM,
                UraItems.SILVER_ORE_ITEM,
                UraItems.URA_ORE_ITEM,
                UraItems.TIN_ORE_ITEM,
                UraItems.NEODYMIUM_ORE_ITEM,
                UraItems.PAINT_BUCKET_WHITE,
                UraItems.PAINT_BUCKET_ORANGE,
                UraItems.PAINT_BUCKET_MAGENTA,
                UraItems.PAINT_BUCKET_LIGHT_BLUE,
                UraItems.PAINT_BUCKET_YELLOW,
                UraItems.PAINT_BUCKET_LIME,
                UraItems.PAINT_BUCKET_PINK,
                UraItems.PAINT_BUCKET_GRAY,
                UraItems.PAINT_BUCKET_SILVER,
                UraItems.PAINT_BUCKET_CYAN,
                UraItems.PAINT_BUCKET_PURPLE,
                UraItems.PAINT_BUCKET_BLUE,
                UraItems.PAINT_BUCKET_BROWN,
                UraItems.PAINT_BUCKET_GREEN,
                UraItems.PAINT_BUCKET_RED,
                UraItems.PAINT_BUCKET_BLACK
        );
    }

    public static void registerEntities() {

    }

    public static void registerRecipes() {

    }
}
