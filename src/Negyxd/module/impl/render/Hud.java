package Negyxd.module.impl.render;

import Negyxd.Mappings.FontRenderer;
import Negyxd.Mappings.GlStateManager;
import Negyxd.Mappings.Minecraft;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class Hud {
    static FontRenderer fontRenderer = Minecraft.fontRendererobj;

    public static void HudDraw() {
        GL11.glPushMatrix();
        GL11.glScalef(1.5f, 1.5f, 1.0f);
        Hud.drawRainbowString("Hotline", 5, 5, 2L);
        fontRenderer.drawString("lite", Minecraft.getMinecraft().C.z("Hotline") + 5, 2, -1);
        GL11.glPopMatrix();
    }

    public static void drawRainbowString(String text, int x, int y, long time) {
        float hue = (float) (System.nanoTime() - time) / 1.0E10f % 1.0f;
        int rainbowColor = Color.HSBtoRGB(hue, 1.0f, 1.0f);
        fontRenderer.drawString(text, x, y, rainbowColor);
    }

    public static void drawRainbowStringWithShadow(String text, int x, int y, long time) {
        float hue = (float) (System.nanoTime() - time) / 1.0E10f % 1.0f;
        int rainbowColor = Color.HSBtoRGB(hue, 1.0f, 1.0f);
        fontRenderer.drawStringWithShadow(text, x, y, rainbowColor);
    }
}
