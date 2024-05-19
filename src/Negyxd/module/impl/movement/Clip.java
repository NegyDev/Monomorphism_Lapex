package Negyxd.module.impl.movement;

import Negyxd.Gui.ClickGui.setting.SettingsManager;
import Negyxd.Mappings.Minecraft;
import Negyxd.Mappings.ThePlayer;
import Negyxd.module.Category;
import Negyxd.module.Module;

public class Clip extends Module {
    public Clip() {
        super("Clip", 0, Category.Movement);
        SettingsManager.manager.addInt("H-Clip Amount", "HClipValue", 1, 8, 3, this);
        SettingsManager.manager.addInt("V-Clip Amount", "VClipValue", 1, 8, 3, this);
    }
    public static double getPosForSetPosX(double val, float RotationYaw) {
        float yaw = RotationYaw * ((float)Math.PI / 180);
        double x = -Math.sin(yaw) * val;
        return x;
    }

    public static double getPosForSetPosZ(double val, float RotationYaw) {
        float yaw = RotationYaw * ((float)Math.PI / 180);
        double z = Math.cos(yaw) * val;
        return z;
    }

    @Override
    public void onEnable() {
        double newposX = Minecraft.getMinecraft().Y.Fy + Clip.getPosForSetPosX(SettingsManager.manager.getSettingByName("HClipValue").getValInt(), ThePlayer.getRotationYaw());
        double newposz = Minecraft.getMinecraft().Y.F4 + Clip.getPosForSetPosZ(SettingsManager.manager.getSettingByName("HClipValue").getValInt(), ThePlayer.getRotationYaw());
        double newposY = Minecraft.getMinecraft().Y.L+ SettingsManager.manager.getSettingByName("VClipValue").getValInt();
        Minecraft.getMinecraft().Y.J(newposX,newposY,newposz);
        this.setModuleState(false);
    }
}
