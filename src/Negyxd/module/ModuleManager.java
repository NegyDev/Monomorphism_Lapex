package Negyxd.module;

import java.util.ArrayList;
import java.util.List;

import Negyxd.module.impl.combat.KillAura;
import Negyxd.module.impl.combat.NoKnockback;
import Negyxd.module.impl.combat.TPAura;
import Negyxd.module.impl.combat.TargetStrafe;
import Negyxd.module.impl.movement.*;
import Negyxd.module.impl.player.Nofall;
import Negyxd.module.impl.render.ClickGuiM;

public enum ModuleManager {
	 INSTANCE;
	 public static List<Module> modules = new ArrayList<Module>();
	 
	 public void initialize() {
		 modules.add(new ClickGuiM());
		 modules.add(new KillAura());
		 modules.add(new Clip());
		 modules.add(new NoKnockback());
		 modules.add(new TargetStrafe());
		 modules.add(new Nofall());
		 modules.add(new Strafe());
		 modules.add(new LongJump());
		 modules.add(new Step());
		 modules.add(new TPAura());
		 modules.add(new Speed());
	 }
	 public Module getModule(Class<?> clazz) {
	        if (clazz != null) {
	            for (Module mod : this.getModules()) {
	                if (mod.getClass() != clazz) continue;
	                return mod;
	            }
	        }
	        return null;
	    }

	    public boolean isToggled(Class<?> clazz) {
	        if (clazz != null) {
	            for (Module mod : this.getModules()) {
	                if (mod.getClass() != clazz || !mod.isEnabled()) continue;
	                return true;
	            }
	        }
	        return false;
	    }

	    public List<Module> getModules() {
	        return this.modules;
	    }

}
