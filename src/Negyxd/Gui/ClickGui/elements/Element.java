package Negyxd.Gui.ClickGui.elements;

import Negyxd.Gui.ClickGui.ClickGUI;
import Negyxd.Gui.ClickGui.setting.Setting;
import Negyxd.Mappings.Minecraft;

public class Element {
    public ClickGUI clickgui;
    public ModuleButton parent;
    public Setting set;
    public double offset;
    public double x;
    public double y;
    public double width;
    public double height;
    public float anim;
    public float anim2;
    public String setstrg;
    public boolean comboextended;

    public void setup() {
        this.clickgui = this.parent.parent.clickgui;
        this.anim = 0.0f;
        this.anim2 = 0.0f;
    }

    public void tick() {
    }

    public void update() {
        this.x = this.parent.x + this.parent.width + 2.0;
        this.y = this.parent.y + this.offset;
        this.width = this.parent.width;
        this.height = 16.0;
        String s = this.set.getSimpleName();
        if (this.set.isCheck()) {
            this.setstrg = String.valueOf(s.substring(0, 1).toUpperCase()) + s.substring(1);
            double d0 = this.x + this.width - (double) Minecraft.getMinecraft().C.z(this.setstrg);
            if (d0 < this.x + 13.0) {
                this.width += this.x + 13.0 - d0 + 1.0;
            }
        } else if (this.set.isCombo()) {
            this.height = this.comboextended ? (double)(this.set.getOptions().size() * 12) + this.height : this.height;
            this.setstrg = String.valueOf(s.substring(0, 1).toUpperCase()) + s.substring(1);
            int j = Minecraft.getMinecraft().C.z(this.setstrg);
            for (String s1 : this.set.getOptions()) {
                int i = Minecraft.getMinecraft().C.z(s1);
                if (i <= j) continue;
                j = i;
            }
            double d1 = this.x + this.width - (double)j;
            if (d1 < this.x) {
                this.width += this.x - d1 + 1.0;
            }
        } else if (this.set.isSlider()) {
            this.setstrg = String.valueOf(s.substring(0, 1).toUpperCase()) + s.substring(1);
            String s3 = "" + (double)Math.round(this.set.getMax() * 100.0) / 100.0;
            double d2 = this.x + this.width - (double)Minecraft.getMinecraft().C.z(this.setstrg) - (double)Minecraft.getMinecraft().C.z(s3) - 4.0;
            if (d2 < this.x) {
                this.width += this.x - d2 + 1.0;
            }
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    }

    public boolean mouseClicked(int mouseX, int mouseY, int mouseButton) {
        return this.isHovered(mouseX, mouseY);
    }

    public void mouseReleased(int mouseX, int mouseY, int state) {
    }

    public boolean isHovered(int mouseX, int mouseY) {
        return (double)mouseX >= this.x && (double)mouseX <= this.x + this.width && (double)mouseY >= this.y && (double)mouseY <= this.y + this.height;
    }
}
