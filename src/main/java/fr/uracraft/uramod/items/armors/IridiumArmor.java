package fr.uracraft.uramod.items.armors;

import fr.uracraft.uramod.UraCreativeTabs;
import fr.uracraft.uramod.items.UraItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class IridiumArmor extends ItemArmor {
    public IridiumArmor(String name, int renderIndex, EntityEquipmentSlot equipmentSlot) {
        super(UraArmorMaterials.IRIDIUM_ARMOR, renderIndex, equipmentSlot);
        setCreativeTab(UraCreativeTabs.URAMOD);
        UraItems.setItemName(this, name);
        setMaxDamage(0);
    }

    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {


        if (this.armorType == EntityEquipmentSlot.HEAD && stack.getItem() == UraItems.IRIDIUM_HELMET) {
            player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 220, -1, true, false));
        }

        if (this.armorType == EntityEquipmentSlot.CHEST && stack.getItem() == UraItems.IRIDIUM_CHESTPLATE) {
            player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 220, -1, true, false));
        }

        if (this.armorType == EntityEquipmentSlot.LEGS && stack.getItem() == UraItems.IRIDIUM_LEGGINGS) {
            player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 220, -1, true, false));
        }

        if (this.armorType == EntityEquipmentSlot.FEET && stack.getItem() == UraItems.IRIDIUM_BOOTS) {
            player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 220, -1, true, false));
        }
    }
}