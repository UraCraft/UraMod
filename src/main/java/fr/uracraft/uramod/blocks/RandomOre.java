package fr.uracraft.uramod.blocks;

import fr.uracraft.uramod.UraCreativeTabs;
import fr.uracraft.uramod.items.UraItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.Random;

@SuppressWarnings("all")
public class RandomOre extends Block {

    public RandomOre() {
        super(Material.ROCK);
        setHardness(3.0F);
        setHarvestLevel("pickaxe", 2);
        setCreativeTab(UraCreativeTabs.URAMOD);
        UraBlocks.setBlockName(this, "random_ore");
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        switch (fr.uracraft.uramod.utils.Random.roll(0, 5)) {
            case 0:
                return Items.DIAMOND;
            case 1:
                return UraItems.SILVER_INGOT;
            case 2:
                return UraItems.TIN_INGOT;
            case 3:
                return UraItems.COPPER_INGOT;
            case 4:
                return UraItems.URA_INGOT;
            case 5:
                return UraItems.NEODYMIUM;
        }
        return null;
    }


    public int quantityDropped(Random random)
    {
        return fr.uracraft.uramod.utils.Random.roll(1, 3);
    }
}
