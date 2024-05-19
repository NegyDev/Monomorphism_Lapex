package Negyxd.module.impl.player;

import Negyxd.Event.Event;
import Negyxd.Event.impl.MotionEvent;
import Negyxd.Mappings.Minecraft;
import Negyxd.Mappings.ThePlayer;
import Negyxd.module.Category;
import Negyxd.module.Module;
import net.minecraft.bc;

public class Nofall extends Module {
    public Nofall() {
        super("NoFall", 0, Category.Player);
    }

    @Override
    public void onEvent(Event event) {
        if(event instanceof MotionEvent){
            if(Minecraft.getPlayer().t >1){
                ThePlayer.sendPacket(new bc(true));
            }
        }
    }
}
