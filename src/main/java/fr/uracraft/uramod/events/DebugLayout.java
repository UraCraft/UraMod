package fr.uracraft.uramod.events;

import fr.uracraft.uramod.UraMod;
import fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DebugLayout {

    private static String ores[][] = new String[][]{
            {"tile.uramod.ura_ore.name", String.valueOf(UraWorldGeneratorConfiguration.uraMinY), String.valueOf(UraWorldGeneratorConfiguration.uraMaxY), "12211667"},
            {"tile.uramod.neodymium_ore.name", String.valueOf(UraWorldGeneratorConfiguration.neodymiumMinY), String.valueOf(UraWorldGeneratorConfiguration.neodymiumMaxY), "16760358"},
            {"tile.uramod.silver_ore.name", String.valueOf(UraWorldGeneratorConfiguration.silverMinY), String.valueOf(UraWorldGeneratorConfiguration.silverMaxY), "12566463"},
            {"tile.uramod.copper_ore.name", String.valueOf(UraWorldGeneratorConfiguration.copperMinY), String.valueOf(UraWorldGeneratorConfiguration.copperMaxY), "12565546"},
            {"tile.uramod.tin_ore.name", String.valueOf(UraWorldGeneratorConfiguration.tinMinY), String.valueOf(UraWorldGeneratorConfiguration.tinMaxY), "12565546"},
            {"tile.uramod.random_ore.name", String.valueOf(UraWorldGeneratorConfiguration.randomMinY), String.valueOf(UraWorldGeneratorConfiguration.randomMaxY), "12565546"},
            {"tile.oreIron.name", String.valueOf(UraWorldGeneratorConfiguration.ironMinY), String.valueOf(UraWorldGeneratorConfiguration.ironMaxY), "14200723"},
            {"tile.oreDiamond.name", String.valueOf(UraWorldGeneratorConfiguration.diamondMinY), String.valueOf(UraWorldGeneratorConfiguration.diamondMaxY), "965309"},
            {"tile.oreCoal.name", String.valueOf(UraWorldGeneratorConfiguration.coalMinY), String.valueOf(UraWorldGeneratorConfiguration.coalMaxY), "1381653"},
            {"tile.oreEmerald.name", String.valueOf(UraWorldGeneratorConfiguration.emeraldMinY), String.valueOf(UraWorldGeneratorConfiguration.emeraldMaxY), "9096077"},
            {"tile.oreGold.name", String.valueOf(UraWorldGeneratorConfiguration.goldMinY), String.valueOf(UraWorldGeneratorConfiguration.goldMaxY), "16755200"},
            {"tile.oreRedstone.name", String.valueOf(UraWorldGeneratorConfiguration.redstoneMinY), String.valueOf(UraWorldGeneratorConfiguration.redstoneMaxY), "15081480"},
            {"tile.oreLapis.name", String.valueOf(UraWorldGeneratorConfiguration.lapisMinY), String.valueOf(UraWorldGeneratorConfiguration.lapisMaxY), "1594813"}};

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onPreRender(RenderGameOverlayEvent.Pre event)
    {
        if (event.getType() == RenderGameOverlayEvent.ElementType.DEBUG) {
            Minecraft minecraft = Minecraft.getMinecraft();
            event.setCanceled(true);

            this.drawString(minecraft.fontRenderer, "UraCraft V" + UraMod.VERSION, 10, 10, 12211667);
            String fps = Minecraft.getDebugFPS() + " fps";
            int f = Integer.parseInt(fps.substring(0, fps.length() - 4));
            int s = f * 10 / minecraft.gameSettings.limitFramerate;
            this.drawString(Minecraft.getMinecraft().fontRenderer, fps, 10, 30, fpscolor(s));
            String direction = "";
            double rot = (minecraft.player.rotationYaw - 90) % 360;
            if (rot < 0) {
                rot += 360.0;
            }
            if (0 <= rot && rot < 67.5) {
                direction = "North";
            } else if (67.5 <= rot && rot < 157.5) {
                direction = "East";
            } else if (157.5 <= rot && rot < 247.5) {
                direction = "South";
            } else if (247.5 <= rot && rot < 360.0) {
                direction = "West";
            }
            int x = (int) minecraft.player.posX;
            int y = (int) minecraft.player.posY;
            int z = (int) minecraft.player.posZ;
            this.drawString(minecraft.fontRenderer, "Biome: " + minecraft.world.getBiome(new BlockPos(x, y, z)).getBiomeName(), 10, 70, 16777215);
            this.drawString(minecraft.fontRenderer, "Direction: " + direction, 10, 60, 16777215);

            String coords = "XYZ : " + x + " / " + y + " / " + z;
            this.drawString(minecraft.fontRenderer, coords, 10, 50, 16777215);
            if ((int) minecraft.player.posY < 60) {
                this.drawString(minecraft.fontRenderer, I18n.format("debug.oreSpawnText"), 10, 100, 16777215);
                drawOresSpawn(minecraft);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    private void drawString(FontRenderer fontRenderer, String s, int x, int y, int color) {
        fontRenderer.drawStringWithShadow(s, x, y, color);
    }

    private int fpscolor(int fps) {
        switch (fps) {
            case 1:
                return 7274496;
            case 2:
                return 7274496;
            case 3:
                return 10158080;
            case 4:
                return 10158080;
            case 5:
                return 16711680;
            case 6:
                return 16728320;
            case 7:
                return 16745472;
            case 8:
                return 16776960;
            case 9:
                return 6422272;
            case 10:
                return 6422272;
        }
        return 0;
    }

    private void drawOresSpawn(Minecraft minecraft) {
        int y = (int) minecraft.player.posY;
        int draw_y = 120;
        for (int i = 0; i < ores.length; i++) {
            if (Integer.parseInt(ores[i][1]) < y && Integer.parseInt(ores[i][2]) > y) {
                this.drawString(minecraft.fontRenderer, I18n.format(ores[i][0]), 10, draw_y, Integer.parseInt(ores[i][3]));
                draw_y = draw_y + 10;
            }
        }
    }
}