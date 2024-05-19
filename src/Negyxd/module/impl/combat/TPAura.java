package Negyxd.module.impl.combat;

import Negyxd.Event.Event;
import Negyxd.Event.impl.MotionEvent;
import Negyxd.Gui.ClickGui.setting.SettingsManager;
import Negyxd.Mappings.Minecraft;
import Negyxd.module.Category;
import Negyxd.module.Module;
import Negyxd.module.ModuleManager;
import net.minecraft.B5;

import java.util.Random;

public class TPAura extends Module {
    public TPAura() {
        super("TPAura", 0, Category.Combat);
    }
    @Override
    public void onEvent(Event event) {
        if (event instanceof MotionEvent) {
            B5 closestEntity = findClosestEntity();
            if (closestEntity != null && Minecraft.getPlayer().k(closestEntity) <= 30) {
                TeleportAndHit(closestEntity);
            }
        }
    }

    public B5 findClosestEntity() {
        B5 closestEntity = null;
        double closestDistance = Double.MAX_VALUE;

        for (B5 entity : Minecraft.getWorld().M) {
            if (entity == Minecraft.getPlayer() || entity == null || !(entity instanceof net.minecraft.OI)) {
                continue;
            }

            float distance = Minecraft.getPlayer().k(entity);
            if (distance < closestDistance) {
                closestDistance = distance;
                closestEntity = entity;
            }
        }

        return closestEntity;
    }
    public static double getRandomDoubleBetweenRange(double min, double max){
        double randomValue = min + (max - min) * new Random().nextDouble();
        return randomValue;
    }

    public void TeleportAndHit(B5 player) {
        if(player==null)return;
        double TargetX = player.Fy;
        double TargetY = player.L;
        double TargetZ = player.F4;
        Minecraft.getMinecraft().Y.J(TargetX+getRandomDoubleBetweenRange(0,1.5),TargetY,TargetZ+getRandomDoubleBetweenRange(0,1.5));
        Module m = ModuleManager.INSTANCE.getModule(KillAura.class);
        KillAura k = (KillAura) m;
        k.Attack(player);
    }
}
