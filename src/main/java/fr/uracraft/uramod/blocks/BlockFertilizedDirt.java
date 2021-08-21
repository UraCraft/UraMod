package fr.uracraft.uramod.blocks;

import fr.uracraft.uramod.UraCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class BlockFertilizedDirt extends Block {

    boolean isTilled;

    protected static final AxisAlignedBB TILLED_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.9375D, 1.0D);

    protected BlockFertilizedDirt(boolean tilled) {
        super(Material.GROUND);
        isTilled = tilled;
        setTickRandomly(true);
        setSoundType(SoundType.GROUND);
        if (isTilled) {
            UraBlocks.setBlockName(this, "fertilized_dirt_tilled");
            setLightOpacity(255);
            useNeighborBrightness = true;
        } else {
            UraBlocks.setBlockName(this, "fertilized_dirt");
            setCreativeTab(UraCreativeTabs.URAMOD);
        }
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state) {
        return new ItemStack(UraBlocks.FERTILIZED_DIRT);
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (!isTilled) {
            super.getSubBlocks(tab, list);
        }
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        if (isTilled) {
            return TILLED_AABB;
        } else {
            return super.getBoundingBox(state, source, pos);
        }
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(UraBlocks.FERTILIZED_DIRT, 1, 0);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return FULL_BLOCK_AABB;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(UraBlocks.FERTILIZED_DIRT);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return !isTilled;
    }

    @Override
    public boolean isFertile(World world, BlockPos pos) {
        return true;
    }

    @Override
    public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) {
        EnumPlantType plantType = plantable.getPlantType(world, pos.up());

        switch (plantType) {
            case Desert:
                return !isTilled;
            case Nether:
                return false;
            case Crop:
                return isTilled;
            case Cave:
                return !isTilled;
            case Plains:
                return !isTilled || isTilled && world.getBlockState(pos.up()).getBlock() == Blocks.BEETROOTS;
            case Water:
                return false;
            case Beach:
                return !isTilled;
        }

        return false;
    }

    @Override
    public void updateTick(World worldObj, BlockPos pos, IBlockState state, Random rand) {
        if (!worldObj.isRemote) {
            IBlockState plantState = worldObj.getBlockState(pos.up());
            Block toBoost = plantState.getBlock();
            for (int i = 0; i < 3; i++) {
                if (toBoost != Blocks.AIR && toBoost instanceof IPlantable) {
                    toBoost.updateTick(worldObj, pos.up(), plantState, rand);
                }
            }
        }
    }
}
