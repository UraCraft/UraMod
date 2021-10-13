package fr.uracraft.uramod.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;

public class CommandGetItemID extends CommandBase {

    @Override
    public String getName() {
        return "getid";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        ItemStack stack = Minecraft.getMinecraft().player.getHeldItem(EnumHand.MAIN_HAND);
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }
        if(stack.getTagCompound().getInteger("id") != 0) {
            sender.sendMessage(new TextComponentString(String.valueOf(stack.getTagCompound().getInteger("id"))));
        }else{
            sender.sendMessage(new TextComponentString("GIVED SWORD !"));
        }
    }
}