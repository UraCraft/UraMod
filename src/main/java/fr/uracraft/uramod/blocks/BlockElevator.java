package fr.uracraft.uramod.blocks;

import fr.uracraft.uramod.UraCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;

public class BlockElevator extends Block {

    public static int MAX_RANGE = 16;
    public static final PropertyEnum<BlockElevator.EnumType> VARIANT = PropertyEnum.create("variant", BlockElevator.EnumType.class);

    public BlockElevator() {
        super(Material.ROCK);
        UraBlocks.setBlockName(this, "elevator");
        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumType.WHITE));
        setResistance(5.0F);
        setHardness(3.0F);
        setCreativeTab(UraCreativeTabs.BUILDING);
    }

    @Override
    public int damageDropped(IBlockState state) {
        return state.getValue(VARIANT).getMetadata();
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> items) {
        for (BlockElevator.EnumType type : BlockElevator.EnumType.values()) {
            items.add(new ItemStack(this, 1, type.getMetadata()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(VARIANT, BlockElevator.EnumType.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(VARIANT).getMetadata();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{VARIANT});
    }

    public enum EnumType implements IStringSerializable {
        WHITE(0, "elevator"),
        ORANGE(1, "elevator_orange"),
        MAGENTA(2, "elevator_magenta"),
        LIGHT_BLUE(3, "elevator_light_blue"),
        YELLOW(4, "elevator_yellow"),
        LIME(5, "elevator_lime"),
        PINK(6, "elevator_pink"),
        GRAY(7, "elevator_gray"),
        SILVER(8, "elevator_silver"),
        CYAN(9, "elevator_cyan"),
        PURPLE(10, "elevator_purple"),
        BLUE(11, "elevator_blue"),
        BROWN(12, "elevator_brown"),
        GREEN(13, "elevator_green"),
        RED(14, "elevator_red"),
        BLACK(15, "elevator_black");

        private static final BlockElevator.EnumType[] META_LOOKUP = new BlockElevator.EnumType[values().length];
        private final int meta;
        private final String name;

        EnumType(int metaIn, String nameIn) {
            this.meta = metaIn;
            this.name = nameIn;
        }

        public int getMetadata() {
            return this.meta;
        }

        public static BlockElevator.EnumType byMetadata(int meta) {
            if (meta < 0 || meta >= META_LOOKUP.length) {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        @Override
        public String getName() {
            return this.name;
        }

        static {
            for (BlockElevator.EnumType type : values()) {
                META_LOOKUP[type.getMetadata()] = type;
            }
        }
    }
}