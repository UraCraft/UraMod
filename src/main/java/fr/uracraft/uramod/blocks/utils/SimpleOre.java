package fr.uracraft.uramod.blocks.utils;

import fr.uracraft.uramod.blocks.UraBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class SimpleOre extends Block {
    public SimpleOre(String name, int harvest_level, CreativeTabs tab) {
        super(Material.ROCK);
        setHardness(3.0F);
        setHarvestLevel("pickaxe",harvest_level);
        setCreativeTab(tab);
        UraBlocks.setBlockName(this,name);
    }
}
