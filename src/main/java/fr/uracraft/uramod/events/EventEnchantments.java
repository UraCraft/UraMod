package fr.uracraft.uramod.events;

import fr.uracraft.uramod.enchantments.EnchantmentStoneBreaker;
import fr.uracraft.uramod.enchantments.EnchantmentTelekinesis;
import fr.uracraft.uramod.enchantments.UraEnchantments;
import fr.uracraft.uramod.items.UraItems;
import fr.uracraft.uramod.utils.Random;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@SuppressWarnings("all")
public class EventEnchantments {

    Boolean stone;

    public boolean hasEnchantment(ItemStack stack, int id) {
        for (int i = 0; i < stack.getEnchantmentTagList().tagCount(); i++) {
            if (stack.getEnchantmentTagList().getCompoundTagAt(i).getShort("id") == id) {
                return true;
            }
        }
        return false;
    }

    @SubscribeEvent
    public void onBreakBlock(BlockEvent.BreakEvent e) {
        if (hasEnchantment(e.getPlayer().getHeldItem(EnumHand.MAIN_HAND), EnchantmentStoneBreaker.id)
                && e.getWorld().getBlockState(e.getPos()).getBlock() == Blocks.STONE) {
            stone = true;
        } else {
            stone = false;
        }
    }

    @SubscribeEvent
    public void onHarvestDrops(BlockEvent.HarvestDropsEvent e) {
        if ((e.getHarvester() != null) && (e.getDrops() != null)) {

            EntityPlayer player = e.getHarvester();
            ItemStack held_item = player.getHeldItem(EnumHand.MAIN_HAND);
            InventoryPlayer inventory = player.inventory;

            if (hasEnchantment(held_item, EnchantmentStoneBreaker.id)) {
                if (stone) {
                    int lvl = EnchantmentHelper.getEnchantmentLevel(UraEnchantments.STONEBREAKER, held_item);
                    e.getDrops().clear();
                    if (Random.roll(0, 4) == 1)
                        e.getDrops().add(new ItemStack(UraItems.SILVER_PARTICLE));
                    if (Random.roll(0, 9) == 1 && lvl >= 2)
                        e.getDrops().add(new ItemStack(UraItems.COPPER_PARTICLE));
                    if (Random.roll(0, 9) == 1 && lvl >= 2)
                        e.getDrops().add(new ItemStack(UraItems.TIN_PARTICLE));
                    if (Random.roll(0, 14) == 1 && lvl == 3)
                        e.getDrops().add(new ItemStack(UraItems.URA_PARTICLE));
                }
            }

            if (hasEnchantment(held_item, EnchantmentTelekinesis.id)) {
                for (int i = 0; i < e.getDrops().size(); i++) {
                    if (inventory.addItemStackToInventory(e.getDrops().get(i))) {
                        e.getDrops().clear();
                    }
                }
            }
        }
    }
}
