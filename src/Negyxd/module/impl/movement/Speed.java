package Negyxd.module.impl.movement;

import Negyxd.Event.Event;
import Negyxd.Event.impl.MotionEvent;
import Negyxd.Gui.ClickGui.setting.SettingsManager;
import Negyxd.Mappings.ThePlayer;
import Negyxd.module.Category;
import Negyxd.module.Module;
import Negyxd.module.impl.combat.TargetStrafe;
import org.lwjgl.input.Keyboard;

import static Negyxd.Mappings.ThePlayer.Strafe;

public class Speed extends Module {
    public Speed() {
        super("Speed", Keyboard.KEY_X, Category.Movement);
        SettingsManager.manager.addDouble("Value", "SpeedValue", 0.1, 1.0, 0.2, this);
    }

    @Override
    public void onEvent(Event event) {
        if(event instanceof MotionEvent){
            if(ThePlayer.onGround()){
                if(!TargetStrafe.Attacking){
                    ThePlayer.Strafe(SettingsManager.manager.getSettingByName("SpeedValue").getValFloat());
                }

            }

        }
    }
}
