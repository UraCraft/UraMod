package fr.uracraft.uramod.events;

import fr.uracraft.uramod.UraMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;

import static java.lang.String.valueOf;

import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.uraMinY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.uraMaxY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.neodymiumMinY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.neodymiumMaxY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.silverMinY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.silverMaxY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.copperMinY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.copperMaxY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.tinMinY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.tinMaxY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.randomMinY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.randomMaxY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.ironMinY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.ironMaxY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.diamondMinY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.diamondMaxY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.coalMinY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.coalMaxY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.emeraldMinY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.emeraldMaxY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.goldMinY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.goldMaxY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.redstoneMinY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.redstoneMaxY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.lapisMinY;
import static fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration.lapisMaxY;

public class DebugLayout {

    private static String ores[][] = new String[][]{
            {"tile.oreIron.name", valueOf(ironMinY), valueOf(ironMaxY), "0xbc9980"},
            {"tile.oreCoal.name", valueOf(coalMinY), valueOf(coalMaxY), "0x454545"},
            {"tile.oreEmerald.name", valueOf(emeraldMinY), valueOf(emeraldMaxY), "0x17dd62"},
            {"tile.oreGold.name", valueOf(goldMinY), valueOf(goldMaxY), "0xf8af2b"},
            {"tile.uramod.silver_ore.name", valueOf(silverMinY), valueOf(silverMaxY), "0xd3d3d3"},
            {"tile.uramod.copper_ore.name", valueOf(copperMinY), valueOf(copperMaxY), "0xe3826c"},
            {"tile.uramod.tin_ore.name", valueOf(tinMinY), valueOf(tinMaxY),"0x7992ab"},
            {"tile.uramod.random_ore.name", valueOf(randomMinY), valueOf(randomMaxY), "0x7f7f7f"},
            {"tile.oreRedstone.name", valueOf(redstoneMinY), valueOf(redstoneMaxY), "0xb80505"},
            {"tile.oreLapis.name", valueOf(lapisMinY), valueOf(lapisMaxY), "0x2463b1"},
            {"tile.oreDiamond.name", valueOf(diamondMinY), valueOf(diamondMaxY),"0x5decf5"},
            {"tile.uramod.ura_ore.name", valueOf(uraMinY), valueOf(uraMaxY), "0xb55699"},
            {"tile.uramod.neodymium_ore.name", valueOf(neodymiumMinY), valueOf(neodymiumMaxY), "0xdda117"}};






    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onPreRender(RenderGameOverlayEvent.Pre event) {
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
                this.drawString(minecraft.fontRenderer, I18n.format(ores[i][0]), 10, draw_y, Color.decode(ores[i][3]).hashCode());
                draw_y = draw_y + 10;
            }
        }
    }
}