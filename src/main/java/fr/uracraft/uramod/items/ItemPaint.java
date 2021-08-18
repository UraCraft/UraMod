package fr.uracraft.uramod.items;

import fr.uracraft.uramod.UraCreativeTabs;
import fr.uracraft.uramod.blocks.BlockBackground;
import fr.uracraft.uramod.blocks.BlockElevator;
import fr.uracraft.uramod.blocks.UraBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.lwjgl.Sys;

public class ItemPaint extends Item {

    private int dye_meta;

    public ItemPaint(int meta) {
        dye_meta = meta;
        UraItems.setItemName(this, "paint_" + EnumDyeColor.byMetadata(meta).getName());
        this.setMaxDamage(10);
        this.setCreativeTab(UraCreativeTabs.URAMOD);
    }

    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        Block block = worldIn.getBlockState(pos).getBlock();
        if (block instanceof BlockElevator || block instanceof BlockBackground) {
            if (block.getMetaFromState(worldIn.getBlockState(pos)) != dye_meta) {
                if(block instanceof BlockBackground){
                    worldIn.setBlockState(pos, block.getDefaultState().withProperty(BlockBackground.VARIANT, BlockBackground.EnumType.byMetadata(dye_meta)));
                }else {
                    worldIn.setBlockState(pos, block.getDefaultState().withProperty(BlockElevator.VARIANT, BlockElevator.EnumType.byMetadata(dye_meta)));
                }
                if (isEmpty(player.getHeldItem(hand))) {
                    player.setHeldItem(hand, new ItemStack(Items.BUCKET));
                } else {
                    player.getHeldItem(hand).damageItem(1, player);
                }
            }
        }
        return null;
    }

    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target, EnumHand hand) {
        if (target instanceof EntitySheep) {
            EntitySheep entitysheep = (EntitySheep) target;
            EnumDyeColor enumdyecolor = EnumDyeColor.byMetadata(dye_meta);

            if (!entitysheep.getSheared() && entitysheep.getFleeceColor() != enumdyecolor) {
                entitysheep.setFleeceColor(enumdyecolor);
                if (isEmpty(stack)) {
                    playerIn.setHeldItem(hand, new ItemStack(Items.BUCKET));
                } else {
                    stack.damageItem(1, playerIn);
                }
            }

            return true;
        } else {
            return false;
        }
    }

    private boolean isEmpty(ItemStack stack) {
        System.out.println("Paint use : " + getDamage(stack));
        return getDamage(stack) == 10;
    }
}

