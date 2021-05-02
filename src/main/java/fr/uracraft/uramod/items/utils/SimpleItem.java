package fr.uracraft.uramod.items.utils;

import fr.uracraft.uramod.items.UraItems;
import net.minecraft.item.Item;

public class SimpleItem extends Item
{
    public SimpleItem(String name) {
        super();
        UraItems.setItemName(this, name);
    }
}
