package fr.uracraft.uramod.events;

import fr.uracraft.uramod.blocks.BlockElevator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class EventElevator {

    @SubscribeEvent
    public void jumpEvent(LivingEvent.LivingJumpEvent e) {
        if (!e.getEntity().world.isRemote)
            return;
        if (e.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) e.getEntity();

            int blockX = MathHelper.floor(player.posX);
            int blockY = MathHelper.floor(player.posY - player.getYOffset() - 1);
            int blockZ = MathHelper.floor(player.posZ);

            Block blockUnderneath = player.world.getBlockState(new BlockPos(blockX, blockY, blockZ)).getBlock();

            if (blockUnderneath instanceof BlockElevator) {
                for (int i = 1; i < BlockElevator.MAX_RANGE; i++) {
                    if (player.world.getBlockState(new BlockPos(blockX, blockY + i, blockZ)).getBlock() instanceof BlockElevator) {
                        if (player.world.getBlockState(new BlockPos(blockX, blockY + i + 1, blockZ)).getBlock() instanceof BlockAir
                                && player.world.getBlockState(new BlockPos(blockX, blockY + i + 2, blockZ)).getBlock() instanceof BlockAir) {
                            player.setPositionAndUpdate(player.posX, blockY + i + 1, player.posZ);
                            i = BlockElevator.MAX_RANGE;
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onEvent(EntityEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {

            EntityPlayer player = (EntityPlayer)event.getEntity();

            if (Minecraft.getMinecraft().gameSettings.keyBindSneak.isPressed()) {

                int blockX = MathHelper.floor(player.posX);
                int blockY = MathHelper.floor(player.posY - player.getYOffset() - 1);
                int blockZ = MathHelper.floor(player.posZ);

                Block blockUnderneath = player.world.getBlockState(new BlockPos(blockX, blockY, blockZ)).getBlock();

                if (blockUnderneath instanceof BlockElevator) {
                    for (int i = 3; i < BlockElevator.MAX_RANGE + 3; i++) {
                        if (player.world.getBlockState(new BlockPos(blockX, blockY - i, blockZ)).getBlock() instanceof BlockElevator) {
                            if (player.world.getBlockState(new BlockPos(blockX, blockY - i + 1, blockZ)).getBlock() instanceof BlockAir
                                    && player.world.getBlockState(new BlockPos(blockX, blockY - i + 2, blockZ)).getBlock() instanceof BlockAir) {
                                player.setPositionAndUpdate(player.posX, blockY - i + 1, player.posZ);
                                i = BlockElevator.MAX_RANGE + 3;
                            }
                        }
                    }
                }
            }
        }
    }
}
