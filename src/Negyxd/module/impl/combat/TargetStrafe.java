package Negyxd.module.impl.combat;

import Negyxd.Event.Event;
import Negyxd.Event.impl.MotionEvent;
import Negyxd.Gui.ClickGui.setting.SettingsManager;
import Negyxd.Mappings.Minecraft;
import Negyxd.Mappings.ThePlayer;
import Negyxd.module.Category;
import Negyxd.module.Module;
import Negyxd.module.impl.movement.Strafe;
import net.minecraft.B5;

public class TargetStrafe extends Module {
    public static boolean Attacking = false;
    private boolean goingRight;
    public TargetStrafe() {
        super("TargetStrafe", 0, Category.Combat);
        SettingsManager.manager.addDouble("Range", "TargetStrafeRange", 1, 6.0, 3.6, this);
    }

    @Override
    public void onEvent(Event event) {
        if(event instanceof MotionEvent) {
            for(B5 entity: Minecraft.getWorld().M) {
                if (entity == Minecraft.getPlayer()) continue;
                if (entity == null) continue;
                if (entity instanceof net.minecraft.OI) {
                    float distance = Minecraft.getPlayer().k(entity);
                    if (distance <= SettingsManager.manager.getSettingByName("TargetStrafeRange").getValDouble()) {
                        ThePlayer.StrafeCustomDirection(0.7f, getDirection(entity));
                        Attacking = true;
                    }else {
                        Attacking = false;
                    }
                }
            }

        }
    }
    public float getDirection(B5 Entity) {
        if(Minecraft.getPlayer().y) {
            goingRight = !goingRight;
        }
        double distance = Minecraft.getPlayer().k(Entity);

        float direction;

        if(distance > SettingsManager.manager.getSettingByName("TargetStrafeRange").getValDouble()) {
            direction = KillAura.getRotationsNeeded(Entity)[0];
        } else {
            double offset = (90 - Minecraft.getPlayer().k(Entity) * 5);

            if(!goingRight) {
                offset = -offset;
            }

            direction = (float) (KillAura.getRotationsNeeded(Entity)[0] + offset);
        }

        return (float) Math.toRadians(direction);
    }
}
