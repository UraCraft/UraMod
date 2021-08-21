package fr.uracraft.uramod;

import fr.uracraft.uramod.guis.GuiHandler;
import fr.uracraft.uramod.items.armors.PatchVanillaArmors;
import fr.uracraft.uramod.proxy.CommonProxy;
import fr.uracraft.uramod.tileentity.TileEntityInventoryRenderHelper;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

@Mod(modid = UraMod.MODID, name = UraMod.NAME, version = UraMod.VERSION)
public class UraMod {

    public static final String MODID = "uramod";
    public static final String NAME = "UraMod";
    public static final String VERSION = "5.0";

    private static Logger logger;

    @Mod.Instance(UraMod.MODID)
    public static UraMod instance;

    @SidedProxy(clientSide = "fr.uracraft.uramod.proxy.ClientProxy", serverSide = "fr.uracraft.uramod.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static final String ip = "localhost";
    public static final int port = 25565;
    public final boolean singleplayer = true;

    public UraMod() {
        MinecraftForge.EVENT_BUS.register(new RegisteringHandler());
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        PatchVanillaArmors.armors(event);
        logger = event.getModLog();
        GameRegistry.registerWorldGenerator(new UraWorldGenerator(), 0);
        if (event.getSide().isClient()) {
            NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        }
        RegisteringHandler.registerEvents(event.getSide());
        RegisteringHandler.registerTileEntities();
        RegisteringHandler.registerRenders();
        TileEntityItemStackRenderer.instance = new TileEntityInventoryRenderHelper();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.registerRender();
        RegisteringHandler.registerEntities();
        UraFurnaceRecipes.registerFurnaceRecipes(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
