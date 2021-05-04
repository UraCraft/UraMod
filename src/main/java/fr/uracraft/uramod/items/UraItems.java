package fr.uracraft.uramod.items;

import fr.uracraft.uramod.UraMod;
import fr.uracraft.uramod.blocks.UraBlocks;
import fr.uracraft.uramod.items.utils.SimpleItem;
import fr.uracraft.uramod.items.utils.SimpleItemBlock;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static fr.uracraft.uramod.UraCreativeTabs.URAMOD;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid= UraMod.MODID)
public class UraItems {

    public final static Item URA_INGOT = new SimpleItem("ura_ingot",URAMOD);
    public final static Item NEODYMIUM = new SimpleItem("neodymium",URAMOD);
    public final static Item COPPER_INGOT = new SimpleItem("copper_ingot",URAMOD);
    public final static Item TIN_INGOT = new SimpleItem("tin_ingot",URAMOD);
    public final static Item SILVER_INGOT = new SimpleItem("silver_ingot",URAMOD);

    public final static Item URA_NUGGET = new SimpleItem("ura_nugget",URAMOD);

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

    public final static Item URA_ORE_ITEM = new SimpleItemBlock(UraBlocks.URA_ORE);
    public final static Item SILVER_ORE_ITEM = new SimpleItemBlock(UraBlocks.SILVER_ORE);
    public final static Item TIN_ORE_ITEM = new SimpleItemBlock(UraBlocks.TIN_ORE);
    public final static Item COPPER_ORE_ITEM = new SimpleItemBlock(UraBlocks.COPPER_ORE);
    public final static Item NEODYMIUM_ORE_ITEM = new SimpleItemBlock(UraBlocks.NEODYMIUM_ORE);

    public final static Item URA_BLOCK_ITEM = new SimpleItemBlock(UraBlocks.URA_BLOCK);

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerItemModels(ModelRegistryEvent event) {
        registerModel(URA_INGOT);
        registerModel(NEODYMIUM);
        registerModel(COPPER_INGOT);
        registerModel(TIN_INGOT);
        registerModel(SILVER_INGOT);

        registerModel(URA_NUGGET);

        registerModel(URA_ORE_ITEM);
        registerModel(SILVER_ORE_ITEM);
        registerModel(TIN_ORE_ITEM);
        registerModel(COPPER_ORE_ITEM);
        registerModel(NEODYMIUM_ORE_ITEM);
        registerModel(URA_BLOCK_ITEM);

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
