package Negyxd.module.impl.render;

import Negyxd.Mappings.FontRenderer;
import Negyxd.Mappings.Minecraft;
import Negyxd.Utils.FontUtil;
import Negyxd.Utils.MinecraftFontRenderer;
import Negyxd.module.Module;
import Negyxd.module.ModuleManager;
import net.minecraft.client.Yy;

import java.awt.*;
import java.lang.reflect.Field;

public class Arraylist {
    public static void renderArrayList() {
        Yy sr = new Yy(Minecraft.getMinecraft());
        MinecraftFontRenderer fontRenderer = FontUtil.font10;

        int yOffset = 4;
        int moduleCount = 0;

        for (Module module: ModuleManager.modules) {
            if (module.moduleState) {
                int color = rainbow(600, 20, moduleCount);
                fontRenderer.drawString(module.moduleName, getScaledWidth(sr) - fontRenderer.getStringWidth(module.moduleName) - 4, yOffset, color);
                yOffset += fontRenderer.getHeight() +3;
                moduleCount++;
            }
        }
    }

    public static int rainbow(int delay, int offset, int index) {
        double rainbowDelay = Math.ceil(System.currentTimeMillis() + (long)((long) delay * index)) / offset;
        return Color.getHSBColor((float)(rainbowDelay % 360.0 / 360.0), 0.5F, 1.0F).getRGB();
    }

    public static int getScaledWidth(Object resulation){
        try{
            Field field = Yy.class.getDeclaredField("v");
            field.setAccessible(true);
            return (int) field.get(resulation);
        }catch (Exception e){
            e.printStackTrace();
            return (int)0;
        }
    }
}
