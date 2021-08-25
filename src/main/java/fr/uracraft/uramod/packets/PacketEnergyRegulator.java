package fr.uracraft.uramod.packets;

import fr.uracraft.uramod.guis.GuiEnergyRegulator;
import fr.uracraft.uramod.tileentity.TileEntityEnergyRegulator;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketEnergyRegulator implements IMessage {

    private int posX;
    private int posY;
    private int posZ;

    public PacketEnergyRegulator() {}

    public PacketEnergyRegulator(int x, int y, int z) {
        this.posX = x;
        this.posY = y;
        this.posZ = z;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        posX = buf.readInt();
        posY = buf.readInt();
        posZ = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(posX);
        buf.writeInt(posY);
        buf.writeInt(posZ);
    }

    public static class Handler implements IMessageHandler<PacketEnergyRegulator, IMessage> {
        @Override
        public IMessage onMessage(PacketEnergyRegulator message, MessageContext ctx) {
            if (ctx.getServerHandler().player.world.getBlockState(new BlockPos(message.posX, message.posY, message.posZ)).getBlock().hasTileEntity()) {
                TileEntity tile = ctx.getServerHandler().player.world.getTileEntity(new BlockPos(message.posX, message.posY, message.posZ));
                if (tile instanceof TileEntityEnergyRegulator) {
                    TileEntityEnergyRegulator te = (TileEntityEnergyRegulator) ctx.getServerHandler().player.world.getTileEntity(new BlockPos(message.posX, message.posY, message.posZ));
                    GuiEnergyRegulator.initValue(te.getCount());
                }
            }
            return null;
        }
    }
}
