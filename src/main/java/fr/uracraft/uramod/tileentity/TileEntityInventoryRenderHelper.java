package fr.uracraft.uramod.tileentity;

import fr.uracraft.uramod.blocks.UraBlocks;
import fr.uracraft.uramod.tileentity.chests.*;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntityInventoryRenderHelper extends TileEntityItemStackRenderer {

    private final TileEntityUraChest tileEntityUraChest = new TileEntityUraChest();
    private final TileEntitySilverChest tileEntitySilverChest = new TileEntitySilverChest();
    private final TileEntityGoldChest tileEntityGoldChest = new TileEntityGoldChest();
    private final TileEntityDiamondChest tileEntityDiamondChest = new TileEntityDiamondChest();
    private final TileEntityIronChest tileEntityIronChest = new TileEntityIronChest();
    private final TileEntityStoneChest tileEntityStoneChest = new TileEntityStoneChest();

    @Override
    public void renderByItem(ItemStack itemStack) {
        Block block = Block.getBlockFromItem(itemStack.getItem());

        if (block == UraBlocks.URA_CHEST) {
            TileEntityRendererDispatcher.instance.render(this.tileEntityUraChest, 0.0D, 0.0D, 0.0D, 0.0F);
        } else if (block == UraBlocks.DIAMOND_CHEST) {
            TileEntityRendererDispatcher.instance.render(this.tileEntityDiamondChest, 0.0D, 0.0D, 0.0D, 0.0F);
        } else if (block == UraBlocks.SILVER_CHEST) {
            TileEntityRendererDispatcher.instance.render(this.tileEntitySilverChest, 0.0D, 0.0D, 0.0D, 0.0F);
        } else if (block == UraBlocks.GOLD_CHEST) {
            TileEntityRendererDispatcher.instance.render(this.tileEntityGoldChest, 0.0D, 0.0D, 0.0D, 0.0F);
        } else if (block == UraBlocks.IRON_CHEST) {
            TileEntityRendererDispatcher.instance.render(this.tileEntityIronChest, 0.0D, 0.0D, 0.0D, 0.0F);
        } else if (block == UraBlocks.STONE_CHEST) {
            TileEntityRendererDispatcher.instance.render(this.tileEntityStoneChest, 0.0D, 0.0D, 0.0D, 0.0F);
        } else {
            super.renderByItem(itemStack);
        }
    }
}