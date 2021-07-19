package fr.uracraft.uramod.items;

import net.minecraft.client.resources.I18n;
import fr.uracraft.uramod.UraCreativeTabs;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemWorld_Selector extends Item {

    public ItemWorld_Selector() {
        super();
        UraItems.setItemName(this, "world_selector");
        setCreativeTab(UraCreativeTabs.URAMOD);
        setMaxStackSize(1);
    }

    public void addInformation(ItemStack stack, World worldIn, List tooltip, ITooltipFlag flagIn) {

        tooltip.add(I18n.format("itemLore.world_selector_line0"));
        tooltip.add(I18n.format("itemLore.world_selector_line1"));
    }
}