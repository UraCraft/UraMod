package fr.uracraft.uramod.items.armors;

import fr.uracraft.uramod.UraMod;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class UraArmorMaterials {
    public static final ItemArmor.ArmorMaterial URA_ARMOR = EnumHelper.addArmorMaterial("ura_armor", UraMod.MODID + ":ura", 33, new int[]{2, 7, 5, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
    public static final ItemArmor.ArmorMaterial IRIDIUM_ARMOR = EnumHelper.addArmorMaterial("iridium_armor", UraMod.MODID + ":iridium", 66, new int[]{3, 8, 6, 3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0F);
    public static final ItemArmor.ArmorMaterial SILVER_ARMOR = EnumHelper.addArmorMaterial("silver_armor", UraMod.MODID + ":silver", 14, new int[]{1, 2, 1, 1}, 25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
}