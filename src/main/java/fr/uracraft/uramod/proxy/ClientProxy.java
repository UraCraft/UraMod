package fr.uracraft.uramod.proxy;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class ClientProxy extends CommonProxy
{
     public static KeyBinding keyIridiumArmorConfig;

     public ClientProxy()
     {
          keyIridiumArmorConfig = new KeyBinding("uramod.keyIridiumArmorConfig", Keyboard.KEY_I, "key.categories.inventory");
          ClientRegistry.registerKeyBinding(keyIridiumArmorConfig);
     }

     @Override
     public void registerRender() {
         
     }
}
