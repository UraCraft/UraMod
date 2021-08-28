package fr.uracraft.uramod.events;

import fr.uracraft.uramod.guis.GuiIridiumArmorConfig;
import fr.uracraft.uramod.items.armors.IridiumArmor;
import fr.uracraft.uramod.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class EventIridiumArmor {

    @SubscribeEvent
    public void livingHurtEvent(LivingHurtEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            if (IridiumArmor.hasFullArmor((EntityPlayer) event.getEntity())) {
                if (event.getSource().damageType.equals("inFire")
                        || event.getSource().damageType.equals("onFire")
                        || event.getSource().damageType.equals("lava")
                        || event.getSource().damageType.equals("cramming")
                        || event.getSource().damageType.equals("wither")
                        || event.getSource().damageType.equals("dragonBreath")
                        || event.getSource().damageType.equals("starve"))
                    event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public void onEvent(InputEvent.KeyInputEvent event) {
        if (ClientProxy.keyIridiumArmorConfig.isPressed()) {
            if (IridiumArmor.hasFullArmor(Minecraft.getMinecraft().player))
                Minecraft.getMinecraft().displayGuiScreen(new GuiIridiumArmorConfig(Minecraft.getMinecraft().player));
        }
    }
}
