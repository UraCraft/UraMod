package fr.uracraft.uramod;

import fr.uracraft.uramod.items.UraItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class UraFurnaceRecipes {
    public static void registerFurnaceRecipes(FMLInitializationEvent event) {
        GameRegistry.addSmelting(UraItems.URA_ORE_ITEM, new ItemStack(UraItems.URA_INGOT, 1), 1.0F);
    }

}