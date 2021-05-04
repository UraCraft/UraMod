package fr.uracraft.uramod.blocks;

import fr.uracraft.uramod.UraMod;
import fr.uracraft.uramod.blocks.utils.SimpleBlock;
import fr.uracraft.uramod.blocks.utils.SimpleOre;
import net.minecraft.block.Block;
import static fr.uracraft.uramod.UraCreativeTabs.URAMOD;

public class UraBlocks {

    public final static Block URA_ORE = new SimpleOre("ura_ore",3,URAMOD);
    public final static Block SILVER_ORE = new SimpleOre("silver_ore",2,URAMOD);
    public final static Block TIN_ORE = new SimpleOre("tin_ore",2,URAMOD);
    public final static Block COPPER_ORE = new SimpleOre("copper_ore",2,URAMOD);
    public final static Block NEODYMIUM_ORE = new NeodymiumOre();

    public final static Block URA_BLOCK = new SimpleBlock("ura_block",URAMOD);

    public static void setBlockName(Block block, String name)
    {
        block.setRegistryName(UraMod.MODID, name).setUnlocalizedName(UraMod.MODID + "." + name);
    }
}
