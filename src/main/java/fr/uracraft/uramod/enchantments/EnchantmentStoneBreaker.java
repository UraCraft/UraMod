package fr.uracraft.uramod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentStoneBreaker extends Enchantment {

    public static int id = 13;

    public EnchantmentStoneBreaker() {

        super(Rarity.COMMON, EnumEnchantmentType.DIGGER, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
        setName("stonebreaker");
        setRegistryName("stonebreaker");
    }

    public int getMinEnchantability(int enchantmentLevel)
    {
        return 12;
    }

    public int getMaxEnchantability(int enchantmentLevel)
    {
        return 30;
    }

    public int getMaxLevel()
    {
        return 3;
    }
}
