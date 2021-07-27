package fr.uracraft.uramod.items.tools;

import fr.uracraft.uramod.UraCreativeTabs;
import fr.uracraft.uramod.items.UraItems;

public class ItemPickaxe extends net.minecraft.item.ItemPickaxe {

    public ItemPickaxe(ToolMaterial material, String name) {
        super(material);
        UraItems.setItemName(this, name);
        setCreativeTab(UraCreativeTabs.URAMOD);
    }
}
