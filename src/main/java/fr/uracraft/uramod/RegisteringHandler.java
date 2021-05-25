package fr.uracraft.uramod;

import fr.uracraft.uramod.blocks.UraBlocks;
import fr.uracraft.uramod.items.UraItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;


public class RegisteringHandler {
    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                UraBlocks.COPPER_ORE,
                UraBlocks.SILVER_ORE,
                UraBlocks.URA_ORE,
                UraBlocks.TIN_ORE,
                UraBlocks.NEODYMIUM_ORE,
                UraBlocks.URA_BLOCK,
                UraBlocks.URA_FURNACE_LIT,
                UraBlocks.URA_FURNACE,
                UraBlocks.SILVER_BLOCK,
                UraBlocks.TIN_BLOCK,
                UraBlocks.COPPER_BLOCK,
                UraBlocks.NEODYMIUM_BLOCK,
                UraBlocks.CASH_POINT,
                UraBlocks.DIRT_STAIRS,
                UraBlocks.IRIDIUM_ORE
                UraBlocks.DIRT_HALFSLAB,
                UraBlocks.DIRT_DOUBLESLAB
        );
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                UraItems.HANG_GLIDER,
                UraItems.URA_HELMET,
                UraItems.URA_CHESTPLATE,
                UraItems.URA_LEGGINGS,
                UraItems.URA_BOOTS,
                UraItems.IRIDIUM_HELMET,
                UraItems.IRIDIUM_CHESTPLATE,
                UraItems.IRIDIUM_LEGGINGS,
                UraItems.IRIDIUM_BOOTS,
                UraItems.URA_NUGGET,
                UraItems.SILVER_NUGGET,
                UraItems.TIN_NUGGET,
                UraItems.COPPER_NUGGET,
                UraItems.URA_INGOT,
                UraItems.NEODYMIUM,
                UraItems.SILVER_INGOT,
                UraItems.COPPER_INGOT,
                UraItems.TIN_INGOT,
                UraItems.COPPER_ORE_ITEM,
                UraItems.SILVER_ORE_ITEM,
                UraItems.URA_ORE_ITEM,
                UraItems.TIN_ORE_ITEM,
                UraItems.URA_BLOCK_ITEM,
                UraItems.SILVER_BLOCK_ITEM,
                UraItems.TIN_BLOCK_ITEM,
                UraItems.COPPER_BLOCK_ITEM,
                UraItems.NEODYMIUM_BLOCK_ITEM,
                UraItems.NEODYMIUM_ORE_ITEM,
                UraItems.CASH_POINT_BLOCK_ITEM,
                UraItems.BLOCK_DIRT_STAIRS,
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
                UraItems.PAINT_BUCKET_BLACK,
                UraItems.BLOCK_DIRT_SLAB
                UraItems.URA_FURNACE_ITEM,
                UraItems.DIAMOND_UPGRADE,
                UraItems.URA_UPGRADE,
                UraItems.IRIDIUM_UPGRADE,
                UraItems.NEODYMIUM_UPGRADE,
                UraItems.SILVER_UPGRADE,
                UraItems.IRIDIUM_ORE_BLOCK_ITEM,
                UraItems.IRIDIUM_NUGGET
        );
    }

    public static void registerEntities() {

    }

    public static void registerRecipes() {

    }
}
