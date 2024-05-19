package Negyxd.Event;

import Negyxd.module.Module;

public class EventListener {
	public static void ListenEvent(Event e) {
        Module.onEventAdd(e);
    }
}
