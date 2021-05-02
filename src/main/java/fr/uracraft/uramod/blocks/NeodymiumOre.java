package fr.uracraft.uramod.blocks;

import fr.uracraft.uramod.UraCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class NeodymiumOre extends Block {
    public NeodymiumOre() {
        super(Material.ROCK);
        setHardness(3.0F);
        setHarvestLevel("pickaxe", 4);
        setCreativeTab(UraCreativeTabs.URAMOD);
        UraBlocks.setBlockName(this, "neodymium_ore");
    }

   // @Override
   // public Item getItemDropped(IBlockState state, Random rand, int fortune) {
   //     return UraItems.NEODYMIUM;
   // }
}
