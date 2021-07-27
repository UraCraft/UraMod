package fr.uracraft.uramod;

import fr.uracraft.uramod.blocks.UraBlocks;
import fr.uracraft.uramod.enchantments.UraEnchantments;
import fr.uracraft.uramod.items.UraItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RegisteringHandler {

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                //Ores
                UraBlocks.COPPER_ORE,
                UraBlocks.SILVER_ORE,
                UraBlocks.URA_ORE,
                UraBlocks.TIN_ORE,
                UraBlocks.NEODYMIUM_ORE,
                UraBlocks.RANDOM_ORE,
                UraBlocks.IRIDIUM_ORE,
                //Ores Blocks
                UraBlocks.SILVER_BLOCK,
                UraBlocks.TIN_BLOCK,
                UraBlocks.COPPER_BLOCK,
                UraBlocks.NEODYMIUM_BLOCK,
                UraBlocks.URA_BLOCK,
                //Stairs
                UraBlocks.OBSIDIAN_STAIRS,
                UraBlocks.DIRT_STAIRS,
                UraBlocks.BEDROCK_STAIRS,
                //Slabs
                UraBlocks.OBSIDIAN_HALFSLAB,
                UraBlocks.OBSIDIAN_DOUBLESLAB,
                UraBlocks.BEDROCK_HALFSLAB,
                UraBlocks.BEDROCK_DOUBLESLAB,
                UraBlocks.DIRT_HALFSLAB,
                UraBlocks.DIRT_DOUBLESLAB,
                //Other
                UraBlocks.URA_FURNACE_LIT,
                UraBlocks.URA_FURNACE,
                UraBlocks.CASH_POINT,
                UraBlocks.BLOCK_ELEVATOR
        );
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                //Ingots
                UraItems.URA_INGOT,
                UraItems.IRIDIUM_INGOT,
                UraItems.NEODYMIUM,
                UraItems.SILVER_INGOT,
                UraItems.COPPER_INGOT,
                UraItems.TIN_INGOT,
                //Nuggets
                UraItems.URA_NUGGET,
                UraItems.SILVER_NUGGET,
                UraItems.TIN_NUGGET,
                UraItems.COPPER_NUGGET,
                UraItems.IRIDIUM_NUGGET,
                //Particles
                UraItems.SILVER_PARTICLE,
                UraItems.COPPER_PARTICLE,
                UraItems.TIN_PARTICLE,
                UraItems.URA_PARTICLE,
                //Paint Buckets
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
                //Furnace Upgrades
                UraItems.URA_UPGRADE,
                UraItems.IRIDIUM_UPGRADE,
                UraItems.NEODYMIUM_UPGRADE,
                UraItems.SILVER_UPGRADE,
                UraItems.DIAMOND_UPGRADE,
                //Armors
                UraItems.URA_HELMET,
                UraItems.URA_CHESTPLATE,
                UraItems.URA_LEGGINGS,
                UraItems.URA_BOOTS,
                UraItems.IRIDIUM_HELMET,
                UraItems.IRIDIUM_CHESTPLATE,
                UraItems.IRIDIUM_LEGGINGS,
                UraItems.IRIDIUM_BOOTS,
                UraItems.SILVER_HELMET,
                UraItems.SILVER_CHESTPLATE,
                UraItems.SILVER_LEGGINGS,
                UraItems.SILVER_BOOTS,
                //Tools
                UraItems.URA_PICKAXE,
                UraItems.URA_SWORD,
                UraItems.URA_SHOVEL,
                UraItems.URA_AXE,
                UraItems.URA_HOE,
                UraItems.SILVER_PICKAXE,
                UraItems.SILVER_SWORD,
                UraItems.SILVER_SHOVEL,
                UraItems.SILVER_AXE,
                UraItems.SILVER_HOE,
                UraItems.IRIDIUM_PICKAXE,
                UraItems.IRIDIUM_SWORD,
                UraItems.HAMMER,
                //Other
                UraItems.HANG_GLIDER,
                UraItems.WORLD_SELECTOR,
                UraItems.PORTABLE_WORKBENCH,

                //////////////////////////////////////////Items Blocks//////////////////////////////////////////////////

                //Ores
                UraItems.COPPER_ORE_ITEM,
                UraItems.SILVER_ORE_ITEM,
                UraItems.URA_ORE_ITEM,
                UraItems.TIN_ORE_ITEM,
                UraItems.NEODYMIUM_ORE_ITEM,
                UraItems.IRIDIUM_ORE_BLOCK_ITEM,
                UraItems.RANDOM_ORE_BLOCK_ITEM,
                //Ore Blocks
                UraItems.URA_BLOCK_ITEM,
                UraItems.SILVER_BLOCK_ITEM,
                UraItems.TIN_BLOCK_ITEM,
                UraItems.COPPER_BLOCK_ITEM,
                UraItems.NEODYMIUM_BLOCK_ITEM,
                //Stairs
                UraItems.BLOCK_DIRT_STAIRS,
                UraItems.BLOCK_OBSIDIAN_STAIRS,
                UraItems.BLOCK_BEDROCK_STAIRS,
                //Slabs
                UraItems.BLOCK_DIRT_SLAB,
                UraItems.BLOCK_OBSIDIAN_SLAB,
                UraItems.BLOCK_BEDROCK_SLAB,
                //Others
                UraItems.CASH_POINT_BLOCK_ITEM,
                UraItems.URA_FURNACE_ITEM,
                UraItems.BLOCK_ELEVATOR_ITEM
        );
    }

    @SubscribeEvent
    public void registerEnchantments(RegistryEvent.Register<Enchantment> e) {
        e.getRegistry().registerAll(
                UraEnchantments.STONEBREAKER,
                UraEnchantments.TELEKINESIS
        );
    }

    public static void registerEntities() {

    }

    public static void registerRecipes() {

    }
}
