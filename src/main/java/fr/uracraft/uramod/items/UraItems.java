package fr.uracraft.uramod.items;

import fr.uracraft.uramod.UraMod;
import fr.uracraft.uramod.blocks.UraBlocks;
import fr.uracraft.uramod.items.armors.IridiumArmor;
import fr.uracraft.uramod.items.armors.UraArmor;
import fr.uracraft.uramod.items.utils.SimpleItem;
import fr.uracraft.uramod.items.utils.SimpleItemBlock;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static fr.uracraft.uramod.UraCreativeTabs.URAMOD;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid= UraMod.MODID)
public class UraItems {

    public static final ItemArmor.ArmorMaterial URA_ARMOR = EnumHelper.addArmorMaterial("ura_armor", UraMod.MODID+":ura", 37, new int[] {3, 8, 6, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4F);
    public static final ItemArmor.ArmorMaterial IRIDIUM_ARMOR = EnumHelper.addArmorMaterial("iridium_armor", UraMod.MODID+":iridium", 74, new int[] {3, 8, 6, 3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4F);

    public final static Item HANG_GLIDER = new ItemHang_Glider();

    public final static Item URA_INGOT = new SimpleItem("ura_ingot",URAMOD);
    public final static Item NEODYMIUM = new SimpleItem("neodymium",URAMOD);
    public final static Item COPPER_INGOT = new SimpleItem("copper_ingot",URAMOD);
    public final static Item TIN_INGOT = new SimpleItem("tin_ingot",URAMOD);
    public final static Item SILVER_INGOT = new SimpleItem("silver_ingot",URAMOD);

    public final static Item URA_NUGGET = new SimpleItem("ura_nugget",URAMOD);
    public final static Item SILVER_NUGGET = new SimpleItem("silver_nugget",URAMOD);
    public final static Item TIN_NUGGET = new SimpleItem("tin_nugget",URAMOD);
    public final static Item COPPER_NUGGET = new SimpleItem("copper_nugget",URAMOD);

    public final static Item PAINT_BUCKET_WHITE = new ItemPaint(0);
    public final static Item PAINT_BUCKET_ORANGE = new ItemPaint(1);
    public final static Item PAINT_BUCKET_MAGENTA = new ItemPaint(2);
    public final static Item PAINT_BUCKET_LIGHT_BLUE = new ItemPaint(3);
    public final static Item PAINT_BUCKET_YELLOW = new ItemPaint(4);
    public final static Item PAINT_BUCKET_LIME = new ItemPaint(5);
    public final static Item PAINT_BUCKET_PINK = new ItemPaint(6);
    public final static Item PAINT_BUCKET_GRAY = new ItemPaint(7);
    public final static Item PAINT_BUCKET_SILVER = new ItemPaint(8);
    public final static Item PAINT_BUCKET_CYAN = new ItemPaint(9);
    public final static Item PAINT_BUCKET_PURPLE = new ItemPaint(10);
    public final static Item PAINT_BUCKET_BLUE = new ItemPaint(11);
    public final static Item PAINT_BUCKET_BROWN = new ItemPaint(12);
    public final static Item PAINT_BUCKET_GREEN = new ItemPaint(13);
    public final static Item PAINT_BUCKET_RED = new ItemPaint(14);
    public final static Item PAINT_BUCKET_BLACK = new ItemPaint(15);

    public static final Item URA_HELMET = new UraArmor("ura_helmet", 1, EntityEquipmentSlot.HEAD);
    public static final Item URA_CHESTPLATE = new UraArmor("ura_chestplate", 1, EntityEquipmentSlot.CHEST);
    public static final Item URA_LEGGINGS = new UraArmor("ura_leggings", 2, EntityEquipmentSlot.LEGS);
    public static final Item URA_BOOTS = new UraArmor("ura_boots", 1, EntityEquipmentSlot.FEET);
    public static final Item IRIDIUM_HELMET = new IridiumArmor("iridium_helmet", 1, EntityEquipmentSlot.HEAD);
    public static final Item IRIDIUM_CHESTPLATE = new IridiumArmor("iridium_chestplate", 1, EntityEquipmentSlot.CHEST);
    public static final Item IRIDIUM_LEGGINGS = new IridiumArmor("iridium_leggings", 2, EntityEquipmentSlot.LEGS);
    public static final Item IRIDIUM_BOOTS = new IridiumArmor("iridium_boots", 1, EntityEquipmentSlot.FEET);

    public final static Item URA_ORE_ITEM = new SimpleItemBlock(UraBlocks.URA_ORE);
    public final static Item SILVER_ORE_ITEM = new SimpleItemBlock(UraBlocks.SILVER_ORE);
    public final static Item TIN_ORE_ITEM = new SimpleItemBlock(UraBlocks.TIN_ORE);
    public final static Item COPPER_ORE_ITEM = new SimpleItemBlock(UraBlocks.COPPER_ORE);
    public final static Item NEODYMIUM_ORE_ITEM = new SimpleItemBlock(UraBlocks.NEODYMIUM_ORE);

    public final static Item URA_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.URA_BLOCK);
    public final static Item SILVER_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.SILVER_BLOCK);
    public final static Item TIN_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.TIN_BLOCK);
    public final static Item COPPER_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.COPPER_BLOCK);
    public final static Item NEODYMIUM_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.NEODYMIUM_BLOCK);

    public final static Item CASH_POINT_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.CASH_POINT);
    public static final Item BLOCK_DIRT_STAIRS = new ItemBlock(UraBlocks.DIRT_STAIRS).setRegistryName(UraBlocks.DIRT_STAIRS.getRegistryName());
    public static final Item BLOCK_DIRT_SLAB = new ItemSlab(UraBlocks.DIRT_HALFSLAB, UraBlocks.DIRT_HALFSLAB, UraBlocks.DIRT_DOUBLESLAB).setRegistryName(UraBlocks.DIRT_HALFSLAB.getRegistryName());

    static {
        URA_ARMOR.setRepairItem(new ItemStack(UraItems.URA_INGOT));
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerItemModels(ModelRegistryEvent event) {
        registerModel(HANG_GLIDER);

        registerModel(URA_HELMET);
        registerModel(URA_CHESTPLATE);
        registerModel(URA_LEGGINGS);
        registerModel(URA_BOOTS);
        registerModel(IRIDIUM_HELMET);
        registerModel(IRIDIUM_CHESTPLATE);
        registerModel(IRIDIUM_LEGGINGS);
        registerModel(IRIDIUM_BOOTS);

        registerModel(URA_INGOT);
        registerModel(NEODYMIUM);
        registerModel(COPPER_INGOT);
        registerModel(TIN_INGOT);
        registerModel(SILVER_INGOT);

        registerModel(URA_NUGGET);
        registerModel(SILVER_NUGGET);
        registerModel(TIN_NUGGET);
        registerModel(COPPER_NUGGET);

        registerModel(URA_ORE_ITEM);
        registerModel(SILVER_ORE_ITEM);
        registerModel(TIN_ORE_ITEM);
        registerModel(COPPER_ORE_ITEM);
        registerModel(NEODYMIUM_ORE_ITEM);

        registerModel(URA_BLOCK_ITEM);
        registerModel(SILVER_BLOCK_ITEM);
        registerModel(TIN_BLOCK_ITEM);
        registerModel(COPPER_BLOCK_ITEM);
        registerModel(NEODYMIUM_BLOCK_ITEM);

        registerModel(CASH_POINT_BLOCK_ITEM);
        registerModel(BLOCK_DIRT_STAIRS);
        registerModel(BLOCK_DIRT_SLAB);

        registerModel(PAINT_BUCKET_WHITE,"paint");
        registerModel(PAINT_BUCKET_ORANGE,"paint");
        registerModel(PAINT_BUCKET_MAGENTA,"paint");
        registerModel(PAINT_BUCKET_LIGHT_BLUE,"paint");
        registerModel(PAINT_BUCKET_YELLOW,"paint");
        registerModel(PAINT_BUCKET_LIME,"paint");
        registerModel(PAINT_BUCKET_PINK,"paint");
        registerModel(PAINT_BUCKET_GRAY,"paint");
        registerModel(PAINT_BUCKET_SILVER,"paint");
        registerModel(PAINT_BUCKET_CYAN,"paint");
        registerModel(PAINT_BUCKET_PURPLE,"paint");
        registerModel(PAINT_BUCKET_BLUE,"paint");
        registerModel(PAINT_BUCKET_BROWN,"paint");
        registerModel(PAINT_BUCKET_GREEN,"paint");
        registerModel(PAINT_BUCKET_RED,"paint");
        registerModel(PAINT_BUCKET_BLACK,"paint");

    }

    public static void setItemName(Item item, String name) {
        item.setRegistryName(UraMod.MODID, name).setUnlocalizedName(UraMod.MODID + "." + name);
    }

    @SideOnly(Side.CLIENT)
    public static void registerModel(Item item) {
        registerModel(item, 0, null, null);
    }

    @SideOnly(Side.CLIENT)
    public static void registerModel(Item item, String folderModel) {
        registerModel(item, 0, null, folderModel);
    }

    @SideOnly(Side.CLIENT)
    public static void registerModel(Item item, int metadata, String name, String folderModel) {
        if(metadata < 0) metadata = 0;
        String resourceName = item.getUnlocalizedName().substring(5).replace(".", ":");
        if(name != null) resourceName += "_"+name;
        if(folderModel != null) resourceName = resourceName.split(":")[0] + ":" + folderModel + "/" + resourceName.split(":")[1];

        ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(resourceName, "inventory"));
    }
}
