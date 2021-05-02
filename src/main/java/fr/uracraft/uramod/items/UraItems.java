package fr.uracraft.uramod.items;

import fr.uracraft.uramod.UraMod;
import fr.uracraft.uramod.blocks.NeodymiumOre;
import fr.uracraft.uramod.blocks.UraBlocks;
import fr.uracraft.uramod.blocks.utils.SimpleOre;
import fr.uracraft.uramod.items.utils.SimpleItem;
import fr.uracraft.uramod.items.utils.SimpleItemBlock;
import net.minecraft.block.Block;
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

    public final static Item URA_ORE_ITEM = new SimpleItemBlock(UraBlocks.URA_ORE);
    public final static Item SILVER_ORE_ITEM = new SimpleItemBlock(UraBlocks.SILVER_ORE);
    public final static Item TIN_ORE_ITEM = new SimpleItemBlock(UraBlocks.TIN_ORE);
    public final static Item COPPER_ORE_ITEM = new SimpleItemBlock(UraBlocks.COPPER_ORE);
    public final static Item NEODYMIUM_ORE_ITEM = new SimpleItemBlock(UraBlocks.NEODYMIUM_ORE);

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerItemModels(ModelRegistryEvent event) {
        registerModel(URA_INGOT);
        registerModel(NEODYMIUM);
        registerModel(COPPER_INGOT);
        registerModel(TIN_INGOT);
        registerModel(SILVER_INGOT);

        registerModel(URA_ORE_ITEM);
        registerModel(SILVER_ORE_ITEM);
        registerModel(TIN_ORE_ITEM);
        registerModel(COPPER_ORE_ITEM);
        registerModel(NEODYMIUM_ORE_ITEM);
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
