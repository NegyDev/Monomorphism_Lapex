package Negyxd.module.impl.movement;

import Negyxd.Event.Event;
import Negyxd.Event.impl.MotionEvent;
import Negyxd.Mappings.ThePlayer;
import Negyxd.module.Category;
import Negyxd.module.Module;

public class LongJump extends Module {
    public LongJump() {
        super("LongJump", 0, Category.Movement);
    }

    @Override
    public void onEvent(Event event) {
        if(event instanceof MotionEvent){
            if(ThePlayer.onGround() == false){
                ThePlayer.Strafe(1.2f);
            }
        }
    }
}
