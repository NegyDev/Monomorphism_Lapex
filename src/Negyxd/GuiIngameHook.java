package Negyxd;

import Negyxd.Event.EventListener;
import Negyxd.Event.impl.Render2DEvent;
import Negyxd.Mappings.Minecraft;
import Negyxd.module.impl.render.Arraylist;
import Negyxd.module.impl.render.Hud;

public class GuiIngameHook extends net.minecraft.client.YI{

	public GuiIngameHook(net.minecraft.client.YI originalGui) {
		super(Minecraft.getMinecraft());
	}

	@Override
	public void u(float v) {
		super.u(v);
		EventListener.ListenEvent(new Render2DEvent());
		Hud.HudDraw();
		Arraylist.renderArrayList();
		
	}

}
