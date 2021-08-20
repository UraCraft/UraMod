package fr.uracraft.uramod.items;

import fr.uracraft.uramod.UraCreativeTabs;
import fr.uracraft.uramod.UraMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;

public class ItemGlassShard extends Item {

    public ItemGlassShard() {
        super();
        UraItems.setItemName(this, "glass_shard");
        setCreativeTab(UraCreativeTabs.URAMOD);
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item." + UraMod.MODID + "." + EnumType.byMetadata(stack.getMetadata()).getName();
    }

    @Override
    public void getSubItems(final CreativeTabs tab, final NonNullList<ItemStack> subItems) {
        if (this.isInCreativeTab(tab)) {
            for (ItemGlassShard.EnumType type : ItemGlassShard.EnumType.values()) {
                subItems.add(new ItemStack(this, 1, type.getMetadata()));
            }
        }
    }

    public enum EnumType implements IStringSerializable {
        NO_COLOR(0, "glass_shard"),
        WHITE(1, "glass_shard_white"),
        ORANGE(2, "glass_shard_orange"),
        MAGENTA(3, "glass_shard_magenta"),
        LIGHT_BLUE(4, "glass_shard_light_blue"),
        YELLOW(5, "glass_shard_yellow"),
        LIME(6, "glass_shard_lime"),
        PINK(7, "glass_shard_pink"),
        GRAY(8, "glass_shard_gray"),
        SILVER(9, "glass_shard_silver"),
        CYAN(10, "glass_shard_cyan"),
        PURPLE(11, "glass_shard_purple"),
        BLUE(12, "glass_shard_blue"),
        BROWN(13, "glass_shard_brown"),
        GREEN(14, "glass_shard_green"),
        RED(15, "glass_shard_red"),
        BLACK(16, "glass_shard_black");

        private static final EnumType[] META_LOOKUP = new EnumType[values().length];
        private final int meta;
        private final String name;

        EnumType(int metaIn, String nameIn) {

            this.meta = metaIn;
            this.name = nameIn;
        }

        public int getMetadata() {

            return meta;
        }

        @Override
        public String getName() {

            return name;
        }

        public static EnumType byMetadata(int meta) {
            if (meta < 0 || meta >= META_LOOKUP.length) {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        static {
            for (EnumType enumType : values()) {
                META_LOOKUP[enumType.getMetadata()] = enumType;
            }
        }
    }
}
