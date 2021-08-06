package fr.uracraft.uramod.guis.chests;

import fr.uracraft.uramod.container.chests.ContainerStoneChest;
import fr.uracraft.uramod.tileentity.chests.TileEntityStoneChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiStoneChest extends GuiContainer
{
    private static final ResourceLocation GUI_CHEST = new ResourceLocation("textures/gui/container/generic_54.png");
    private final InventoryPlayer playerInventory;
    private final TileEntityStoneChest te;
    private final int inventoryRows;

    public GuiStoneChest(InventoryPlayer playerInventory, TileEntityStoneChest chestInventory, EntityPlayer player)
    {
        super(new ContainerStoneChest(playerInventory, chestInventory, player));
        this.playerInventory = playerInventory;
        this.te = chestInventory;
        this.inventoryRows = chestInventory.getSizeInventory() / 9;
        this.xSize = 222;
        this.ySize = 114 + this.inventoryRows * 18;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        this.fontRenderer.drawString(this.te.getDisplayName().getUnformattedText(), 8, 6, 4210752);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 94, 4210752);
    }

    /*@Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GUI_CHEST);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }*/

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(GUI_CHEST);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.inventoryRows * 18 + 17);
        this.drawTexturedModalRect(i, j + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
    }
}