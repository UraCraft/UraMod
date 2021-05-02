package fr.uracraft.uramod.events;

import fr.uracraft.uramod.UraMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DebugLayout {

    private static int ores[][] = new int[][]{
            {0, 14, 12211667},
            {0, 14, 16760358},
            {0, 25, 12566463},
            {0, 25, 12565546},
            {0, 54, 14200723},
            {0, 12, 965309},
            {0, 64, 1381653},
            {0, 29, 9096077},
            {0, 29, 16755200},
            {0, 12, 15081480},
            {14, 16, 1594813}};
    private static String ores_names[] = new String[]{
            "tile.uramod.ura_ore.name",
            "tile.uramod.neodymium_ore.name",
            "tile.uramod.silver_ore.name",
            "tile.uramod.random_ore.name",
            "tile.oreIron.name",
            "tile.oreDiamond.name",
            "tile.oreCoal.name",
            "tile.oreEmerald.name",
            "tile.oreGold.name",
            "tile.oreRedstone.name",
            "tile.oreLapis.name"
    };

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onPreRender(RenderGameOverlayEvent.Pre event)
    {
        if (event.getType() == RenderGameOverlayEvent.ElementType.DEBUG) {
            Minecraft minecraft = Minecraft.getMinecraft();
            event.setCanceled(true);

            this.drawString(minecraft.fontRenderer, "UraCraft V" + UraMod.VERSION, 10, 10, 12211667);
            String fps = String.valueOf(Minecraft.getDebugFPS()) + " fps";
            int f = Integer.parseInt(fps.substring(0, fps.length() - 4));
            int s = f * 10 / minecraft.gameSettings.limitFramerate;
            this.drawString(Minecraft.getMinecraft().fontRenderer, fps, 10, 30, fpscolor(s));
            int angle = MathHelper.floor((double) (Minecraft.getMinecraft().player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
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
            if ((int) minecraft.player.posY < 53 && (int) minecraft.player.posY > 5) {
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
        for (int i = 0; i < 10; i++) {
            if (ores[i][0] < y && ores[i][1] > y) {
                this.drawString(minecraft.fontRenderer, I18n.format(ores_names[i]), 10, draw_y, ores[i][2]);
                draw_y = draw_y + 10;
            }
        }
    }
}