package fr.uracraft.uramod.items.tools;

import fr.uracraft.uramod.UraCreativeTabs;
import fr.uracraft.uramod.items.UraItems;

public class ItemAxe extends net.minecraft.item.ItemAxe {

    public ItemAxe(ToolMaterial material, float damage, float speed, String name) {
        super(material, damage, speed);
        UraItems.setItemName(this, name);
        setCreativeTab(UraCreativeTabs.URAMOD);
    }
}