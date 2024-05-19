package Negyxd.Gui.ClickGui;

import java.util.ArrayList;

import Negyxd.Gui.ClickGui.elements.ModuleButton;
import Negyxd.Mappings.Minecraft;
import Negyxd.Utils.RenderUtil;

public class Panel {
    public String title;
    public double x;
    public double y;
    private double x2;
    private double y2;
    public double width;
    public double height;
    public double animHeight;
    public boolean dragging;
    public boolean extended;
    public boolean visible;
    public ArrayList<ModuleButton> Elements = new ArrayList();
    public ClickGUI clickgui;

    public Panel(String ititle, double ix, double iy, double iwidth, double iheight, boolean iextended, ClickGUI parent) {
        this.title = ititle;
        this.x = ix;
        this.y = iy;
        this.width = iwidth;
        this.height = iheight;
        this.extended = iextended;
        this.dragging = false;
        this.visible = true;
        this.clickgui = parent;
        this.setup();
    }

    public void setup() {
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        if (this.visible) {
            if (this.dragging) {
                this.x = this.x2 + (double)mouseX;
                this.y = this.y2 + (double)mouseY;
            }
            RenderUtil.drawOctagon((float)this.x, (float)this.y, (float)this.width, (float)this.height + 1.0f, 2.0f, 12.0f, -2039584);
            int k = (int)this.x + 5;
            int l = (int)(this.y + 10.0);
            Minecraft.fontRendererobj.drawString(this.title, k, l, -13158601);
            if (this.extended && !this.Elements.isEmpty()) {
                double d0 = this.y + this.height;
                for (ModuleButton modulebutton : this.Elements) {
                    RenderUtil.drawRect(this.x, d0, this.x + this.width, d0 + modulebutton.height + 1.0, -1118482);
                    if (this.Elements.get(0) == modulebutton) {
                        RenderUtil.drawGradient(this.x, d0, this.x + this.width, d0 + 10.0, -4342339, 0xEEEEEE);
                    }
                    modulebutton.x = this.x + 2.0;
                    modulebutton.y = d0;
                    modulebutton.width = this.width - 4.0;
                    modulebutton.drawScreen(mouseX, mouseY, partialTicks);
                    d0 += modulebutton.height + 1.0;
                }
            }
        }
    }

    public boolean mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (!this.visible) {
            return false;
        }
        if (mouseButton == 0 && this.isHovered(mouseX, mouseY)) {
            this.x2 = this.x - (double)mouseX;
            this.y2 = this.y - (double)mouseY;
            this.dragging = true;
            return true;
        }
        if (mouseButton == 1 && this.isHovered(mouseX, mouseY)) {
            this.extended = !this.extended;
            return true;
        }
        if (this.extended) {
            for (ModuleButton modulebutton : this.Elements) {
                if (!modulebutton.mouseClicked(mouseX, mouseY, mouseButton)) continue;
                return true;
            }
        }
        return false;
    }

    public void mouseReleased(int mouseX, int mouseY, int state) {
        if (this.visible && state == 0) {
            this.dragging = false;
        }
    }

    public boolean isHovered(int mouseX, int mouseY) {
        return (double)mouseX >= this.x && (double)mouseX <= this.x + this.width && (double)mouseY >= this.y && (double)mouseY <= this.y + this.height;
    }
}
