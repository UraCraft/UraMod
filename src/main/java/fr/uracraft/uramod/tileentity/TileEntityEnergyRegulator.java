package fr.uracraft.uramod.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityEnergyRegulator extends TileEntity implements ITickable {

    private int count;

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setInteger("count", count);
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        count = compound.getInteger("count");
        super.readFromNBT(compound);
    }

    public void update() {
        if (world.isBlockPowered(pos)) {
            incrementCount(1);
        }
    }

    public int getCount() {
        return count;
    }

    public void incrementCount(int i) {
        count = count + i;
        markDirty();
    }

    public void decrementCount(int i) {
        count = count - i;
        markDirty();
    }
}
