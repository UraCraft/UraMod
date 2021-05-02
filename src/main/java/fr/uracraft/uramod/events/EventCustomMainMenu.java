package fr.uracraft.uramod.events;

import fr.uracraft.uramod.guis.GuiCustomIngameMenu;
import fr.uracraft.uramod.guis.GuiCustomMainMenu;
import fr.uracraft.uramod.guis.GuiCustomOptions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiOptions;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventCustomMainMenu {

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onTick(TickEvent.ClientTickEvent event)
    {
        Minecraft mc = FMLClientHandler.instance().getClient();
        if(mc.currentScreen != null && mc.currentScreen.getClass().equals(GuiMainMenu.class))
        {
            mc.displayGuiScreen(new GuiCustomMainMenu());
        }

        if(mc.currentScreen != null && mc.currentScreen.getClass().equals(GuiOptions.class))
        {
            mc.displayGuiScreen(new GuiCustomOptions(Minecraft.getMinecraft().currentScreen, Minecraft.getMinecraft().gameSettings));
        }

        if(mc.currentScreen != null && mc.currentScreen.getClass().equals(GuiIngameMenu.class))
        {
            mc.displayGuiScreen(new GuiCustomIngameMenu());
        }
    }
}
