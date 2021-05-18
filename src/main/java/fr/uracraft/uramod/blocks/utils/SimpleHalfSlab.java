package fr.uracraft.uramod.blocks.utils;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SimpleHalfSlab extends SimpleSlab
{
    public SimpleHalfSlab(Material material, String name, SoundType sound)
    {
        super(material, name, sound);
    }

    @Override
    public boolean isDouble()
    {
        return false;
    }
}
