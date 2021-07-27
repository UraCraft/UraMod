package fr.uracraft.uramod.items.armors;

import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class PatchVanillaArmors {

    public static void armors(FMLPreInitializationEvent event) {

        //Diamond Armor Reforged
        ItemArmor.ArmorMaterial customDiam = EnumHelper.addArmorMaterial("CUSTOM_DIAMOND", "diamond", 33, new int[] {2, 5, 4, 1}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0);
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.DIAMOND_HELMET, customDiam, "material", "field_77878_bZ");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.DIAMOND_CHESTPLATE, customDiam, "material", "field_77878_bZ");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.DIAMOND_LEGGINGS, customDiam, "material", "field_77878_bZ");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.DIAMOND_BOOTS, customDiam, "material", "field_77878_bZ");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.DIAMOND_HELMET, 2, "damageReduceAmount", "field_77879_b");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.DIAMOND_CHESTPLATE, 5, "damageReduceAmount", "field_77879_b");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.DIAMOND_LEGGINGS, 4, "damageReduceAmount", "field_77879_b");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.DIAMOND_BOOTS, 1, "damageReduceAmount", "field_77879_b");

        //Iron Armor Reforged
        ItemArmor.ArmorMaterial customIron = EnumHelper.addArmorMaterial("CUSTOM_IRON", "iron", 15, new int[] {2, 5, 3, 1}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.IRON_HELMET, customIron, "material", "field_77878_bZ");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.IRON_CHESTPLATE, customIron, "material", "field_77878_bZ");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.IRON_LEGGINGS, customIron, "material", "field_77878_bZ");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.IRON_BOOTS, customIron, "material", "field_77878_bZ");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.IRON_HELMET, 2, "damageReduceAmount", "field_77879_b");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.IRON_CHESTPLATE, 5, "damageReduceAmount", "field_77879_b");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.IRON_LEGGINGS, 3, "damageReduceAmount", "field_77879_b");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.IRON_BOOTS, 1, "damageReduceAmount", "field_77879_b");

        //Gold Armor Reforged
        ItemArmor.ArmorMaterial customGold = EnumHelper.addArmorMaterial("CUSTOM_GOLD", "gold", 7, new int[] {1, 2, 1, 1}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0);
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.GOLDEN_HELMET, customGold, "material", "field_77878_bZ");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.GOLDEN_CHESTPLATE, customGold, "material", "field_77878_bZ");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.GOLDEN_LEGGINGS, customGold, "material", "field_77878_bZ");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.GOLDEN_BOOTS, customGold, "material", "field_77878_bZ");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.GOLDEN_HELMET, 1, "damageReduceAmount", "field_77879_b");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.GOLDEN_CHESTPLATE, 2, "damageReduceAmount", "field_77879_b");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.GOLDEN_LEGGINGS, 1, "damageReduceAmount", "field_77879_b");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.GOLDEN_BOOTS, 1, "damageReduceAmount", "field_77879_b");

        //Leather Armor Reforged
        ItemArmor.ArmorMaterial customLeather = EnumHelper.addArmorMaterial("CUSTOM_LEATHER", "leather", 5, new int[] {1, 1, 1, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.LEATHER_HELMET, customLeather, "material", "field_77878_bZ");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.LEATHER_CHESTPLATE, customLeather, "material", "field_77878_bZ");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.LEATHER_LEGGINGS, customLeather, "material", "field_77878_bZ");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.LEATHER_BOOTS, customLeather, "material", "field_77878_bZ");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.LEATHER_HELMET, 1, "damageReduceAmount", "field_77879_b");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.LEATHER_CHESTPLATE, 1, "damageReduceAmount", "field_77879_b");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.LEATHER_LEGGINGS, 1, "damageReduceAmount", "field_77879_b");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.LEATHER_BOOTS, 1, "damageReduceAmount", "field_77879_b");

        //Chain Armor Reforged
        ItemArmor.ArmorMaterial customChain = EnumHelper.addArmorMaterial("CUSTOM_CHAIN", "chainmail", 15, new int[] {1, 2, 2, 1}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0);
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.CHAINMAIL_HELMET, customChain, "material", "field_77878_bZ");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.CHAINMAIL_CHESTPLATE, customChain, "material", "field_77878_bZ");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.CHAINMAIL_LEGGINGS, customChain, "material", "field_77878_bZ");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.CHAINMAIL_BOOTS, customChain, "material", "field_77878_bZ");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.CHAINMAIL_HELMET, 1, "damageReduceAmount", "field_77879_b");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.CHAINMAIL_CHESTPLATE, 2, "damageReduceAmount", "field_77879_b");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.CHAINMAIL_LEGGINGS, 2, "damageReduceAmount", "field_77879_b");
        ObfuscationReflectionHelper.setPrivateValue(ItemArmor.class, Items.CHAINMAIL_BOOTS, 1, "damageReduceAmount", "field_77879_b");
    }
}