package Negyxd.module.impl.movement;

import Negyxd.Event.Event;
import Negyxd.Event.impl.MotionEvent;
import Negyxd.Mappings.Minecraft;
import Negyxd.module.Category;
import Negyxd.module.Module;

public class Step extends Module {
    public Step() {
        super("Step", 0, Category.Movement);
    }

    @Override
    public void onEvent(Event event) {
        if(event instanceof MotionEvent){
            Minecraft.getPlayer().FZ = 13.0f;
        }
    }

    @Override
    public void onDisable() {
        Minecraft.getPlayer().FZ = 0.6f;
    }
}
