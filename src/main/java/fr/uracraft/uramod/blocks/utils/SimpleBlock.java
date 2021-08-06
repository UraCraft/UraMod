package fr.uracraft.uramod.blocks.utils;

import fr.uracraft.uramod.blocks.UraBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class SimpleBlock extends Block {
    public SimpleBlock(String name, CreativeTabs tab, float hardness, float resistance, String tool, int toolLvl) {
        super(Material.ROCK);
        setCreativeTab(tab);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(tool, toolLvl);
        UraBlocks.setBlockName(this,name);
    }
}
