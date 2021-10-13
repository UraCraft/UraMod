package fr.uracraft.uramod.proxy;

import fr.uracraft.uramod.rendering.chests.*;
import fr.uracraft.uramod.tileentity.TileEntityInventoryRenderHelper;
import fr.uracraft.uramod.tileentity.chests.*;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
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
          ClientRegistry.bindTileEntitySpecialRenderer(TileEntityUraChest.class, new RenderUraChest());
          ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDiamondChest.class, new RenderDiamondChest());
          ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySilverChest.class, new RenderSilverChest());
          ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGoldChest.class, new RenderGoldChest());
          ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIronChest.class, new RenderIronChest());
          ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStoneChest.class, new RenderStoneChest());
          TileEntityItemStackRenderer.instance = new TileEntityInventoryRenderHelper();
     }
}
