package Negyxd.Gui.ClickGui.elements.impl;

import Negyxd.Gui.ClickGui.elements.Element;
import Negyxd.Gui.ClickGui.elements.ModuleButton;
import Negyxd.Gui.ClickGui.setting.Setting;
import Negyxd.Mappings.Minecraft;
import Negyxd.Utils.RenderUtil;

public class ElementComboBox
extends Element {
    public ElementComboBox(ModuleButton iparent, Setting iset) {
        this.parent = iparent;
        this.set = iset;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        RenderUtil.drawRect(this.x, this.y, this.x + this.width, this.y + this.height, -2039584);
        RenderUtil.drawGradientSideways(this.x, this.y, this.x + this.width - 100.0, this.y + this.height, -5460820, 0xE0E0E0);
        RenderUtil.drawOctagon((float)this.x + 8.0f, (float)this.y + 1.0f, (float)this.width - 16.0f, 14.0f, 1.0f, 6.0f, -16746560);
        if (this.comboextended) {
            RenderUtil.drawRect(this.x + 12.0, this.y + 15.0, this.x + this.width - 12.0, this.y + this.height, -2236963);
        }
        Minecraft.fontRendererobj.drawString(this.setstrg, (float)((int)(this.x + this.width / 2.0 - (double)(Minecraft.getMinecraft().C.z(this.setstrg) / 2))), (float)((int)(this.y + 4.0)), -1, true);
        if (this.comboextended) {
            double d0 = this.y + 16.0;
            for (String s : this.set.getOptions()) {
                String s1 = String.valueOf(s.substring(0, 1).toUpperCase()) + s.substring(1);
                Minecraft.fontRendererobj.drawString(s1, (int)(this.x + this.width / 2.0 - (double)(Minecraft.getMinecraft().C.z(s1) / 2)), (int)(d0 + 1.0), s.equalsIgnoreCase(this.set.getValString()) ? -16746560 : -12105913);
                s.equalsIgnoreCase(this.set.getValString());
                if (!((double)mouseX >= this.x) || !((double)mouseX <= this.x + this.width) || (double)mouseY >= d0) {
                    // empty if block
                }
                d0 += 13.0;
            }
        }
    }

    @Override
    public boolean mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (mouseButton == 0) {
            if (this.isButtonHovered(mouseX, mouseY)) {
                this.comboextended = !this.comboextended;
                return true;
            }
            if (!this.comboextended) {
                return false;
            }
            double d0 = this.y + 16.0;
            for (String s : this.set.getOptions()) {
                if ((double)mouseX >= this.x && (double)mouseX <= this.x + this.width && (double)mouseY >= d0 && (double)mouseY <= d0 + 9.0 + 2.0) {
                    if (this.clickgui != null && this.clickgui.setmgr != null) {
                        this.clickgui.setmgr.getSettingByName(this.set.getName()).setValString(s.toLowerCase());
                    }
                    return true;
                }
                d0 += 15.0;
            }
        }
        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    public boolean isButtonHovered(int mouseX, int mouseY) {
        return (double)mouseX >= this.x && (double)mouseX <= this.x + this.width && (double)mouseY >= this.y && (double)mouseY <= this.y + 15.0;
    }
}
