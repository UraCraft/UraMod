package fr.uracraft.uramod.items.tools;

import fr.uracraft.uramod.UraCreativeTabs;
import fr.uracraft.uramod.items.UraItems;
import net.minecraft.item.ItemSpade;

public class ItemShovel extends ItemSpade {

    public ItemShovel(ToolMaterial material, String name) {
        super(material);
        UraItems.setItemName(this, name);
        setCreativeTab(UraCreativeTabs.URAMOD);
    }
}
