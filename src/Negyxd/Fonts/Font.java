package Negyxd.Fonts;

import Negyxd.Utils.FontUtil;
import Negyxd.Utils.MinecraftFontRenderer;

import java.util.HashMap;
import java.util.Map;

public class Font {

    public static void Init(){
        Map<String, java.awt.Font> locationMap = new HashMap<>();
        FontUtil.font10 = new MinecraftFontRenderer(FontUtil.getFont(locationMap, "arial.ttf", 20), true, true);
    }
}
