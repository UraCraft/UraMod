package fr.uracraft.uramod.items;

import fr.uracraft.uramod.UraCreativeTabs;
import net.minecraft.item.Item;

public class ItemUpgrade extends Item {
    public ItemUpgrade(String name,int max_damage) {
        UraItems.setItemName(this, name);
        setCreativeTab(UraCreativeTabs.URAMOD);
        setMaxDamage(max_damage);
        this.maxStackSize = 1;
    }
}
