package Negyxd.module.impl.combat;

import Negyxd.Event.Event;
import Negyxd.Event.impl.PacketReceiveEvent;
import Negyxd.module.Category;
import Negyxd.module.Module;
import net.minecraft._a;

public class NoKnockback extends Module {
    public NoKnockback() {
        super("NoKnockback", 0, Category.Combat);
    }
    @Override
    public void onEvent(Event event) {
        if (event instanceof PacketReceiveEvent) {
            PacketReceiveEvent e = (PacketReceiveEvent)event;
            if(e.getPacket() instanceof _a){
                e.setCancelled(true);
            }
        }
    }
}
