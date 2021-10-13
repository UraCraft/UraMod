package fr.uracraft.uramod.events;

import fr.uracraft.uramod.items.UraItems;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventAnvil {

    @SubscribeEvent
    public void createExcalibur(AnvilUpdateEvent e) {
        if (e.getLeft().getItem() == UraItems.IRIDIUM_SWORD && e.getLeft().getMetadata() == 0) {
            if (e.getRight().getItem() == Item.getItemFromBlock(Blocks.COBBLESTONE)) {
                if (e.getName().equalsIgnoreCase("Arthur")) {
                    ItemStack excalibur = e.getLeft().copy();
                    excalibur.setItemDamage(1);
                    if (!excalibur.hasTagCompound()) {
                        excalibur.setTagCompound(new NBTTagCompound());
                    }
                    excalibur.getTagCompound().setString("owner", Minecraft.getMinecraft().player.getName());
                    e.setOutput(excalibur);
                    e.setCost(88);
                    e.setMaterialCost(64);
                }
            }
        }
    }
}