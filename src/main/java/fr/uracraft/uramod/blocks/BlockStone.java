package fr.uracraft.uramod.blocks;

import fr.uracraft.uramod.utils.Random;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockStone extends Block {

    public static final PropertyEnum<BlockStone.EnumType> VARIANT = PropertyEnum.create("variant", BlockStone.EnumType.class);

    public BlockStone() {
        super(Material.ROCK);
        UraBlocks.setBlockName(this, "stone");
        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumType.BASIC));
        setHardness(1.5F);
        setResistance(10.0F);
        setSoundType(SoundType.STONE);
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        if (state == this.blockState.getBaseState().withProperty(VARIANT, EnumType.COAL)) {
            drops.add(new ItemStack(Items.DIAMOND, 1));
        } else if (state == this.blockState.getBaseState().withProperty(VARIANT, EnumType.REDSTONE)) {
            drops.add(new ItemStack(Items.REDSTONE, Random.roll(4, 5)));
        } else if (state == this.blockState.getBaseState().withProperty(VARIANT, EnumType.IRON)) {
            drops.add(new ItemStack(Item.getItemFromBlock(Blocks.IRON_ORE), 1));
        } else if (state == this.blockState.getBaseState().withProperty(VARIANT, EnumType.GOLD)) {
            drops.add(new ItemStack(Item.getItemFromBlock(Blocks.GOLD_ORE), 1));
        } else if (state == this.blockState.getBaseState().withProperty(VARIANT, EnumType.LAPIS)) {
            drops.add(new ItemStack(Items.DYE, Random.roll(4, 8), (byte)4));
        } else if (state == this.blockState.getBaseState().withProperty(VARIANT, EnumType.EMERALD)) {
            drops.add(new ItemStack(Items.EMERALD, 1));
        } else if (state == this.blockState.getBaseState().withProperty(VARIANT, EnumType.DIAMOND)) {
            drops.add(new ItemStack(Items.DIAMOND, 1));
        } else if (state == this.blockState.getBaseState().withProperty(VARIANT, EnumType.SILVER)) {
            drops.add(new ItemStack(Item.getItemFromBlock(UraBlocks.SILVER_ORE), 1));
        } else if (state == this.blockState.getBaseState().withProperty(VARIANT, EnumType.COPPER)) {
            drops.add(new ItemStack(Item.getItemFromBlock(UraBlocks.COPPER_ORE), 1));
        } else if (state == this.blockState.getBaseState().withProperty(VARIANT, EnumType.TIN)) {
            drops.add(new ItemStack(Item.getItemFromBlock(UraBlocks.TIN_ORE), 1));
        } else if (state == this.blockState.getBaseState().withProperty(VARIANT, EnumType.NEODYMIUM)) {
            drops.add(new ItemStack(Item.getItemFromBlock(UraBlocks.NEODYMIUM_ORE), 1));
        } else if (state == this.blockState.getBaseState().withProperty(VARIANT, EnumType.RANDOM)) {
            drops.add(new ItemStack(Item.getItemFromBlock(UraBlocks.RANDOM_ORE), 1));
        } else if (state == this.blockState.getBaseState().withProperty(VARIANT, EnumType.URA)) {
            drops.add(new ItemStack(Item.getItemFromBlock(UraBlocks.URA_ORE), 1));
        } else {
            drops.add(new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE), 1));
        }
    }

    @Override
    public int damageDropped(IBlockState state) {
        return state.getValue(VARIANT).getMetadata();
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> items) {
        for (BlockStone.EnumType type : BlockStone.EnumType.values()) {
            items.add(new ItemStack(this, 1, type.getMetadata()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(VARIANT, EnumType.byMetadata(meta));
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
        BASIC(0, "stone_basic"),
        COAL(1, "stone_coal"),
        REDSTONE(2, "stone_redstone"),
        IRON(3, "stone_iron"),
        GOLD(4, "stone_gold"),
        LAPIS(5, "stone_lapis"),
        EMERALD(6, "stone_emerald"),
        DIAMOND(7, "stone_diamond"),
        SILVER(8, "stone_silver"),
        COPPER(9, "stone_copper"),
        TIN(10, "stone_tin"),
        NEODYMIUM(11, "stone_neodymium"),
        RANDOM(12, "stone_random"),
        URA(13, "stone_ura");

        private static final BlockStone.EnumType[] META_LOOKUP = new BlockStone.EnumType[values().length];
        private final int meta;
        private final String name;

        EnumType(int metaIn, String nameIn) {
            this.meta = metaIn;
            this.name = nameIn;
        }

        public int getMetadata() {
            return this.meta;
        }

        public static BlockStone.EnumType byMetadata(int meta) {
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
            for (BlockStone.EnumType type : values()) {
                META_LOOKUP[type.getMetadata()] = type;
            }
        }
    }
}
