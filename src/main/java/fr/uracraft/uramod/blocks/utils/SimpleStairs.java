package fr.uracraft.uramod.blocks.utils;

import fr.uracraft.uramod.UraCreativeTabs;
import fr.uracraft.uramod.blocks.UraBlocks;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;

public class SimpleStairs extends BlockStairs {

    public SimpleStairs(IBlockState modelState, String name, Float hardness, Float resistance, String tool, int tool_lvl, SoundType sound)
    {
        super(modelState);
        setCreativeTab(UraCreativeTabs.BUILDING);
        UraBlocks.setBlockName(this,name);
        setLightOpacity((int) 1.0F);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(tool, tool_lvl);
        useNeighborBrightness = true;
        setSoundType(sound);
    }
}
