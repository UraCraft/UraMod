package fr.uracraft.uramod.guis;

import fr.uracraft.uramod.container.ContainerUraFurnace;
import fr.uracraft.uramod.tileentity.TileEntityUraFurnace;
import net.minecraft.client.gui.GuiRepair;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerRepair;
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
        if (id == UraGui.ANVIL) {
            return new ContainerRepair(entityPlayer.inventory, world, new BlockPos(x, y, z), entityPlayer) {
                @Override
                public boolean canInteractWith(EntityPlayer playerIn) {
                    return true;
                }
            };
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
        if (id == UraGui.ANVIL) {
            return new GuiRepair(entityPlayer.inventory, world);
        }
        return null;
    }
}
