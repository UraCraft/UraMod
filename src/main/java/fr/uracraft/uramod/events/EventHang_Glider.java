package fr.uracraft.uramod.events;

import fr.uracraft.uramod.items.UraItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHang_Glider {

    @SubscribeEvent
    public void LivingEvent(LivingEvent event) {
        if (event.getEntityLiving() instanceof EntityPlayer) {
            if (event.getEntityLiving().motionY < 1D) {
                if (event.getEntityLiving().getHeldItem(EnumHand.MAIN_HAND) != null) {
                    if (event.getEntityLiving().getHeldItem(EnumHand.MAIN_HAND).getItem() == UraItems.HANG_GLIDER) {
                        event.getEntityLiving().fallDistance = 0;
                    }
                }
            }
        }
    }
}
