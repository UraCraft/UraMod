package fr.uracraft.uramod.blocks;

import fr.uracraft.uramod.UraCreativeTabs;
import fr.uracraft.uramod.items.UraItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

@SuppressWarnings("all")
public class NeodymiumOre extends Block {
    public NeodymiumOre() {
        super(Material.ROCK);
        setHardness(3.0F);
        setHarvestLevel("pickaxe", 3);
        setCreativeTab(UraCreativeTabs.URAMOD);
        UraBlocks.setBlockName(this, "neodymium_ore");
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return UraItems.NEODYMIUM;
    }

    public int quantityDropped(Random random)
    {
        return fr.uracraft.uramod.utils.Random.roll(1, 2);
    }
}
