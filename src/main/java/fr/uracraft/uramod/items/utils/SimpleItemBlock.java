package fr.uracraft.uramod.items.utils;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class SimpleItemBlock extends ItemBlock {
    public SimpleItemBlock(Block block){
        super(block);
        setRegistryName(block.getRegistryName());
    }
}
