package fr.uracraft.uramod.items;

import fr.uracraft.uramod.UraMod;
import fr.uracraft.uramod.blocks.BlockElevator;
import fr.uracraft.uramod.blocks.UraBlocks;
import fr.uracraft.uramod.items.armors.IridiumArmor;
import fr.uracraft.uramod.items.armors.SilverArmor;
import fr.uracraft.uramod.items.armors.UraArmor;
import fr.uracraft.uramod.items.armors.UraArmorMaterials;
import fr.uracraft.uramod.items.tools.ItemAxe;
import fr.uracraft.uramod.items.tools.ItemHoe;
import fr.uracraft.uramod.items.tools.ItemPickaxe;
import fr.uracraft.uramod.items.tools.ItemShovel;
import fr.uracraft.uramod.items.tools.ItemSword;
import fr.uracraft.uramod.items.tools.UraToolMaterials;
import fr.uracraft.uramod.items.utils.SimpleItem;
import fr.uracraft.uramod.items.utils.SimpleItemBlock;
import fr.uracraft.uramod.utils.ItemBlockMetadata;
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
@SuppressWarnings("all")
public class UraItems {

    public static final Item BLOCK_ELEVATOR_ITEM = new ItemBlockMetadata(UraBlocks.BLOCK_ELEVATOR, new String[]{"elevator_block", "elevator_block_orange", "elevator_block_magenta", "elevator_block_light_blue", "elevator_block_yellow", "elevator_block_lime", "elevator_block_pink", "elevator_block_gray", "elevator_block_silver", "elevator_block_cyan", "elevator_block_purple", "elevator_block_blue", "elevator_block_brown", "elevator_block_green", "elevator_block_red", "elevator_block_black"} ).setRegistryName(UraBlocks.BLOCK_ELEVATOR.getRegistryName());

    public final static Item HANG_GLIDER = new ItemHang_Glider();
    public final static Item WORLD_SELECTOR = new ItemWorld_Selector();
    public final static Item PORTABLE_WORKBENCH = new ItemPortable_Workbench();

    public final static Item URA_INGOT = new SimpleItem("ura_ingot",URAMOD);
    public final static Item IRIDIUM_INGOT = new SimpleItem("iridium_ingot",URAMOD);
    public final static Item NEODYMIUM = new SimpleItem("neodymium",URAMOD);
    public final static Item COPPER_INGOT = new SimpleItem("copper_ingot",URAMOD);
    public final static Item TIN_INGOT = new SimpleItem("tin_ingot",URAMOD);
    public final static Item SILVER_INGOT = new SimpleItem("silver_ingot",URAMOD);

    public final static Item URA_NUGGET = new SimpleItem("ura_nugget",URAMOD);
    public final static Item SILVER_NUGGET = new SimpleItem("silver_nugget",URAMOD);
    public final static Item TIN_NUGGET = new SimpleItem("tin_nugget",URAMOD);
    public final static Item COPPER_NUGGET = new SimpleItem("copper_nugget",URAMOD);

    public final static Item URA_PARTICLE = new SimpleItem("ura_particle",URAMOD);
    public final static Item SILVER_PARTICLE = new SimpleItem("silver_particle",URAMOD);
    public final static Item TIN_PARTICLE = new SimpleItem("tin_particle",URAMOD);
    public final static Item COPPER_PARTICLE = new SimpleItem("copper_particle",URAMOD);

    public final static Item PAINT_BUCKET_WHITE = new ItemPaint(0, 15);
    public final static Item PAINT_BUCKET_ORANGE = new ItemPaint(1, 14);
    public final static Item PAINT_BUCKET_MAGENTA = new ItemPaint(2, 13);
    public final static Item PAINT_BUCKET_LIGHT_BLUE = new ItemPaint(3, 12);
    public final static Item PAINT_BUCKET_YELLOW = new ItemPaint(4, 11);
    public final static Item PAINT_BUCKET_LIME = new ItemPaint(5, 10);
    public final static Item PAINT_BUCKET_PINK = new ItemPaint(6, 9);
    public final static Item PAINT_BUCKET_GRAY = new ItemPaint(7, 8);
    public final static Item PAINT_BUCKET_SILVER = new ItemPaint(8, 7);
    public final static Item PAINT_BUCKET_CYAN = new ItemPaint(9, 6);
    public final static Item PAINT_BUCKET_PURPLE = new ItemPaint(10, 5);
    public final static Item PAINT_BUCKET_BLUE = new ItemPaint(11, 4);
    public final static Item PAINT_BUCKET_BROWN = new ItemPaint(12, 3);
    public final static Item PAINT_BUCKET_GREEN = new ItemPaint(13, 2);
    public final static Item PAINT_BUCKET_RED = new ItemPaint(14, 1);
    public final static Item PAINT_BUCKET_BLACK = new ItemPaint(15, 0);


    public final static Item URA_UPGRADE = new ItemUpgrade("ura_upgrade",1600);
    public final static Item SILVER_UPGRADE = new ItemUpgrade("silver_upgrade",600);
    public final static Item NEODYMIUM_UPGRADE = new ItemUpgrade("neodymium_upgrade",2200);
    public final static Item DIAMOND_UPGRADE = new ItemUpgrade("diamond_upgrade",400);
    public final static Item IRIDIUM_UPGRADE = new ItemUpgrade("iridium_upgrade",60000);

    public final static Item IRIDIUM_NUGGET = new SimpleItem("iridium_nugget",URAMOD);

    public static final Item URA_HELMET = new UraArmor("ura_helmet", 1, EntityEquipmentSlot.HEAD);
    public static final Item URA_CHESTPLATE = new UraArmor("ura_chestplate", 1, EntityEquipmentSlot.CHEST);
    public static final Item URA_LEGGINGS = new UraArmor("ura_leggings", 1, EntityEquipmentSlot.LEGS);
    public static final Item URA_BOOTS = new UraArmor("ura_boots", 1, EntityEquipmentSlot.FEET);
    public static final Item IRIDIUM_HELMET = new IridiumArmor("iridium_helmet", 1, EntityEquipmentSlot.HEAD);
    public static final Item IRIDIUM_CHESTPLATE = new IridiumArmor("iridium_chestplate", 1, EntityEquipmentSlot.CHEST);
    public static final Item IRIDIUM_LEGGINGS = new IridiumArmor("iridium_leggings", 1, EntityEquipmentSlot.LEGS);
    public static final Item IRIDIUM_BOOTS = new IridiumArmor("iridium_boots", 1, EntityEquipmentSlot.FEET);
    public static final Item SILVER_HELMET = new SilverArmor("silver_helmet", 1, EntityEquipmentSlot.HEAD);
    public static final Item SILVER_CHESTPLATE = new SilverArmor("silver_chestplate", 1, EntityEquipmentSlot.CHEST);
    public static final Item SILVER_LEGGINGS = new SilverArmor("silver_leggings", 1, EntityEquipmentSlot.LEGS);
    public static final Item SILVER_BOOTS = new SilverArmor("silver_boots", 1, EntityEquipmentSlot.FEET);

    public final static Item URA_ORE_ITEM = new SimpleItemBlock(UraBlocks.URA_ORE);
    public final static Item SILVER_ORE_ITEM = new SimpleItemBlock(UraBlocks.SILVER_ORE);
    public final static Item TIN_ORE_ITEM = new SimpleItemBlock(UraBlocks.TIN_ORE);
    public final static Item COPPER_ORE_ITEM = new SimpleItemBlock(UraBlocks.COPPER_ORE);
    public final static Item NEODYMIUM_ORE_ITEM = new SimpleItemBlock(UraBlocks.NEODYMIUM_ORE);

    public final static Item URA_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.URA_BLOCK);

    public final static Item URA_FURNACE_ITEM = new SimpleItemBlock(UraBlocks.URA_FURNACE);

    public final static Item SILVER_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.SILVER_BLOCK);
    public final static Item TIN_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.TIN_BLOCK);
    public final static Item COPPER_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.COPPER_BLOCK);
    public final static Item NEODYMIUM_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.NEODYMIUM_BLOCK);
    public final static Item IRIDIUM_ORE_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.IRIDIUM_ORE);
    public final static Item RANDOM_ORE_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.RANDOM_ORE);

    public static final Item URA_SWORD = new ItemSword(UraToolMaterials.URA_TOOL_MATERIAL, "ura_sword");
    public static final Item URA_PICKAXE = new ItemPickaxe(UraToolMaterials.URA_TOOL_MATERIAL, "ura_pickaxe");
    public static final Item URA_SHOVEL = new ItemShovel(UraToolMaterials.URA_TOOL_MATERIAL, "ura_shovel");
    public static final Item URA_AXE = new ItemAxe(UraToolMaterials.URA_TOOL_MATERIAL, 10.0F, 1.0F, "ura_axe");
    public static final Item URA_HOE = new ItemHoe(UraToolMaterials.URA_TOOL_MATERIAL, "ura_hoe");
    public static final Item SILVER_SWORD = new ItemSword(UraToolMaterials.SILVER_TOOL_MATERIAL, "silver_sword");
    public static final Item SILVER_PICKAXE = new ItemPickaxe(UraToolMaterials.SILVER_TOOL_MATERIAL, "silver_pickaxe");
    public static final Item SILVER_SHOVEL = new ItemShovel(UraToolMaterials.SILVER_TOOL_MATERIAL, "silver_shovel");
    public static final Item SILVER_AXE = new ItemAxe(UraToolMaterials.SILVER_TOOL_MATERIAL, 8.5F, 1.0F, "silver_axe");
    public static final Item SILVER_HOE = new ItemHoe(UraToolMaterials.SILVER_TOOL_MATERIAL, "silver_hoe");
    public static final Item IRIDIUM_SWORD = new ItemSword(UraToolMaterials.IRIDIUM_TOOL_MATERIAL, "iridium_sword");
    public static final Item IRIDIUM_PICKAXE = new ItemPickaxe(UraToolMaterials.IRIDIUM_TOOL_MATERIAL, "iridium_pickaxe");

    public final static Item CASH_POINT_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.CASH_POINT);
    public static final Item BLOCK_DIRT_STAIRS = new ItemBlock(UraBlocks.DIRT_STAIRS).setRegistryName(UraBlocks.DIRT_STAIRS.getRegistryName());
    public static final Item BLOCK_OBSIDIAN_STAIRS = new ItemBlock(UraBlocks.OBSIDIAN_STAIRS).setRegistryName(UraBlocks.OBSIDIAN_STAIRS.getRegistryName());
    public static final Item BLOCK_BEDROCK_STAIRS = new ItemBlock(UraBlocks.BEDROCK_STAIRS).setRegistryName(UraBlocks.BEDROCK_STAIRS.getRegistryName());
    public static final Item BLOCK_DIRT_SLAB = new ItemSlab(UraBlocks.DIRT_HALFSLAB, UraBlocks.DIRT_HALFSLAB, UraBlocks.DIRT_DOUBLESLAB).setRegistryName(UraBlocks.DIRT_HALFSLAB.getRegistryName());
    public static final Item BLOCK_OBSIDIAN_SLAB = new ItemSlab(UraBlocks.OBSIDIAN_HALFSLAB, UraBlocks.OBSIDIAN_HALFSLAB, UraBlocks.OBSIDIAN_DOUBLESLAB).setRegistryName(UraBlocks.OBSIDIAN_HALFSLAB.getRegistryName());
    public static final Item BLOCK_BEDROCK_SLAB = new ItemSlab(UraBlocks.BEDROCK_HALFSLAB, UraBlocks.BEDROCK_HALFSLAB, UraBlocks.BEDROCK_DOUBLESLAB).setRegistryName(UraBlocks.BEDROCK_HALFSLAB.getRegistryName());

    static {
        assert UraArmorMaterials.URA_ARMOR != null;
        UraArmorMaterials.URA_ARMOR.setRepairItem(new ItemStack(UraItems.URA_INGOT));
    }


    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerItemModels(ModelRegistryEvent event) {

        registerModel(URA_UPGRADE,"upgrade");
        registerModel(SILVER_UPGRADE,"upgrade");
        registerModel(NEODYMIUM_UPGRADE,"upgrade");
        registerModel(DIAMOND_UPGRADE,"upgrade");
        registerModel(IRIDIUM_UPGRADE,"upgrade");

        registerModel(HANG_GLIDER);
        registerModel(WORLD_SELECTOR);
        registerModel(PORTABLE_WORKBENCH);
        registerModel(IRIDIUM_ORE_BLOCK_ITEM);

        registerModel(URA_HELMET);
        registerModel(URA_CHESTPLATE);
        registerModel(URA_LEGGINGS);
        registerModel(URA_BOOTS);
        registerModel(IRIDIUM_HELMET);
        registerModel(IRIDIUM_CHESTPLATE);
        registerModel(IRIDIUM_LEGGINGS);
        registerModel(IRIDIUM_BOOTS);
        registerModel(SILVER_HELMET);
        registerModel(SILVER_CHESTPLATE);
        registerModel(SILVER_LEGGINGS);
        registerModel(SILVER_BOOTS);
      
        registerModel(URA_INGOT);
        registerModel(IRIDIUM_INGOT);
        registerModel(NEODYMIUM);
        registerModel(COPPER_INGOT);
        registerModel(TIN_INGOT);
        registerModel(SILVER_INGOT);
        registerModel(IRIDIUM_NUGGET);

        registerModel(URA_NUGGET);
        registerModel(SILVER_NUGGET);
        registerModel(TIN_NUGGET);
        registerModel(COPPER_NUGGET);

        registerModel(URA_PARTICLE);
        registerModel(SILVER_PARTICLE);
        registerModel(TIN_PARTICLE);
        registerModel(COPPER_PARTICLE);

        registerModel(URA_ORE_ITEM);
        registerModel(SILVER_ORE_ITEM);
        registerModel(TIN_ORE_ITEM);
        registerModel(COPPER_ORE_ITEM);
        registerModel(NEODYMIUM_ORE_ITEM);
        registerModel(RANDOM_ORE_BLOCK_ITEM);

        registerModel(URA_BLOCK_ITEM);
        registerModel(SILVER_BLOCK_ITEM);
        registerModel(TIN_BLOCK_ITEM);
        registerModel(COPPER_BLOCK_ITEM);
        registerModel(NEODYMIUM_BLOCK_ITEM);

        registerModel(CASH_POINT_BLOCK_ITEM);
        registerModel(BLOCK_DIRT_STAIRS);
        registerModel(BLOCK_OBSIDIAN_STAIRS);
        registerModel(BLOCK_BEDROCK_STAIRS);
        registerModel(BLOCK_DIRT_SLAB);
        registerModel(BLOCK_OBSIDIAN_SLAB);
        registerModel(BLOCK_BEDROCK_SLAB);

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

        registerModel(URA_HOE, "tools");
        registerModel(URA_AXE, "tools");
        registerModel(URA_PICKAXE, "tools");
        registerModel(URA_SHOVEL, "tools");
        registerModel(URA_SWORD, "tools");
        registerModel(SILVER_HOE, "tools");
        registerModel(SILVER_AXE, "tools");
        registerModel(SILVER_PICKAXE, "tools");
        registerModel(SILVER_SHOVEL, "tools");
        registerModel(SILVER_SWORD, "tools");
        registerModel(IRIDIUM_PICKAXE, "tools");
        registerModel(IRIDIUM_SWORD, "tools");

        registerModel(URA_FURNACE_ITEM);

        for (int i = 0; i < BlockElevator.EnumType.values().length; i++)
            if(i == 0){
                registerModel(BLOCK_ELEVATOR_ITEM, i, null, "uramod:elevator_block", "elevator");
            }else {
                registerModel(BLOCK_ELEVATOR_ITEM, i, null, "uramod:elevator_block_" + EnumDyeColor.byMetadata(i).getName(), "elevator");
            }
    }

    public static void setItemName(Item item, String name) {
        item.setRegistryName(UraMod.MODID, name).setUnlocalizedName(UraMod.MODID + "." + name);
    }

    @SideOnly(Side.CLIENT)
    public static void registerModel(Item item) {
        registerModel(item, 0, null, null , null);
    }

    @SideOnly(Side.CLIENT)
    public static void registerModel(Item item, String folderModel) {
        registerModel(item, 0, null, null, folderModel);
    }

    @SideOnly(Side.CLIENT)
    public static void registerModel(Item item, int metadata, String name, String resourceName, String folderModel) {
        if(metadata < 0) metadata = 0;
        if(resourceName == null) resourceName = item.getUnlocalizedName().substring(5).replace(".", ":");
        if(name != null) resourceName += "_"+name;
        if(folderModel != null) resourceName = resourceName.split(":")[0] + ":" + folderModel + "/" + resourceName.split(":")[1];

        ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(resourceName, "inventory"));
    }
}
