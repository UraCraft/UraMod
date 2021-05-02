package fr.uracraft.uramod;

import fr.uracraft.uramod.items.UraItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class UraFurnaceRecipes {
    public static void registerFurnaceRecipes(FMLInitializationEvent event) {
        GameRegistry.addSmelting(UraItems.URA_ORE_ITEM, new ItemStack(UraItems.URA_INGOT, 1), 1.4F);
        GameRegistry.addSmelting(UraItems.COPPER_ORE_ITEM, new ItemStack(UraItems.COPPER_INGOT, 1), 0.7F);
        GameRegistry.addSmelting(UraItems.TIN_ORE_ITEM, new ItemStack(UraItems.TIN_INGOT, 1), 1.0F);
        GameRegistry.addSmelting(UraItems.NEODYMIUM_ORE_ITEM, new ItemStack(UraItems.NEODYMIUM, 1), 1.0F);
        GameRegistry.addSmelting(UraItems.SILVER_ORE_ITEM, new ItemStack(UraItems.SILVER_INGOT, 1), 1.0F);


    }

}