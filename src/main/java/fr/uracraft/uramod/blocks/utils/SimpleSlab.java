package fr.uracraft.uramod.blocks.utils;

import fr.uracraft.uramod.UraCreativeTabs;
import fr.uracraft.uramod.blocks.UraBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.Random;

public abstract class SimpleSlab extends BlockSlab
{
    Item item;
    public static final PropertyEnum<Variant> VARIANT = PropertyEnum.create("variant", Variant.class);

    public SimpleSlab(Material material, String name, SoundType sound) {
        super(material);
        setCreativeTab(UraCreativeTabs.BUILDING);
        setSoundType(sound);
        UraBlocks.setBlockName(this, name);

        IBlockState state = blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);
        if(!isDouble())
            state = state.withProperty(HALF, EnumBlockHalf.BOTTOM);

        setDefaultState(state);

        useNeighborBrightness = !isDouble();
    }

    public Block setItem(Item item) {
        this.item = item;
        return this;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return item;
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(item);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState state = blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);
        if(!isDouble())
            state = state.withProperty(HALF, ((meta&8) != 0) ? EnumBlockHalf.TOP : EnumBlockHalf.BOTTOM);
        return state;
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int meta = 0;
        if(!isDouble() && state.getValue(HALF) == EnumBlockHalf.TOP)
            meta |= 8;
        return meta;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        if(!isDouble())
            return new BlockStateContainer(this, VARIANT, HALF);
        return new BlockStateContainer(this, VARIANT);
    }

    @Override
    public String getUnlocalizedName(int meta)
    {
        return getUnlocalizedName();
    }

    @Override
    public IProperty<?> getVariantProperty()
    {
        return VARIANT;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack)
    {
        return Variant.DEFAULT;
    }

    public enum Variant implements IStringSerializable {
        DEFAULT;

        @Override
        public String getName()
        {
            return "default";
        }
    }
}