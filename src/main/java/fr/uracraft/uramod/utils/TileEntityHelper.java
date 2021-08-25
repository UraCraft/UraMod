package fr.uracraft.uramod.utils;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class TileEntityHelper {

    public static net.minecraft.tileentity.TileEntity getTileEntity(IBlockAccess world, BlockPos pos) {
        return world.getTileEntity(pos);
    }
}
