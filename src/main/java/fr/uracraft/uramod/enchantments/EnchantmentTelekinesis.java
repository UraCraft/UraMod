package fr.uracraft.uramod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentTelekinesis extends Enchantment {

    public static int id = 12;

    public EnchantmentTelekinesis() {

        super(Rarity.COMMON, EnumEnchantmentType.DIGGER, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
        setName("telekinesis");
        setRegistryName("telekinesis");
    }

    public int getMinEnchantability(int enchantmentLevel)
    {
        return 30;
    }

    public int getMaxEnchantability(int enchantmentLevel)
    {
        return 30;
    }

    public int getMaxLevel()
    {
        return 1;
    }
}
