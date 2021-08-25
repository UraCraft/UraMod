package fr.uracraft.uramod.blocks.energy;

import fr.uracraft.uramod.UraCreativeTabs;
import fr.uracraft.uramod.UraMod;
import fr.uracraft.uramod.blocks.UraBlocks;
import fr.uracraft.uramod.guis.UraGui;
import fr.uracraft.uramod.tileentity.TileEntityEnergyRegulator;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EnergyRegulator extends BlockContainer {

    protected static final AxisAlignedBB ENERGY_REGULATOR_AABB = new AxisAlignedBB(0.16D, 0.0D, 0.16D, 0.84D, 0.84D, 0.84D);

    public EnergyRegulator() {
        super(Material.ROCK);
        UraBlocks.setBlockName(this, "energy_regulator");
        setCreativeTab(UraCreativeTabs.ENERGY);
        setHardness(1.0F);
        setResistance(1.0F);
        setHarvestLevel("pickaxe", 2);
        useNeighborBrightness = true;
        setLightOpacity(255);
        setSoundType(SoundType.STONE);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityEnergyRegulator();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote) {
            playerIn.openGui(UraMod.instance, UraGui.GUI_ENERGY_REGULATOR, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return ENERGY_REGULATOR_AABB;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return ENERGY_REGULATOR_AABB;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }
}
