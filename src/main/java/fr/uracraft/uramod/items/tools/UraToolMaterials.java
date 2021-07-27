package fr.uracraft.uramod.items.tools;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class UraToolMaterials {
    public static final Item.ToolMaterial URA_TOOL_MATERIAL = EnumHelper.addToolMaterial("ura_tools", 4, 1800, 10.0F, 5.0F, 10);
    public static final Item.ToolMaterial IRIDIUM_TOOL_MATERIAL = EnumHelper.addToolMaterial("iridium_tools", 5, 2500, 17.0F, 7.0F, 27);
    public static final Item.ToolMaterial SILVER_TOOL_MATERIAL = EnumHelper.addToolMaterial("silver_tools", 0, 64, 12.0F, 0.0F, 22);
    public static final Item.ToolMaterial HAMMER_TOOL_MATERIAL = EnumHelper.addToolMaterial("hammer", 4, 1800, 4.0F, 5.0F, 10);
}