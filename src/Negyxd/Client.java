package Negyxd;

import Negyxd.Fonts.Font;
import Negyxd.Mappings.Minecraft;
import Negyxd.Utils.FontUtil;
import Negyxd.module.ModuleManager;

public class Client {
	public static int i = 0; //Eğlenceliydi :D

	public static void IngameGuiSetter(net.minecraft.client.YI gui) {
		Minecraft.getMinecraft().h0 = gui;
	}


	public static void Start() {
		if(i<=0) {
			i++;
			Font.Init();
			ModuleManager.INSTANCE.initialize();
			IngameGuiSetter(new GuiIngameHook(Minecraft.getMinecraft().h0));
		}else {

		}
	}
	public static void main(String[] args) {

	}

}
