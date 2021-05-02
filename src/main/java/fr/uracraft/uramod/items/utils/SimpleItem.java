package fr.uracraft.uramod.items.utils;

import fr.uracraft.uramod.items.UraItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SimpleItem extends Item
{
    public SimpleItem(String name, CreativeTabs tab) {
        super();
        UraItems.setItemName(this, name);
        setCreativeTab(tab);
    }
}
