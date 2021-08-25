package fr.uracraft.uramod.guis;

import fr.uracraft.uramod.container.chests.*;
import fr.uracraft.uramod.container.ContainerUraFurnace;
import fr.uracraft.uramod.guis.chests.*;
import fr.uracraft.uramod.tileentity.TileEntityEnergyRegulator;
import fr.uracraft.uramod.tileentity.chests.*;
import fr.uracraft.uramod.tileentity.TileEntityUraFurnace;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z) {
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
        if (tile instanceof TileEntityUraFurnace) {
            return new ContainerUraFurnace(entityPlayer.inventory, (TileEntityUraFurnace) tile);
        }
        if (id == UraGui.CRAFTING) {
            return new ContainerWorkbench(entityPlayer.inventory, world, new BlockPos(x, y, z)) {
                @Override
                public boolean canInteractWith(EntityPlayer playerIn) {
                    return true;
                }
            };
        }
        if (id == UraGui.GUI_URA_CHEST) {
            return new ContainerUraChest(entityPlayer.inventory, (TileEntityUraChest) world.getTileEntity(new BlockPos(x, y, z)), entityPlayer);
        }
        if (id == UraGui.GUI_DIAMOND_CHEST) {
            return new ContainerDiamondChest(entityPlayer.inventory, (TileEntityDiamondChest) world.getTileEntity(new BlockPos(x, y, z)), entityPlayer);
        }
        if (id == UraGui.GUI_GOLD_CHEST) {
            return new ContainerGoldChest(entityPlayer.inventory, (TileEntityGoldChest) world.getTileEntity(new BlockPos(x, y, z)), entityPlayer);
        }
        if (id == UraGui.GUI_IRON_CHEST) {
            return new ContainerIronChest(entityPlayer.inventory, (TileEntityIronChest) world.getTileEntity(new BlockPos(x, y, z)), entityPlayer);
        }
        if (id == UraGui.GUI_SILVER_CHEST) {
            return new ContainerSilverChest(entityPlayer.inventory, (TileEntitySilverChest) world.getTileEntity(new BlockPos(x, y, z)), entityPlayer);
        }
        if (id == UraGui.GUI_STONE_CHEST) {
            return new ContainerStoneChest(entityPlayer.inventory, (TileEntityStoneChest) world.getTileEntity(new BlockPos(x, y, z)), entityPlayer);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z) {
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
        if (tile instanceof TileEntityUraFurnace) {
            return new GuiUraFurnace(entityPlayer.inventory, (TileEntityUraFurnace) tile);
        }
        if (id == UraGui.CRAFTING) {
            return new GuiCrafting(entityPlayer.inventory, world);
        }
        if (id == UraGui.GUI_URA_CHEST) {
            return new GuiUraChest(entityPlayer.inventory, (TileEntityUraChest) world.getTileEntity(new BlockPos(x, y, z)), entityPlayer);
        }
        if (id == UraGui.GUI_DIAMOND_CHEST) {
            return new GuiDiamondChest(entityPlayer.inventory, (TileEntityDiamondChest) world.getTileEntity(new BlockPos(x, y, z)), entityPlayer);
        }
        if (id == UraGui.GUI_GOLD_CHEST) {
            return new GuiGoldChest(entityPlayer.inventory, (TileEntityGoldChest) world.getTileEntity(new BlockPos(x, y, z)), entityPlayer);
        }
        if (id == UraGui.GUI_IRON_CHEST) {
            return new GuiIronChest(entityPlayer.inventory, (TileEntityIronChest) world.getTileEntity(new BlockPos(x, y, z)), entityPlayer);
        }
        if (id == UraGui.GUI_SILVER_CHEST) {
            return new GuiSilverChest(entityPlayer.inventory, (TileEntitySilverChest) world.getTileEntity(new BlockPos(x, y, z)), entityPlayer);
        }
        if (id == UraGui.GUI_STONE_CHEST) {
            return new GuiStoneChest(entityPlayer.inventory, (TileEntityStoneChest) world.getTileEntity(new BlockPos(x, y, z)), entityPlayer);
        }
        if (id == UraGui.GUI_ENERGY_REGULATOR) {
            return new GuiEnergyRegulator(new BlockPos(x, y, z));
        }
        return null;
    }
}
