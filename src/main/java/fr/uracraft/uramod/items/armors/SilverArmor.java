package fr.uracraft.uramod.items.armors;

import fr.uracraft.uramod.UraCreativeTabs;
import fr.uracraft.uramod.items.UraItems;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class SilverArmor extends ItemArmor {

    public SilverArmor(String name, int renderIndex, EntityEquipmentSlot equipmentSlot) {
        super(UraArmorMaterials.SILVER_ARMOR, renderIndex, equipmentSlot);
        setCreativeTab(UraCreativeTabs.URAMOD);
        UraItems.setItemName(this, name);
    }
}
