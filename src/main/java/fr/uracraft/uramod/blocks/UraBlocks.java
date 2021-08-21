package fr.uracraft.uramod.blocks;

import fr.uracraft.uramod.UraMod;
import fr.uracraft.uramod.blocks.chests.*;
import fr.uracraft.uramod.blocks.utils.*;
import fr.uracraft.uramod.items.UraItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

import static fr.uracraft.uramod.UraCreativeTabs.URAMOD;

public class UraBlocks {

    //Ores
    public final static Block URA_ORE = new SimpleOre("ura_ore", 3, URAMOD);
    public final static Block SILVER_ORE = new SimpleOre("silver_ore", 2, URAMOD);
    public final static Block TIN_ORE = new SimpleOre("tin_ore", 2, URAMOD);
    public final static Block COPPER_ORE = new SimpleOre("copper_ore", 2, URAMOD);
    public final static Block NEODYMIUM_ORE = new NeodymiumOre();
    public final static Block RANDOM_ORE = new RandomOre();
    public final static Block IRIDIUM_ORE = new IridiumOre();

    //Ore Blocks
    public final static Block URA_BLOCK = new SimpleBlock("ura_block", URAMOD, 5, 6, "pickaxe",2);
    public final static Block SILVER_BLOCK = new SimpleBlock("silver_block", URAMOD, 5, 6, "pickaxe",2);
    public final static Block TIN_BLOCK = new SimpleBlock("tin_block", URAMOD, 5, 6, "pickaxe",2);
    public final static Block COPPER_BLOCK = new SimpleBlock("copper_block", URAMOD, 5, 6, "pickaxe",2);
    public final static Block NEODYMIUM_BLOCK = new SimpleBlock("neodymium_block", URAMOD, 5, 6, "pickaxe",2);

    //Stairs
    public final static Block DIRT_STAIRS = new SimpleStairs(Blocks.DIRT.getDefaultState(), "dirt_stairs", 0.5F, 0.5F, "shovel", 0, SoundType.GROUND);
    public final static Block OBSIDIAN_STAIRS = new SimpleStairs(Blocks.OBSIDIAN.getDefaultState(), "obsidian_stairs", 50F, 1200F, "pickaxe", 3, SoundType.STONE);
    public final static Block BEDROCK_STAIRS = new SimpleStairs(Blocks.BEDROCK.getDefaultState(), "bedrock_stairs", -1F, 3600000F, "pickaxe", 3, SoundType.STONE);

    //Chests
    public final static Block URA_CHEST = new BlockUraChest();
    public final static Block DIAMOND_CHEST = new BlockDiamondChest();
    public final static Block SILVER_CHEST = new BlockSilverChest();
    public final static Block GOLD_CHEST = new BlockGoldChest();
    public final static Block IRON_CHEST = new BlockIronChest();
    public final static Block STONE_CHEST = new BlockStoneChest();

    //Other
    public static final Block URA_FURNACE = new BlockUraFurnace(false);
    public static final Block URA_FURNACE_LIT = new BlockUraFurnace(true);
    public final static Block BLOCK_ELEVATOR = new BlockElevator();
    public final static Block CASH_POINT = new BlockCashPoint();
    public final static Block BLOCK_STONE = new BlockStone();
    public final static Block BLOCK_BACKGROUND = new BlockBackground();
    public final static Block FERTILIZED_DIRT = new BlockFertilizedDirt(false);
    public final static Block FERTILIZED_DIRT_TILLED = new BlockFertilizedDirt(true);

    //Slabs
    public static final SimpleSlab DIRT_DOUBLESLAB = new SimpleDoubleSlab(Material.ROCK, "dirt_doubleslab", SoundType.GROUND);
    public static final SimpleSlab DIRT_HALFSLAB = new SimpleHalfSlab(Material.ROCK, "dirt_halfslab", SoundType.GROUND);
    public static final SimpleSlab OBSIDIAN_DOUBLESLAB = new SimpleDoubleSlab(Material.ROCK, "obsidian_doubleslab", SoundType.STONE);
    public static final SimpleSlab OBSIDIAN_HALFSLAB = new SimpleHalfSlab(Material.ROCK, "obsidian_halfslab", SoundType.STONE);
    public static final SimpleSlab BEDROCK_DOUBLESLAB = new SimpleDoubleSlab(Material.ROCK, "bedrock_doubleslab", SoundType.STONE);
    public static final SimpleSlab BEDROCK_HALFSLAB = new SimpleHalfSlab(Material.ROCK, "bedrock_halfslab", SoundType.STONE);

    static {
        DIRT_DOUBLESLAB.setItem(UraItems.BLOCK_DIRT_SLAB).setResistance(6F).setHardness(1.5F);
        DIRT_HALFSLAB.setItem(UraItems.BLOCK_DIRT_SLAB).setResistance(6F).setHardness(1.5F);
        OBSIDIAN_DOUBLESLAB.setItem(UraItems.BLOCK_OBSIDIAN_SLAB).setResistance(1200F).setHardness(50F);
        OBSIDIAN_HALFSLAB.setItem(UraItems.BLOCK_OBSIDIAN_SLAB).setResistance(1200F).setHardness(50F);
        BEDROCK_DOUBLESLAB.setItem(UraItems.BLOCK_BEDROCK_SLAB).setResistance(3600000F).setHardness(-1F);
        BEDROCK_HALFSLAB.setItem(UraItems.BLOCK_BEDROCK_SLAB).setResistance(3600000F).setHardness(-1F);
    }

    public static void setBlockName(Block block, String name) {
        block.setRegistryName(UraMod.MODID, name).setUnlocalizedName(UraMod.MODID + "." + name);
    }
}