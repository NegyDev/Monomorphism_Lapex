package Negyxd.Event.impl;

import Negyxd.Event.Event;

public class MotionEvent
        extends Event {
    public float rotyaw;
    public float rotpitch;

    public MotionEvent() {

    }

    public void setRotationYaw(float RotationYaw) {
        this.rotyaw = RotationYaw;
    }

    public void setRotationPitch(float RotationPitch) {
        this.rotpitch = RotationPitch;
    }

    public float getRotationYaw() {
        return this.rotyaw;
    }

    public float getRotationPitch() {
        return this.rotpitch;
    }
}

