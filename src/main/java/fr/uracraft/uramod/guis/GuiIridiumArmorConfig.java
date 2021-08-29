package fr.uracraft.uramod.guis;

import fr.uracraft.uramod.UraMod;
import fr.uracraft.uramod.energy.IEnergy;
import fr.uracraft.uramod.items.UraItems;
import fr.uracraft.uramod.packets.PacketEnergyRegulator;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class GuiIridiumArmorConfig extends GuiScreen {

    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation("textures/gui/demo_background.png");
    private static EntityPlayer entityPlayer;
    private final int xSize = 256;
    private final int ySize = 202;
    private int guiLeft;
    private int guiTop;

    public GuiIridiumArmorConfig(EntityPlayer player) {
        entityPlayer = player;
    }

    public void initGui() {
        guiLeft = ((this.width - xSize) / 2) + 5;
        guiTop = (this.height - ySize) / 2;
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawBackground(0);
        this.fontRenderer.drawString("Coucou :)", this.width / 2, this.height / 3, IEnergy.colorUnit);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void drawBackground(int tint) {
        GlStateManager.pushMatrix();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(GUI_TEXTURE);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        GlStateManager.popMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glColor3f(1F, 1F, 1F);
        GL11.glEnable(GL11.GL_BLEND);
        this.zLevel = 100.0F;
        itemRender.zLevel = 100.0F;
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        ItemStack helmet = new ItemStack(UraItems.IRIDIUM_HELMET);
        ItemStack chestplate = new ItemStack(UraItems.IRIDIUM_CHESTPLATE);
        ItemStack leggings = new ItemStack(UraItems.IRIDIUM_LEGGINGS);
        ItemStack boots = new ItemStack(UraItems.IRIDIUM_BOOTS);
        int yPos = (ySize / 2) - 8;
        itemRender.renderItemAndEffectIntoGUI(helmet, getXPlacement(0), yPos);
        itemRender.renderItemOverlayIntoGUI(this.fontRenderer, helmet, getXPlacement(0), yPos, null);
        itemRender.renderItemAndEffectIntoGUI(chestplate, getXPlacement(1), yPos);
        itemRender.renderItemOverlayIntoGUI(this.fontRenderer, chestplate, getXPlacement(1), yPos, null);
        itemRender.renderItemAndEffectIntoGUI(leggings, getXPlacement(2), yPos);
        itemRender.renderItemOverlayIntoGUI(this.fontRenderer, leggings, getXPlacement(2), yPos, null);
        itemRender.renderItemAndEffectIntoGUI(boots, getXPlacement(3), yPos);
        itemRender.renderItemOverlayIntoGUI(this.fontRenderer, boots, getXPlacement(3), yPos, null);
        GL11.glDisable(GL11.GL_LIGHTING);
        itemRender.zLevel = 0.0F;
        this.zLevel = 0.0F;
    }

    public int getXPlacement(int itemNb) {
        return xSize / 4 * itemNb + guiLeft - 13 - ((xSize / 4) / 2);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
