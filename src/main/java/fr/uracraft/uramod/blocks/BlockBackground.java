package fr.uracraft.uramod.blocks;

import fr.uracraft.uramod.UraCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;

public class BlockBackground extends Block {

    public static final PropertyEnum<BlockBackground.EnumType> VARIANT = PropertyEnum.create("variant", BlockBackground.EnumType.class);

    public BlockBackground() {
        super(Material.GLASS);
        UraBlocks.setBlockName(this, "background");
        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockBackground.EnumType.WHITE));
        setCreativeTab(UraCreativeTabs.BUILDING);
        setHardness(0.3F);
        setResistance(1.5F);
        setLightLevel(1.0F);
        setHarvestLevel("pickaxe", 2);
        useNeighborBrightness = true;
        setSoundType(SoundType.GLASS);
    }

    @Override
    public int damageDropped(IBlockState state) {
        return state.getValue(VARIANT).getMetadata();
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> items) {
        for (BlockBackground.EnumType type : BlockBackground.EnumType.values()) {
            items.add(new ItemStack(this, 1, type.getMetadata()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(VARIANT, BlockBackground.EnumType.byMetadata(meta));
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
        WHITE(0, "background"),
        ORANGE(1, "background_orange"),
        MAGENTA(2, "background_magenta"),
        LIGHT_BLUE(3, "background_light_blue"),
        YELLOW(4, "background_yellow"),
        LIME(5, "background_lime"),
        PINK(6, "background_pink"),
        GRAY(7, "background_gray"),
        SILVER(8, "background_silver"),
        CYAN(9, "background_cyan"),
        PURPLE(10, "background_purple"),
        BLUE(11, "background_blue"),
        BROWN(12, "background_brown"),
        GREEN(13, "background_green"),
        RED(14, "background_red"),
        BLACK(15, "background_black");

        private static final BlockBackground.EnumType[] META_LOOKUP = new BlockBackground.EnumType[values().length];
        private final int meta;
        private final String name;

        EnumType(int metaIn, String nameIn) {
            this.meta = metaIn;
            this.name = nameIn;
        }

        public int getMetadata() {
            return this.meta;
        }

        public static BlockBackground.EnumType byMetadata(int meta) {
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
            for (BlockBackground.EnumType type : values()) {
                META_LOOKUP[type.getMetadata()] = type;
            }
        }
    }
}
