package Negyxd.Gui.ClickGui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import Negyxd.Mappings.Minecraft;
import net.minecraft.client.Ym;
import net.minecraft.client.Yy;
import org.lwjgl.opengl.GL11;

import Negyxd.Gui.ClickGui.elements.Element;
import Negyxd.Gui.ClickGui.elements.ModuleButton;
import Negyxd.Gui.ClickGui.elements.impl.ElementSlider;
import Negyxd.Gui.ClickGui.setting.SettingsManager;
import Negyxd.module.Category;
import Negyxd.module.Module;
import Negyxd.module.ModuleManager;

public class ClickGUI extends Ym {
	 public static ArrayList<Panel> panels;
	    public static ArrayList<Panel> rpanels;
	    private ModuleButton mb = null;
	    public SettingsManager setmgr = SettingsManager.manager;
	    
	    public ClickGUI() {
	        panels = new ArrayList();
	        double d0 = 105.0;
	        double d1 = 25.0;
	        double d2 = 10.0;
	        double d3 = 10.0;
	        Category[] categoryArray = Category.values();
	        int n = categoryArray.length;
	        int n2 = 0;
	        while (n2 < n) {
	            Category category = categoryArray[n2];
	            String s = String.valueOf(Character.toUpperCase(category.name().toLowerCase().charAt(0))) + category.name().toLowerCase().substring(1);
	            panels.add(new ClickGUI$1(this, s, d2, d3, d0, d1, true, this, category));
	            d2 += d0 + 5.0;
	            ++n2;
	        }
	        rpanels = new ArrayList();
	        for (Panel panel : panels) {
	            rpanels.add(panel);
	        }
	        Collections.reverse(rpanels);
	    }

	public void updateScreen() {
		for (Panel panel : panels) {
			for (ModuleButton modulebutton : panel.Elements) {
				for (Element element : modulebutton.menuelements) {
					element.tick();
					if (!panel.extended) {
						element.anim = 0.0f;
						element.anim2 = 0.0f;
					}
					if (modulebutton.extended) continue;
					element.anim = 0.0f;
					element.anim2 = 0.0f;
				}
			}
		}
	}
	    @Override
	    public void e(int mouseX, int mouseY, float partialTicks) {
	        for (Panel panel : panels) {
	            panel.drawScreen(mouseX, mouseY, partialTicks);
	        }
	        this.mb = null;
	        block1: for (Panel panel1 : panels) {
	            if (panel1 == null || !panel1.visible || !panel1.extended || panel1.Elements == null || panel1.Elements.size() <= 0) continue;
	            for (ModuleButton modulebutton : panel1.Elements) {
	                if (!modulebutton.listening) continue;
	                this.mb = modulebutton;
	                break block1;
	            }
	        }
	        for (Panel panel2 : panels) {
	            if (!panel2.extended || !panel2.visible || panel2.Elements == null) continue;
	            for (ModuleButton modulebutton1 : panel2.Elements) {
	                if (!modulebutton1.extended || modulebutton1.menuelements == null || modulebutton1.menuelements.isEmpty()) continue;
	                double d0 = 0.0;
	                Color color = new Color(-13350562);
	                new Color(color.getRed(), color.getGreen(), color.getBlue(), 170).getRGB();
	                for (Element element : modulebutton1.menuelements) {
	                    element.offset = d0;
	                    element.update();
	                    element.drawScreen(mouseX, mouseY, partialTicks);
	                    d0 += element.height;
	                }
	            }
	        }
	        if (this.mb != null) {
				Yy scaledResolution = new Yy(Minecraft.getMinecraft());
	            GL11.glPushMatrix();
	            Minecraft.fontRendererobj.drawString("Press any key...", (float)(scaledResolution.e() / 2), (float)(scaledResolution.l() / 2 - 10), -1, true);
	            GL11.glPopMatrix();
	        }
	        super.e(mouseX, mouseY, partialTicks);
	    }
	@Override
	protected void k(int mouseX, int mouseY, int mouseButton) throws IOException {
	        if (this.mb == null) {
	            for (Panel panel : rpanels) {
	                if (!panel.extended || !panel.visible || panel.Elements == null) continue;
	                for (ModuleButton modulebutton : panel.Elements) {
	                    if (!modulebutton.extended) continue;
	                    for (Element element : modulebutton.menuelements) {
	                        if (!element.mouseClicked(mouseX, mouseY, mouseButton)) continue;
	                        return;
	                    }
	                }
	            }
	            for (Panel panel1 : rpanels) {
	                if (!panel1.mouseClicked(mouseX, mouseY, mouseButton)) continue;
	                return;
	            }
				super.k(mouseX, mouseY, mouseButton);
	        }
	    }
	    @Override
	    protected void b(int mouseX, int mouseY, int state) {
	        if (this.mb == null) {
	            for (Panel panel : rpanels) {
	                if (!panel.extended || !panel.visible || panel.Elements == null) continue;
	                for (ModuleButton modulebutton : panel.Elements) {
	                    if (!modulebutton.extended) continue;
	                    for (Element element : modulebutton.menuelements) {
	                        element.mouseReleased(mouseX, mouseY, state);
	                    }
	                }
	            }
	            for (Panel panel1 : rpanels) {
	                panel1.mouseReleased(mouseX, mouseY, state);
	            }
	            super.b(mouseX, mouseY, state);
	        }
	    }
	    @Override
	    protected void E(char typedChar, int keyCode) {
	        for (Panel panel : rpanels) {
	            if (panel == null || !panel.visible || !panel.extended || panel.Elements == null || panel.Elements.size() <= 0) continue;
	            for (ModuleButton modulebutton : panel.Elements) {
	                try {
	                    if (!modulebutton.keyTyped(typedChar, keyCode)) continue;
	                    return;
	                } catch (IOException ioexception1) {
	                    ioexception1.printStackTrace();
	                }
	            }
	        }
	        try {
	            super.E(typedChar, keyCode);
	        } catch (IOException ioexception) {
	            ioexception.printStackTrace();
	        }
	    }
	    
	    class ClickGUI$1
	    extends Panel {
	        final ClickGUI this$0;
	        private final Category val$category;

	        ClickGUI$1(ClickGUI clickGUI, String $anonymous0, double $anonymous1, double $anonymous2, double $anonymous3, double $anonymous4, boolean $anonymous5, ClickGUI $anonymous6, Category category) {
	            super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4, $anonymous5, $anonymous6);
	            this.this$0 = clickGUI;
	            this.val$category = category;
	            this.setup();
	        }

	        @Override
	        public void setup() {
	            for (Module function : ModuleManager.INSTANCE.getModules()) {
	                if (!function.category.equals((Object)this.val$category)) continue;
	                this.Elements.add(new ModuleButton(function, this));
	            }
	        }
	    }

}
