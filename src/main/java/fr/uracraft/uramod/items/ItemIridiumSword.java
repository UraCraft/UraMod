package fr.uracraft.uramod.items;

import fr.uracraft.uramod.UraCreativeTabs;
import fr.uracraft.uramod.UraMod;
import fr.uracraft.uramod.items.tools.UraToolMaterials;
import fr.uracraft.uramod.utils.Random;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.List;
import java.util.Objects;

public class ItemIridiumSword extends net.minecraft.item.ItemSword {

    int excaliburFireRadius = 6;
    int excaliburFireTime = Random.roll(4, 8);

    public static String VARIANTS[][] = new String[][]{
            {"iridium_sword", "0"},
            {"excalibur", "1"}};

    public ItemIridiumSword() {
        super(Objects.requireNonNull(UraToolMaterials.IRIDIUM_TOOL_MATERIAL));
        UraItems.setItemName(this, "iridium_sword");
        setCreativeTab(UraCreativeTabs.URAMOD);
        setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public void addInformation(ItemStack stack, World worldIn, List tooltip, ITooltipFlag flagIn) {
        if(stack.getMetadata() == 1) {
            if(stack.hasTagCompound()) {
                tooltip.add(I18n.format("swordOwner") + " " + stack.getTagCompound().getString("owner"));
            }
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item." + UraMod.MODID + "." + byMetadata(stack.getMetadata());
    }

    @Override
    public void getSubItems(final CreativeTabs tab, final NonNullList<ItemStack> subItems) {
        if (this.isInCreativeTab(tab)) {
            for (int i = 0; i < VARIANTS.length; i++) {
                subItems.add(new ItemStack(this, 1, i));
            }
        }
    }

    public static String byMetadata(int meta) {
        return VARIANTS[meta][0];
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (playerIn.isSneaking()) {
            ItemStack stack = playerIn.getHeldItem(handIn);
            if (stack.getMetadata() == 1) {
                if (!stack.hasTagCompound()) {
                    stack.setTagCompound(new NBTTagCompound());
                }
                byte mode = stack.getTagCompound().getByte("mode");
                mode++;
                if (mode == 2) {
                    mode = 0;
                }
                stack.getTagCompound().setByte("mode", mode);
                if (!worldIn.isRemote) {
                    playerIn.sendMessage(new TextComponentString(I18n.format(mode == 0 ? "excalibur.mode.normal" : "excalibur.mode.flame")));
                }
            }
        } else {
            super.onItemRightClick(worldIn, playerIn, handIn);
        }
        return new ActionResult<>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }
        if (stack.getTagCompound().getByte("mode") == 1) {
            AxisAlignedBB AABB = target.getEntityBoundingBox();
            List<Entity> entityList = target.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(AABB.minX-excaliburFireRadius, AABB.minY-excaliburFireRadius, AABB.minZ-excaliburFireRadius, AABB.maxX+excaliburFireRadius, AABB.maxY+excaliburFireRadius, AABB.maxZ+excaliburFireRadius));
            for(Entity entity : entityList) {
                if (!entity.equals(attacker))
                    entity.setFire(excaliburFireTime);
            }
            System.out.println(entityList.size());
        }
        return super.hitEntity(stack, target, attacker);
    }
}