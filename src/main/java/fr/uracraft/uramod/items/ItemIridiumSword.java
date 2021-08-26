package fr.uracraft.uramod.items;

import fr.uracraft.uramod.UraCreativeTabs;
import fr.uracraft.uramod.UraMod;
import fr.uracraft.uramod.items.tools.UraToolMaterials;
import fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;

public class ItemIridiumSword extends net.minecraft.item.ItemSword {

    public static String ores[][] = new String[][]{
            {"iridium_sword", "0"},
            {"excalibur", "1"}};


    public ItemIridiumSword() {
        super(UraToolMaterials.IRIDIUM_TOOL_MATERIAL);
        UraItems.setItemName(this, "iridium_sword");
        setCreativeTab(UraCreativeTabs.URAMOD);
        setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item." + UraMod.MODID + "." + byMetadata(stack.getMetadata());
    }

    @Override
    public void getSubItems(final CreativeTabs tab, final NonNullList<ItemStack> subItems) {
        if (this.isInCreativeTab(tab)) {
            for (int i = 0; i < ores.length; i++) {
                subItems.add(new ItemStack(this, 1, i));
            }
        }
    }

    public static String byMetadata(int meta){
        return ores[meta][0];
    }
}