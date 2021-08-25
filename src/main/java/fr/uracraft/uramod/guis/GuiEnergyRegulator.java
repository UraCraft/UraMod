package fr.uracraft.uramod.guis;

import fr.uracraft.uramod.UraMod;
import fr.uracraft.uramod.energy.IEnergy;
import fr.uracraft.uramod.packets.PacketEnergyRegulator;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiEnergyRegulator extends GuiScreen {

    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation("textures/gui/demo_background.png");
    private static BlockPos blockPos;
    private final int xSize = 256;
    private final int ySize = 202;
    private int guiLeft;
    private int guiTop;
    private static int networkValue;
    private int timing;

    protected GuiEnergyRegulator(BlockPos pos) {
        blockPos = pos;
    }

    public void initGui() {
        guiLeft = ((this.width - xSize) / 2) + 5;
        guiTop = (this.height - ySize) / 2;
    }

    public static void initValue(int valueIn) {
        networkValue = valueIn;
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        if(timing == 0){
            UraMod.network.sendToServer(new PacketEnergyRegulator(blockPos.getX(), blockPos.getY(), blockPos.getZ()));
        }else if(timing >= 20){
            timing = -1;
        }
        timing++;
        String s;
        int color;
        drawBackground(0);
        if (networkValue > 0) {
            s = "+ " + networkValue;
            color = EnumDyeColor.GREEN.getColorValue();
        } else if (networkValue < 0) {
            s = "- " + String.valueOf(networkValue).substring(1, 3);
            color = EnumDyeColor.RED.getColorValue();
        } else {
            s = "+ " + networkValue;
            color = EnumDyeColor.PURPLE.getColorValue();
        }
        int i = s.length() * 5 + (s.length() - 1);
        this.fontRenderer.drawString(s, (this.width - i) / 2, this.height / 3, color);
        this.fontRenderer.drawString(IEnergy.unit, (this.width - i) / 2 + i, this.height / 3, IEnergy.colorUnit);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void drawBackground(int tint) {
        GlStateManager.pushMatrix();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(GUI_TEXTURE);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        GlStateManager.popMatrix();
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }
}
