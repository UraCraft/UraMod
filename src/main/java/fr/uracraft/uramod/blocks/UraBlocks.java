package fr.uracraft.uramod.blocks;

import fr.uracraft.uramod.UraMod;
import fr.uracraft.uramod.blocks.utils.*;
import fr.uracraft.uramod.items.UraItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

import static fr.uracraft.uramod.UraCreativeTabs.URAMOD;

public class UraBlocks {

    public final static Block URA_ORE = new SimpleOre("ura_ore",3,URAMOD);
    public final static Block SILVER_ORE = new SimpleOre("silver_ore",2,URAMOD);
    public final static Block TIN_ORE = new SimpleOre("tin_ore",2,URAMOD);
    public final static Block COPPER_ORE = new SimpleOre("copper_ore",2,URAMOD);
    public final static Block NEODYMIUM_ORE = new NeodymiumOre();
    public static final Block URA_FURNACE = new BlockUraFurnace(false);
    public static final Block URA_FURNACE_LIT = new BlockUraFurnace(true);

    public final static Block URA_BLOCK = new SimpleBlock("ura_block",URAMOD);
    public final static Block SILVER_BLOCK = new SimpleBlock("silver_block",URAMOD);
    public final static Block TIN_BLOCK = new SimpleBlock("tin_block",URAMOD);
    public final static Block COPPER_BLOCK = new SimpleBlock("copper_block",URAMOD);
    public final static Block NEODYMIUM_BLOCK = new SimpleBlock("neodymium_block",URAMOD);

    public final static Block CASH_POINT = new SimpleBlock("cash_point",URAMOD);
    public final static Block DIRT_STAIRS = new SimpleStairs(Blocks.DIRT.getDefaultState(), "dirt_stairs", 0.5F, 0.5F, "shovel", 0, SoundType.GROUND);
    public static final SimpleSlab DIRT_DOUBLESLAB = new SimpleDoubleSlab(Material.ROCK, "dirt_doubleslab", SoundType.GROUND);
    public static final SimpleSlab DIRT_HALFSLAB = new SimpleHalfSlab(Material.ROCK, "dirt_halfslab", SoundType.GROUND);

    static {
        DIRT_DOUBLESLAB.setItem(UraItems.BLOCK_DIRT_SLAB).setResistance(6F).setHardness(1.5F);
        DIRT_HALFSLAB.setItem(UraItems.BLOCK_DIRT_SLAB).setResistance(6F).setHardness(1.5F);
    }

    public static void setBlockName(Block block, String name)
    {
        block.setRegistryName(UraMod.MODID, name).setUnlocalizedName(UraMod.MODID + "." + name);
    }
}