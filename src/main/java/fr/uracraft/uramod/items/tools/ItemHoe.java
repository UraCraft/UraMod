package fr.uracraft.uramod.items.tools;

import fr.uracraft.uramod.UraCreativeTabs;
import fr.uracraft.uramod.items.UraItems;

public class ItemHoe extends net.minecraft.item.ItemHoe {

    public ItemHoe(ToolMaterial material, String name) {
        super(material);
        UraItems.setItemName(this, name);
        setCreativeTab(UraCreativeTabs.URAMOD);
    }
}
