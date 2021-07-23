package fr.uracraft.uramod;

import fr.uracraft.uramod.items.UraItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class UraCreativeTabs {
    public static final CreativeTabs URAMOD = new CreativeTabs("uramod") {

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(UraItems.URA_INGOT);
        }
    };
    public static final CreativeTabs BUILDING = new CreativeTabs("building") {

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(UraItems.BLOCK_DIRT_STAIRS);
        }
    };
    public static final CreativeTabs EVENTS = new CreativeTabs("events") {

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(UraItems.URA_INGOT);
        }
    };
}
