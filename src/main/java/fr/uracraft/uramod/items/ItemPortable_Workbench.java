package fr.uracraft.uramod.items;

import fr.uracraft.uramod.UraCreativeTabs;
import fr.uracraft.uramod.UraMod;
import fr.uracraft.uramod.guis.UraGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemPortable_Workbench extends Item {

    public ItemPortable_Workbench() {
        UraItems.setItemName(this, "portable_workbench");
        setCreativeTab(UraCreativeTabs.URAMOD);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack held = player.getHeldItem(hand);
        if (!world.isRemote) {
            player.openGui(UraMod.instance, UraGui.CRAFTING, world, (int) player.posX, (int) player.posY, (int) player.posZ);
            player.addStat(StatList.CRAFTING_TABLE_INTERACTION);
        }
        return ActionResult.newResult(EnumActionResult.SUCCESS, held);
    }
}
