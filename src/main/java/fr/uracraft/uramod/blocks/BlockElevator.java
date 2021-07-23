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

    public static final String NAME = "elevator_block";
    public static final PropertyEnum<BlockElevator.EnumType> VARIANT = PropertyEnum.create("variant", BlockElevator.EnumType.class);

    public BlockElevator() {
        super(Material.ROCK);

        UraBlocks.setBlockName(this, NAME);
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
        WHITE(0, "elevator", "elevator_block"),
        ORANGE(1, "elevator_orange", "elevator_block_orange"),
        MAGENTA(2, "elevator_magenta", "elevator_block_magenta"),
        LIGHT_BLUE(3, "elevator_light_blue", "elevator_block_light_blue"),
        YELLOW(4, "elevator_yellow", "elevator_block_yellow"),
        LIME(5, "elevator_lime", "elevator_block_lime"),
        PINK(6, "elevator_pink", "elevator_block_pink"),
        GRAY(7, "elevator_gray", "elevator_block_gray"),
        SILVER(8, "elevator_silver", "elevator_block_silver"),
        CYAN(9, "elevator_cyan", "elevator_block_cyan"),
        PURPLE(10, "elevator_purple", "elevator_block_purple"),
        BLUE(11, "elevator_blue", "elevator_block_blue"),
        BROWN(12, "elevator_brown", "elevator_block_brown"),
        GREEN(13, "elevator_green", "elevator_block_green"),
        RED(14, "elevator_red", "elevator_block_red"),
        BLACK(15, "elevator_black", "elevator_block_black");

        private static final BlockElevator.EnumType[] META_LOOKUP = new BlockElevator.EnumType[values().length];
        private final int meta;
        private final String name;
        private final String unlocalizedName;

        EnumType(int metaIn, String nameIn, String unlocalizedIn) {
            this.meta = metaIn;
            this.name = nameIn;
            this.unlocalizedName = unlocalizedIn;
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

        public String toString() {
            return this.name;
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

    public static IBlockState getBlockStateFromMeta(int meta) {

        switch (meta) {

            case 0:
                return UraBlocks.BLOCK_ELEVATOR.getDefaultState().withProperty(BlockElevator.VARIANT, EnumType.WHITE);

            case 1:
                return UraBlocks.BLOCK_ELEVATOR.getDefaultState().withProperty(BlockElevator.VARIANT, EnumType.ORANGE);

            case 2:
                return UraBlocks.BLOCK_ELEVATOR.getDefaultState().withProperty(BlockElevator.VARIANT, EnumType.MAGENTA);

            case 3:
                return UraBlocks.BLOCK_ELEVATOR.getDefaultState().withProperty(BlockElevator.VARIANT, EnumType.LIGHT_BLUE);

            case 4:
                return UraBlocks.BLOCK_ELEVATOR.getDefaultState().withProperty(BlockElevator.VARIANT, EnumType.YELLOW);

            case 5:
                return UraBlocks.BLOCK_ELEVATOR.getDefaultState().withProperty(BlockElevator.VARIANT, EnumType.LIME);

            case 6:
                return UraBlocks.BLOCK_ELEVATOR.getDefaultState().withProperty(BlockElevator.VARIANT, EnumType.PINK);

            case 7:
                return UraBlocks.BLOCK_ELEVATOR.getDefaultState().withProperty(BlockElevator.VARIANT, EnumType.GRAY);

            case 8:
                return UraBlocks.BLOCK_ELEVATOR.getDefaultState().withProperty(BlockElevator.VARIANT, EnumType.SILVER);

            case 9:
                return UraBlocks.BLOCK_ELEVATOR.getDefaultState().withProperty(BlockElevator.VARIANT, EnumType.CYAN);

            case 10:
                return UraBlocks.BLOCK_ELEVATOR.getDefaultState().withProperty(BlockElevator.VARIANT, EnumType.PURPLE);

            case 11:
                return UraBlocks.BLOCK_ELEVATOR.getDefaultState().withProperty(BlockElevator.VARIANT, EnumType.BLUE);

            case 12:
                return UraBlocks.BLOCK_ELEVATOR.getDefaultState().withProperty(BlockElevator.VARIANT, EnumType.BROWN);

            case 13:
                return UraBlocks.BLOCK_ELEVATOR.getDefaultState().withProperty(BlockElevator.VARIANT, EnumType.GREEN);

            case 14:
                return UraBlocks.BLOCK_ELEVATOR.getDefaultState().withProperty(BlockElevator.VARIANT, EnumType.RED);

            case 15:
                return UraBlocks.BLOCK_ELEVATOR.getDefaultState().withProperty(BlockElevator.VARIANT, EnumType.BLACK);
        }

        return UraBlocks.BLOCK_ELEVATOR.getDefaultState().withProperty(BlockElevator.VARIANT, EnumType.WHITE);
    }
}