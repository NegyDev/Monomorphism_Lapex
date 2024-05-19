package Negyxd.Gui.ClickGui.elements;

import java.io.IOException;
import java.util.ArrayList;

import Negyxd.Mappings.Minecraft;
import org.lwjgl.opengl.GL11;

import Negyxd.Gui.ClickGui.Panel;
import Negyxd.Gui.ClickGui.elements.impl.ElementCheckBox;
import Negyxd.Gui.ClickGui.elements.impl.ElementComboBox;
import Negyxd.Gui.ClickGui.elements.impl.ElementSlider;
import Negyxd.Gui.ClickGui.setting.Setting;
import Negyxd.Gui.ClickGui.setting.SettingsManager;
import Negyxd.Utils.RenderUtil;
import Negyxd.module.Module;

public class ModuleButton {
	 public Module func;
	    public ArrayList<Element> menuelements;
	    public Panel parent;
	    public double x;
	    public double y;
	    public double width;
	    public double height;
	    public boolean extended = false;
	    public boolean listening = false;

	    public ModuleButton(Module ifunc, Panel pl) {
	        this.func = ifunc;
	        this.height = 18.0;
	        this.parent = pl;
	        this.menuelements = new ArrayList();
	        if (SettingsManager.manager.getSettingsByMod(ifunc) != null) {
	            for (Setting setting : SettingsManager.manager.getSettingsByMod(ifunc)) {
	                if (setting.isCheck()) {
	                    this.menuelements.add(new ElementCheckBox(this, setting));
	                    continue;
	                }
	                if (setting.isSlider()) {
	                    this.menuelements.add(new ElementSlider(this, setting));
	                    continue;
	                }
	                if (!setting.isCombo()) continue;
	                this.menuelements.add(new ElementComboBox(this, setting));
	            }
	        }
	    }

	    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
	        if (this.isHovered(mouseX, mouseY)) {
	            RenderUtil.drawRect(this.x - 2.0, this.y, this.x + this.width + 2.0, this.y + this.height + 1.0, 572466736);
	        }
	        Minecraft.fontRendererobj.drawString(this.func.getModuleName(), (int)(this.x + 4.0), (int)(this.y - 2.0 + this.height / 2.0), this.func.isEnabled() ? -12895429 : -6513508);
	        if (SettingsManager.manager.getSettingsByMod(this.func) != null) {
	            GL11.glPushMatrix();
	            int k = (int)(this.x + this.width - 6.0);
	            Minecraft.fontRendererobj.drawString(">", k, (int)(this.y - 2.0 + this.height / 2.0), this.func.isEnabled() ? -12895429 : -6513508);
	            GL11.glPopMatrix();
	        }
	    }

	    public boolean mouseClicked(int mouseX, int mouseY, int mouseButton) {
	        if (!this.isHovered(mouseX, mouseY)) {
	            return false;
	        }
	        if (mouseButton == 0) {
	            this.func.setModuleState(!this.func.getModuleState());
	        } else if (mouseButton == 1) {
	            if (this.menuelements != null && this.menuelements.size() > 0) {
	                boolean flag;
	                this.extended = flag = !this.extended;
	            }
	        } else if (mouseButton == 2) {
	            this.listening = true;
	        }
	        return true;
	    }

	    public boolean keyTyped(char typedChar, int keyCode) throws IOException {
	        if (this.listening) {
	            if (keyCode != 1) {
	                this.func.setModuleKey(keyCode);
	            } else {
	                this.func.setModuleKey(0);
	            }
	            this.listening = false;
	            return true;
	        }
	        return false;
	    }

	    public boolean isHovered(int mouseX, int mouseY) {
	        return (double)mouseX >= this.x && (double)mouseX <= this.x + this.width && (double)mouseY >= this.y && (double)mouseY <= this.y + this.height;
	    }
}
