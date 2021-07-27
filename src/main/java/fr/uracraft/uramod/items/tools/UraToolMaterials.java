package fr.uracraft.uramod.items.tools;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class UraToolMaterials {
    public static final Item.ToolMaterial URA_TOOL_MATERIAL = EnumHelper.addToolMaterial("ura_tools", 5, 1800, 14.0F, 5.0F, 18);
    public static final Item.ToolMaterial IRIDIUM_TOOL_MATERIAL = EnumHelper.addToolMaterial("iridium_tools", 6, 2500, 17.0F, 7.0F, 15);
    public static final Item.ToolMaterial SILVER_TOOL_MATERIAL = EnumHelper.addToolMaterial("silver_tools", 4, 1500, 13.0F, 4.0F, 16);
}