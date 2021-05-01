package fr.uracraft.uramod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = UraMod.MODID, name = UraMod.NAME, version = UraMod.VERSION)
public class UraMod {

        public static final String MODID = "uramod";
        public static final String NAME = "UraMod";
        public static final String VERSION = "0.1";

        private static Logger logger;

        @Mod.EventHandler
        public void preInit(FMLPreInitializationEvent event)
        {
            logger = event.getModLog();
        }

        @Mod.EventHandler
        public void init(FMLInitializationEvent event)
        {

        }

        @Mod.EventHandler
        public void postInit(FMLPostInitializationEvent event)
        {

        }
}
