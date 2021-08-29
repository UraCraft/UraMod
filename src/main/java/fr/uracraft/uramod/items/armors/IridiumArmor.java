package fr.uracraft.uramod.items.armors;

import fr.uracraft.uramod.UraCreativeTabs;
import fr.uracraft.uramod.events.EventIridiumArmor;
import fr.uracraft.uramod.items.UraItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

public class IridiumArmor extends ItemArmor {

    public IridiumArmor(String name, int renderIndex, EntityEquipmentSlot equipmentSlot) {
        super(Objects.requireNonNull(UraArmorMaterials.IRIDIUM_ARMOR), renderIndex, equipmentSlot);
        setCreativeTab(UraCreativeTabs.URAMOD);
        UraItems.setItemName(this, name);
        setMaxDamage(0);
    }

    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
        if (player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == UraItems.IRIDIUM_HELMET) {
            player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 220, 0, true, false));
        }
        if (player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == UraItems.IRIDIUM_CHESTPLATE) {
            player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 220, 0, true, false));
        }
        if (player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == UraItems.IRIDIUM_LEGGINGS) {
            player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 220, 0, true, false));
        }
        if (player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == UraItems.IRIDIUM_BOOTS) {
            player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 220, 0, true, false));
        }
        if (hasFullArmor(player)) {
            player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 220, 1, true, false));
            player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 220, 0, true, false));
            player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 220, 0, true, false));
            player.extinguish();
        }
    }

    public static boolean hasFullArmor(EntityPlayer player) {
        return player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == UraItems.IRIDIUM_HELMET &&
                player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == UraItems.IRIDIUM_CHESTPLATE &&
                player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == UraItems.IRIDIUM_LEGGINGS &&
                player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == UraItems.IRIDIUM_BOOTS;
    }
}