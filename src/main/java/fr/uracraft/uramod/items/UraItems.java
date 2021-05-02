package fr.uracraft.uramod.items;

import fr.uracraft.uramod.UraMod;
import fr.uracraft.uramod.items.utils.SimpleItem;
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

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerItemModels(ModelRegistryEvent event) {
        registerModel(URA_INGOT);
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
