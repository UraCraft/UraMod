package fr.uracraft.uramod.blocks;

import fr.uracraft.uramod.UraCreativeTabs;
import fr.uracraft.uramod.items.UraItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

import java.util.Random;


public class IridiumOre extends Block {
    public IridiumOre() {
        super(Material.ROCK);
        setHardness(3.0F);
        setResistance(15.0F);
        setHarvestLevel("pickaxe", 3);
        setCreativeTab(UraCreativeTabs.URAMOD);
        UraBlocks.setBlockName(this, "iridium_ore");
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return UraItems.IRIDIUM_NUGGET;
    }

    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune))
        {
            int i = random.nextInt(fortune-1);

            if (i < 0)
            {
                i = 0;
            }

            return this.quantityDropped(random) + i;
        }
        else
        {
            return this.quantityDropped(random);
        }
    }
    public int quantityDropped(Random random)
    {
        return random.nextInt(4) > 2 ? 1 : 0;
    }
}
