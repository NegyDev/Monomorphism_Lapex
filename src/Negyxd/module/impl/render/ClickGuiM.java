package Negyxd.module.impl.render;

import Negyxd.Mappings.Minecraft;
import org.lwjgl.input.Keyboard;

import Negyxd.Gui.ClickGui.ClickGUI;
import Negyxd.Gui.ClickGui.setting.SettingsManager;
import Negyxd.module.Category;
import Negyxd.module.Module;

public class ClickGuiM extends Module{
	public ClickGuiM() {
		super("ClickGui", Keyboard.KEY_RSHIFT, Category.Visual);
	}
	@Override
	public void onEnable() {
		Minecraft.DisplayGuiScreen(new ClickGUI());
		this.setModuleState(false);
	}

}
