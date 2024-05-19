package Negyxd.module.impl.movement;

import Negyxd.Event.Event;
import Negyxd.Event.impl.MotionEvent;
import Negyxd.Mappings.ThePlayer;
import Negyxd.module.Category;
import Negyxd.module.Module;

public class Strafe extends Module {
    private boolean zipladikxd = false;

    public Strafe() {
        super("Strafe", 0, Category.Movement);
    }

    @Override
    public void onEvent(Event event) {
        if (event instanceof MotionEvent) {
            MotionEvent motionEvent = (MotionEvent) event;
            if (ThePlayer.isMoving() && ThePlayer.onGround()) {
                ThePlayer.jump();
                zipladikxd = true;
            }

            ThePlayer.Strafe(0.6f);
        }
    }
}
