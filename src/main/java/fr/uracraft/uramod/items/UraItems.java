package fr.uracraft.uramod.items;

import fr.uracraft.uramod.UraMod;
import fr.uracraft.uramod.blocks.UraBlocks;
import fr.uracraft.uramod.items.armors.IridiumArmor;
import fr.uracraft.uramod.items.armors.SilverArmor;
import fr.uracraft.uramod.items.armors.UraArmor;
import fr.uracraft.uramod.items.armors.UraArmorMaterials;
import fr.uracraft.uramod.items.tools.*;
import fr.uracraft.uramod.items.tools.ItemAxe;
import fr.uracraft.uramod.items.tools.ItemHoe;
import fr.uracraft.uramod.items.tools.ItemPickaxe;
import fr.uracraft.uramod.items.tools.ItemSword;
import fr.uracraft.uramod.items.utils.SimpleItem;
import fr.uracraft.uramod.items.utils.SimpleItemBlock;
import fr.uracraft.uramod.utils.ItemBlockMetadata;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static fr.uracraft.uramod.UraCreativeTabs.URAMOD;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = UraMod.MODID)
@SuppressWarnings("all")
public class UraItems {

    //Ingots
    public final static Item URA_INGOT = new SimpleItem("ura_ingot", URAMOD);
    public final static Item IRIDIUM_INGOT = new SimpleItem("iridium_ingot", URAMOD);
    public final static Item NEODYMIUM = new SimpleItem("neodymium", URAMOD);
    public final static Item COPPER_INGOT = new SimpleItem("copper_ingot", URAMOD);
    public final static Item TIN_INGOT = new SimpleItem("tin_ingot", URAMOD);
    public final static Item SILVER_INGOT = new SimpleItem("silver_ingot", URAMOD);

    //Nuggets
    public final static Item URA_NUGGET = new SimpleItem("ura_nugget", URAMOD);
    public final static Item SILVER_NUGGET = new SimpleItem("silver_nugget", URAMOD);
    public final static Item TIN_NUGGET = new SimpleItem("tin_nugget", URAMOD);
    public final static Item COPPER_NUGGET = new SimpleItem("copper_nugget", URAMOD);
    public final static Item IRIDIUM_NUGGET = new SimpleItem("iridium_nugget", URAMOD);

    //Particles
    public final static Item URA_PARTICLE = new SimpleItem("ura_particle", URAMOD);
    public final static Item SILVER_PARTICLE = new SimpleItem("silver_particle", URAMOD);
    public final static Item TIN_PARTICLE = new SimpleItem("tin_particle", URAMOD);
    public final static Item COPPER_PARTICLE = new SimpleItem("copper_particle", URAMOD);

    //Paint Buckets
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

    //Furnace Upgrades
    public final static Item URA_UPGRADE = new ItemUpgrade("ura_upgrade", 1600);
    public final static Item SILVER_UPGRADE = new ItemUpgrade("silver_upgrade", 600);
    public final static Item NEODYMIUM_UPGRADE = new ItemUpgrade("neodymium_upgrade", 2200);
    public final static Item DIAMOND_UPGRADE = new ItemUpgrade("diamond_upgrade", 400);
    public final static Item IRIDIUM_UPGRADE = new ItemUpgrade("iridium_upgrade", 60000);

    //Armors
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

    //Tools
    public static final Item URA_SWORD = new ItemSword(UraToolMaterials.URA_TOOL_MATERIAL, "ura_sword");
    public static final Item URA_PICKAXE = new ItemPickaxe(UraToolMaterials.URA_TOOL_MATERIAL, "ura_pickaxe");
    public static final Item URA_SHOVEL = new ItemShovel(UraToolMaterials.URA_TOOL_MATERIAL, "ura_shovel");
    public static final Item URA_AXE = new ItemAxe(UraToolMaterials.URA_TOOL_MATERIAL, 10.0F, -3.0F, "ura_axe");
    public static final Item URA_HOE = new ItemHoe(UraToolMaterials.URA_TOOL_MATERIAL, "ura_hoe");
    public static final Item SILVER_SWORD = new ItemSword(UraToolMaterials.SILVER_TOOL_MATERIAL, "silver_sword");
    public static final Item SILVER_PICKAXE = new ItemPickaxe(UraToolMaterials.SILVER_TOOL_MATERIAL, "silver_pickaxe");
    public static final Item SILVER_SHOVEL = new ItemShovel(UraToolMaterials.SILVER_TOOL_MATERIAL, "silver_shovel");
    public static final Item SILVER_AXE = new ItemAxe(UraToolMaterials.SILVER_TOOL_MATERIAL, 6.0F, -3.0F, "silver_axe");
    public static final Item SILVER_HOE = new ItemHoe(UraToolMaterials.SILVER_TOOL_MATERIAL, "silver_hoe");
    public static final Item IRIDIUM_SWORD = new ItemIridiumSword();
    public static final Item IRIDIUM_PICKAXE = new ItemPickaxe(UraToolMaterials.IRIDIUM_TOOL_MATERIAL, "iridium_pickaxe").setMaxDamage(0);
    public static final Item HAMMER = new ItemHammer(UraToolMaterials.HAMMER_TOOL_MATERIAL, "hammer");

    //Other
    public final static Item HANG_GLIDER = new ItemHang_Glider();
    public final static Item WORLD_SELECTOR = new ItemWorld_Selector();
    public final static Item PORTABLE_WORKBENCH = new ItemPortable_Workbench();
    public static final Item GLASS_SHARD = new ItemGlassShard();

    ////////////////////////////////////////////////Items Blocks////////////////////////////////////////////////////////

    //Ores
    public final static Item URA_ORE_ITEM = new SimpleItemBlock(UraBlocks.URA_ORE);
    public final static Item SILVER_ORE_ITEM = new SimpleItemBlock(UraBlocks.SILVER_ORE);
    public final static Item TIN_ORE_ITEM = new SimpleItemBlock(UraBlocks.TIN_ORE);
    public final static Item COPPER_ORE_ITEM = new SimpleItemBlock(UraBlocks.COPPER_ORE);
    public final static Item NEODYMIUM_ORE_ITEM = new SimpleItemBlock(UraBlocks.NEODYMIUM_ORE);
    public final static Item IRIDIUM_ORE_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.IRIDIUM_ORE);
    public final static Item RANDOM_ORE_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.RANDOM_ORE);

    //Ore Blocks
    public final static Item SILVER_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.SILVER_BLOCK);
    public final static Item TIN_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.TIN_BLOCK);
    public final static Item COPPER_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.COPPER_BLOCK);
    public final static Item NEODYMIUM_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.NEODYMIUM_BLOCK);
    public final static Item URA_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.URA_BLOCK);

    //Stairs
    public static final Item BLOCK_DIRT_STAIRS = new ItemBlock(UraBlocks.DIRT_STAIRS).setRegistryName(UraBlocks.DIRT_STAIRS.getRegistryName());
    public static final Item BLOCK_OBSIDIAN_STAIRS = new ItemBlock(UraBlocks.OBSIDIAN_STAIRS).setRegistryName(UraBlocks.OBSIDIAN_STAIRS.getRegistryName());
    public static final Item BLOCK_BEDROCK_STAIRS = new ItemBlock(UraBlocks.BEDROCK_STAIRS).setRegistryName(UraBlocks.BEDROCK_STAIRS.getRegistryName());

    //Slabs
    public static final Item BLOCK_DIRT_SLAB = new ItemSlab(UraBlocks.DIRT_HALFSLAB, UraBlocks.DIRT_HALFSLAB, UraBlocks.DIRT_DOUBLESLAB).setRegistryName(UraBlocks.DIRT_HALFSLAB.getRegistryName());
    public static final Item BLOCK_OBSIDIAN_SLAB = new ItemSlab(UraBlocks.OBSIDIAN_HALFSLAB, UraBlocks.OBSIDIAN_HALFSLAB, UraBlocks.OBSIDIAN_DOUBLESLAB).setRegistryName(UraBlocks.OBSIDIAN_HALFSLAB.getRegistryName());
    public static final Item BLOCK_BEDROCK_SLAB = new ItemSlab(UraBlocks.BEDROCK_HALFSLAB, UraBlocks.BEDROCK_HALFSLAB, UraBlocks.BEDROCK_DOUBLESLAB).setRegistryName(UraBlocks.BEDROCK_HALFSLAB.getRegistryName());

    //Chests
    public final static Item URA_CHEST_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.URA_CHEST);
    public final static Item DIAMOND_CHEST_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.DIAMOND_CHEST);
    public final static Item SILVER_CHEST_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.SILVER_CHEST);
    public final static Item GOLD_CHEST_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.GOLD_CHEST);
    public final static Item IRON_CHEST_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.IRON_CHEST);
    public final static Item STONE_CHEST_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.STONE_CHEST);

    //Energy
    public final static Item ENERGY_REGULATOR_ITEM = new SimpleItemBlock(UraBlocks.ENERGY_REGULATOR);

    //Other
    public static final Item BLOCK_ELEVATOR_ITEM = new ItemBlockMetadata(UraBlocks.BLOCK_ELEVATOR, new String[]{"elevator", "elevator_orange", "elevator_magenta", "elevator_light_blue", "elevator_yellow", "elevator_lime", "elevator_pink", "elevator_gray", "elevator_silver", "elevator_cyan", "elevator_purple", "elevator_blue", "elevator_brown", "elevator_green", "elevator_red", "elevator_black"}).setRegistryName(UraBlocks.BLOCK_ELEVATOR.getRegistryName());
    public static final Item BLOCK_BACKGROUND_ITEM = new ItemBlockMetadata(UraBlocks.BLOCK_BACKGROUND, new String[]{"background", "background_orange", "background_magenta", "background_light_blue", "background_yellow", "background_lime", "background_pink", "background_gray", "background_silver", "background_cyan", "background_purple", "background_blue", "background_brown", "background_green", "background_red", "background_black"}).setRegistryName(UraBlocks.BLOCK_BACKGROUND.getRegistryName());
    public final static Item URA_FURNACE_ITEM = new SimpleItemBlock(UraBlocks.URA_FURNACE);
    public final static Item CASH_POINT_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.CASH_POINT);
    public final static Item FERTILIZED_DIRT_ITEM = new SimpleItemBlock(UraBlocks.FERTILIZED_DIRT);

    static {
        UraArmorMaterials.URA_ARMOR.setRepairItem(new ItemStack(UraItems.URA_INGOT));
        UraArmorMaterials.SILVER_ARMOR.setRepairItem(new ItemStack(UraItems.SILVER_INGOT));
        UraToolMaterials.HAMMER_TOOL_MATERIAL.setRepairItem(new ItemStack(UraItems.URA_INGOT));
        UraToolMaterials.URA_TOOL_MATERIAL.setRepairItem(new ItemStack(UraItems.URA_INGOT));
        UraToolMaterials.SILVER_TOOL_MATERIAL.setRepairItem(new ItemStack(UraItems.SILVER_INGOT));
    }


    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerItemModels(ModelRegistryEvent event) {

        //Ingots
        registerModel(URA_INGOT);
        registerModel(IRIDIUM_INGOT);
        registerModel(NEODYMIUM);
        registerModel(COPPER_INGOT);
        registerModel(TIN_INGOT);
        registerModel(SILVER_INGOT);

        //Nuggets
        registerModel(IRIDIUM_NUGGET);
        registerModel(URA_NUGGET);
        registerModel(SILVER_NUGGET);
        registerModel(TIN_NUGGET);
        registerModel(COPPER_NUGGET);

        //Particles
        registerModel(URA_PARTICLE);
        registerModel(SILVER_PARTICLE);
        registerModel(TIN_PARTICLE);
        registerModel(COPPER_PARTICLE);

        //Paint Buckets
        registerModel(PAINT_BUCKET_WHITE, "paint");
        registerModel(PAINT_BUCKET_ORANGE, "paint");
        registerModel(PAINT_BUCKET_MAGENTA, "paint");
        registerModel(PAINT_BUCKET_LIGHT_BLUE, "paint");
        registerModel(PAINT_BUCKET_YELLOW, "paint");
        registerModel(PAINT_BUCKET_LIME, "paint");
        registerModel(PAINT_BUCKET_PINK, "paint");
        registerModel(PAINT_BUCKET_GRAY, "paint");
        registerModel(PAINT_BUCKET_SILVER, "paint");
        registerModel(PAINT_BUCKET_CYAN, "paint");
        registerModel(PAINT_BUCKET_PURPLE, "paint");
        registerModel(PAINT_BUCKET_BLUE, "paint");
        registerModel(PAINT_BUCKET_BROWN, "paint");
        registerModel(PAINT_BUCKET_GREEN, "paint");
        registerModel(PAINT_BUCKET_RED, "paint");
        registerModel(PAINT_BUCKET_BLACK, "paint");

        //Furnace Upgrades
        registerModel(URA_UPGRADE, "upgrade");
        registerModel(SILVER_UPGRADE, "upgrade");
        registerModel(NEODYMIUM_UPGRADE, "upgrade");
        registerModel(DIAMOND_UPGRADE, "upgrade");
        registerModel(IRIDIUM_UPGRADE, "upgrade");

        //Armors
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

        //Tools
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
        registerModel(HAMMER, "tools");

        //Other
        registerModel(HANG_GLIDER);
        registerModel(WORLD_SELECTOR);
        registerModel(PORTABLE_WORKBENCH);
        for (int i = 0; i < ItemGlassShard.EnumType.values().length; i++)
            registerModel(GLASS_SHARD, i, null, "uramod:" + ItemGlassShard.EnumType.byMetadata(i).getName(), "glass_shard");
        for (int i = 0; i < ItemIridiumSword.ores.length; i++)
            registerModel(IRIDIUM_SWORD, i, null, "uramod:" + ItemIridiumSword.byMetadata(i), "tools");

        //////////////////////////////////////////////Items Blocks//////////////////////////////////////////////////////

        //Ores
        registerModel(IRIDIUM_ORE_BLOCK_ITEM);
        registerModel(URA_ORE_ITEM);
        registerModel(SILVER_ORE_ITEM);
        registerModel(TIN_ORE_ITEM);
        registerModel(COPPER_ORE_ITEM);
        registerModel(NEODYMIUM_ORE_ITEM);
        registerModel(RANDOM_ORE_BLOCK_ITEM);

        //Ore Blocks
        registerModel(URA_BLOCK_ITEM);
        registerModel(SILVER_BLOCK_ITEM);
        registerModel(TIN_BLOCK_ITEM);
        registerModel(COPPER_BLOCK_ITEM);
        registerModel(NEODYMIUM_BLOCK_ITEM);

        //Stairs
        registerModel(BLOCK_DIRT_STAIRS);
        registerModel(BLOCK_OBSIDIAN_STAIRS);
        registerModel(BLOCK_BEDROCK_STAIRS);

        //Slabs
        registerModel(BLOCK_DIRT_SLAB);
        registerModel(BLOCK_OBSIDIAN_SLAB);
        registerModel(BLOCK_BEDROCK_SLAB);

        //Chests
        registerModel(URA_CHEST_BLOCK_ITEM, "chests");
        registerModel(DIAMOND_CHEST_BLOCK_ITEM, "chests");
        registerModel(SILVER_CHEST_BLOCK_ITEM, "chests");
        registerModel(GOLD_CHEST_BLOCK_ITEM, "chests");
        registerModel(IRON_CHEST_BLOCK_ITEM, "chests");
        registerModel(STONE_CHEST_BLOCK_ITEM, "chests");

        //Energy
        registerModel(ENERGY_REGULATOR_ITEM, "energy");

        //Other
        registerModel(CASH_POINT_BLOCK_ITEM);
        registerModel(URA_FURNACE_ITEM);
        registerModel(FERTILIZED_DIRT_ITEM);

        for (int i = 0; i < EnumDyeColor.values().length; i++)
            if (i == 0) {
                registerModel(BLOCK_ELEVATOR_ITEM, i, null, "uramod:elevator", "elevator");
                registerModel(BLOCK_BACKGROUND_ITEM, i, null, "uramod:background", "background");
            } else {
                registerModel(BLOCK_ELEVATOR_ITEM, i, null, "uramod:elevator_" + EnumDyeColor.byMetadata(i).getName(), "elevator");
                registerModel(BLOCK_BACKGROUND_ITEM, i, null, "uramod:background_" + EnumDyeColor.byMetadata(i).getName(), "background");
            }

    }

    public static void setItemName(Item item, String name) {
        item.setRegistryName(UraMod.MODID, name).setUnlocalizedName(UraMod.MODID + "." + name);
    }

    @SideOnly(Side.CLIENT)
    public static void registerModel(Item item) {
        registerModel(item, 0, null, null, null);
    }

    @SideOnly(Side.CLIENT)
    public static void registerModel(Item item, String folderModel) {
        registerModel(item, 0, null, null, folderModel);
    }

    @SideOnly(Side.CLIENT)
    public static void registerModel(Item item, int metadata, String name, String resourceName, String folderModel) {
        if (metadata < 0) metadata = 0;
        if (resourceName == null) resourceName = item.getUnlocalizedName().substring(5).replace(".", ":");
        if (name != null) resourceName += "_" + name;
        if (folderModel != null)
            resourceName = resourceName.split(":")[0] + ":" + folderModel + "/" + resourceName.split(":")[1];

        ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(resourceName, "inventory"));
    }
}
