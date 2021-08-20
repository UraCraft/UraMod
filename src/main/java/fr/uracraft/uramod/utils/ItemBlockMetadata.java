package fr.uracraft.uramod.utils;

import fr.uracraft.uramod.UraMod;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMetadata extends ItemBlock
{
    String[] unlocalizedNames;

    public ItemBlockMetadata(Block block, String[] unlocalizedNamesIn)
    {
        super(block);
        this.unlocalizedNames = unlocalizedNamesIn;
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return "tile." + UraMod.MODID + "." + unlocalizedNames[stack.getMetadata()];
    }
}