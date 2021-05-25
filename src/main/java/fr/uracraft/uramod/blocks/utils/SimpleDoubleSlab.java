package fr.uracraft.uramod.blocks.utils;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SimpleDoubleSlab extends SimpleSlab
{

    public SimpleDoubleSlab(Material material, String name, SoundType sound)
    {
        super(material, name, sound);
    }

    @Override
    public boolean isDouble()
    {
        return true;
    }
}
