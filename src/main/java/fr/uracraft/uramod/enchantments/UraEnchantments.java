package fr.uracraft.uramod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;

public class UraEnchantments {

    public static Enchantment TELEKINESIS = new EnchantmentTelekinesis();
    public static Enchantment STONEBREAKER = new EnchantmentStoneBreaker();

    public static boolean hasEnchantment(ItemStack stack, int id) {
        for (int i = 0; i < stack.getEnchantmentTagList().tagCount(); i++) {
            if (stack.getEnchantmentTagList().getCompoundTagAt(i).getShort("id") == id) {
                return true;
            }
        }
        return false;
    }
}
