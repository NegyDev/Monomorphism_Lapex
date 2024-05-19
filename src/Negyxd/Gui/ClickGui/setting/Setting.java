package Negyxd.Gui.ClickGui.setting;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

import Negyxd.module.Module;

import java.util.ArrayList;

public class Setting {
    private final String display;
    private final String name;
    private final Module parent;
    private final String mode;
    private String pMode;
    private String sval;
    private ArrayList<String> options;
    private boolean bval;
    private double dval;
    private double min;
    private double max;
    private boolean onlyint = false;
    public boolean extended;
    private final boolean extraSetting;
    private String currentMode;
    private Setting mainSetting;

    public Setting(String iDisplay, String iname, Module iparent, String isval, ArrayList<String> ioptions) {
        this.display = iDisplay;
        this.name = iname;
        this.parent = iparent;
        this.sval = isval;
        this.options = ioptions;
        this.mode = "Combo";
        this.extraSetting = false;
    }

    public Setting(String iDisplay, String iname, Module iparent, boolean ibval) {
        this.display = iDisplay;
        this.name = iname;
        this.parent = iparent;
        this.bval = ibval;
        this.mode = "Check";
        this.extraSetting = false;
    }

    public Setting(String iDisplay, String iname, Module iparent, double idval, double imin, double imax, boolean ionlyint) {
        this.display = iDisplay;
        this.name = iname;
        this.pMode = "";
        this.parent = iparent;
        this.dval = idval;
        this.min = imin;
        this.max = imax;
        this.onlyint = ionlyint;
        this.mode = "Slider";
        this.extraSetting = false;
    }

    public Setting(String iDisplay, String iname, Module iparent, String isval, ArrayList<String> ioptions, Setting mainSetting, String currentMode) {
        this.display = iDisplay;
        this.name = iname;
        this.parent = iparent;
        this.sval = isval;
        this.options = ioptions;
        this.mode = "Combo";
        this.extraSetting = true;
        this.currentMode = currentMode;
        this.mainSetting = mainSetting;
    }

    public Setting(String iDisplay, String iname, Module iparent, boolean ibval, Setting mainSetting, String currentMode) {
        this.display = iDisplay;
        this.name = iname;
        this.parent = iparent;
        this.bval = ibval;
        this.mode = "Check";
        this.extraSetting = true;
        this.currentMode = currentMode;
        this.mainSetting = mainSetting;
    }

    public Setting(String iDisplay, String iname, Module iparent, double idval, double imin, double imax, boolean ionlyint, Setting mainSetting, String currentMode) {
        this.display = iDisplay;
        this.name = iname;
        this.pMode = "";
        this.parent = iparent;
        this.dval = idval;
        this.min = imin;
        this.max = imax;
        this.onlyint = ionlyint;
        this.mode = "Slider";
        this.extraSetting = true;
        this.currentMode = currentMode;
        this.mainSetting = mainSetting;
    }

    public String getSimpleName() {
        return this.display;
    }

    public String getName() {
        return this.name;
    }

    public Module getParentMod() {
        return this.parent;
    }

    public String getValString() {
        return this.sval;
    }

    public void setValString(String in) {
        this.sval = in;
    }

    public ArrayList<String> getOptions() {
        return this.options;
    }

    public boolean getValBoolean() {
        return this.bval;
    }

    public void setValBoolean(boolean in) {
        this.bval = in;
    }

    public double getValDouble() {
        if (this.onlyint) {
            this.dval = (int)this.dval;
        }
        return this.dval;
    }

    public float getValFloat() {
        if (this.onlyint) {
            this.dval = (int)this.dval;
        }
        return (float)this.dval;
    }

    public int getValInt() {
        if (this.onlyint) {
            this.dval = (int)this.dval;
        }
        return (int)this.dval;
    }

    public void setValDouble(double in) {
        this.dval = in;
    }

    public double getMin() {
        return this.min;
    }

    public double getMax() {
        return this.max;
    }

    public String getMode() {
        return this.mode;
    }

    public boolean isCombo() {
        return this.mode.equalsIgnoreCase("Combo");
    }

    public boolean isColorCombo() {
        return this.mode.equalsIgnoreCase("ColorCombo");
    }

    public boolean isCheck() {
        return this.mode.equalsIgnoreCase("Check");
    }

    public boolean isSlider() {
        return this.mode.equalsIgnoreCase("Slider");
    }

    public String getpMode() {
        return this.pMode;
    }

    public boolean onlyInt() {
        return this.onlyint;
    }

    public boolean isExtra() {
        return this.extraSetting;
    }

    public Setting getMainSetting() {
        return this.mainSetting;
    }

    public boolean shouldRender() {
        if (!this.extraSetting) {
            return true;
        }
        if (this.mainSetting.isCombo()) {
            return this.mainSetting.getValString().equalsIgnoreCase(this.currentMode);
        }
        return this.mainSetting.isCheck() && this.mainSetting.getValBoolean();
    }

    public JsonElement toJson() {
        JsonPrimitive element = null;
        switch (this.mode.toLowerCase()) {
            case "combo": {
                element = new JsonPrimitive(this.sval);
                break;
            }
            case "check": {
                element = new JsonPrimitive(this.bval);
                break;
            }
            case "slider": {
                element = new JsonPrimitive(this.dval);
            }
        }
        return element;
    }

    public void fromJson(JsonElement element) {
        switch (this.mode.toLowerCase()) {
            case "combo": {
                this.setValString(element.getAsString());
                break;
            }
            case "check": {
                this.setValBoolean(element.getAsBoolean());
                break;
            }
            case "slider": {
                this.setValDouble(element.getAsDouble());
            }
        }
    }
}
