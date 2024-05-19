package Negyxd.Utils;

import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.FloatBuffer;

import org.lwjgl.Sys;
import org.lwjgl.opengl.GL11;

public class RenderUtil {
    public long last2DFrame = System.currentTimeMillis();
    public long last3DFrame = System.currentTimeMillis();
    public float delta2DFrameTime;
    public float delta3DFrameTime;

    public static void glRenderStart() {
        GL11.glPushMatrix();
        GL11.glPushAttrib(1048575);
        GL11.glEnable(3042);
        GL11.glDisable(2884);
        GL11.glDisable(3553);
    }

    public static void glRenderStop() {
        GL11.glEnable(3553);
        GL11.glEnable(2884);
        GL11.glDisable(3042);
        GL11.glPopAttrib();
        GL11.glPopMatrix();
    }

    public static float convertColor(int count, int color) {
        return (float)(color >> count & 0xFF) / 255.0f;
    }

    public static void setColor(Color c) {
        GL11.glColor4d((float)c.getRed() / 255.0f, (float)c.getGreen() / 255.0f, (float)c.getBlue() / 255.0f, (float)c.getAlpha() / 255.0f);
    }

    public static void drawGradient(double x, double y, double x2, double y2, int col1, int col2) {
        float f = (float)(col1 >> 24 & 0xFF) / 255.0f;
        float f1 = (float)(col1 >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(col1 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(col1 & 0xFF) / 255.0f;
        float f4 = (float)(col2 >> 24 & 0xFF) / 255.0f;
        float f5 = (float)(col2 >> 16 & 0xFF) / 255.0f;
        float f6 = (float)(col2 >> 8 & 0xFF) / 255.0f;
        float f7 = (float)(col2 & 0xFF) / 255.0f;
        RenderUtil.glRenderStart();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glShadeModel(7425);
        GL11.glPushMatrix();
        GL11.glBegin(7);
        GL11.glColor4f(f1, f2, f3, f);
        GL11.glVertex2d(x2, y);
        GL11.glVertex2d(x, y);
        GL11.glColor4f(f5, f6, f7, f4);
        GL11.glVertex2d(x, y2);
        GL11.glVertex2d(x2, y2);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
        GL11.glShadeModel(7424);
        GL11.glColor4d(1.0, 1.0, 1.0, 1.0);
        RenderUtil.glRenderStop();
    }

    public static void drawGradientSideways(double left, double top, double right, double bottom, int col1, int col2) {
        float f = (float)(col1 >> 24 & 0xFF) / 255.0f;
        float f1 = (float)(col1 >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(col1 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(col1 & 0xFF) / 255.0f;
        float f4 = (float)(col2 >> 24 & 0xFF) / 255.0f;
        float f5 = (float)(col2 >> 16 & 0xFF) / 255.0f;
        float f6 = (float)(col2 >> 8 & 0xFF) / 255.0f;
        float f7 = (float)(col2 & 0xFF) / 255.0f;
        RenderUtil.glRenderStart();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glShadeModel(7425);
        GL11.glPushMatrix();
        GL11.glBegin(7);
        GL11.glColor4f(f1, f2, f3, f);
        GL11.glVertex2d(left, top);
        GL11.glVertex2d(left, bottom);
        GL11.glColor4f(f5, f6, f7, f4);
        GL11.glVertex2d(right, bottom);
        GL11.glVertex2d(right, top);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
        GL11.glShadeModel(7424);
        RenderUtil.glRenderStop();
    }

    public static void drawRect(double x, double y, double d, double e, int color) {
        float f = (float)(color >> 24 & 0xFF) / 255.0f;
        float f1 = (float)(color >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(color >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(color & 0xFF) / 255.0f;
        RenderUtil.glRenderStart();
        GL11.glColor4f(f1, f2, f3, f);
        GL11.glBegin(7);
        GL11.glVertex2d(x, y);
        GL11.glVertex2d(d, y);
        GL11.glVertex2d(d, e);
        GL11.glVertex2d(x, e);
        GL11.glEnd();
        RenderUtil.glRenderStop();
    }

    public static void drawBorderedRect(float xPos, float yPos, float width, float height, float lineWidth, int lineColor, int bgColor) {
        RenderUtil.drawRect(xPos, yPos, width, height, bgColor);
        float f = (float)(lineColor >> 24 & 0xFF) / 255.0f;
        float f1 = (float)(lineColor >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(lineColor >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(lineColor & 0xFF) / 255.0f;
        RenderUtil.glRenderStart();
        GL11.glColor4f(f1, f2, f3, f);
        GL11.glLineWidth(lineWidth);
        GL11.glEnable(2848);
        GL11.glBegin(1);
        GL11.glVertex2d(xPos, yPos);
        GL11.glVertex2d(width, yPos);
        GL11.glVertex2d(width, yPos);
        GL11.glVertex2d(width, height);
        GL11.glVertex2d(width, height);
        GL11.glVertex2d(xPos, height);
        GL11.glVertex2d(xPos, height);
        GL11.glVertex2d(xPos, yPos);
        GL11.glEnd();
        RenderUtil.glRenderStop();
    }

    public static void drawOctagon(float xPos, float yPos, float width, float height, float length, float angle, int color) {
        float f = RenderUtil.convertColor(24, color);
        float f1 = RenderUtil.convertColor(16, color);
        float f2 = RenderUtil.convertColor(8, color);
        float f3 = RenderUtil.convertColor(0, color);
        RenderUtil.glRenderStart();
        GL11.glColor4f(f1, f2, f3, f);
        GL11.glBegin(9);
        GL11.glVertex2d(xPos + length, yPos);
        GL11.glVertex2d(xPos + width - length, yPos);
        GL11.glVertex2d(xPos + width - length, yPos);
        GL11.glVertex2d(xPos + width, yPos + height / 2.0f - angle);
        GL11.glVertex2d(xPos + width, yPos + height / 2.0f - angle);
        GL11.glVertex2d(xPos + width, yPos + height / 2.0f + angle);
        GL11.glVertex2d(xPos + width, yPos + height / 2.0f + angle);
        GL11.glVertex2d(xPos + width - length, yPos + height);
        GL11.glVertex2d(xPos + width - length, yPos + height);
        GL11.glVertex2d(xPos + length, yPos + height);
        GL11.glVertex2d(xPos + length, yPos + height);
        GL11.glVertex2d(xPos, yPos + height / 2.0f + angle);
        GL11.glVertex2d(xPos, yPos + height / 2.0f + angle);
        GL11.glVertex2d(xPos, yPos + height / 2.0f - angle);
        GL11.glVertex2d(xPos, yPos + height / 2.0f - angle);
        GL11.glVertex2d(xPos + length, yPos);
        GL11.glEnd();
        RenderUtil.glRenderStop();
    }

    public static void drawBorderedCircle(float x, float y, float radius, int lineWidth, int outsideC, int insideC) {
        RenderUtil.drawCircle(x, y, radius, insideC);
        RenderUtil.drawUnfilledCircle(x, y, radius, lineWidth, outsideC);
    }

    public static void drawCircle228(float x, float y, float radius, int lineWidth, int outsideC, int insideC, int jopaSlona) {
        RenderUtil.drawCircle228(x, y, radius, insideC, jopaSlona);
    }

    public static void drawUnfilledCircle228(float x, float y, float radius, float lineWidth, int color, int jopaSlona) {
        float f = (float)(color >> 16 & 0xFF) / 255.0f;
        float f1 = (float)(color >> 8 & 0xFF) / 255.0f;
        float f2 = (float)(color & 0xFF) / 255.0f;
        float f3 = (float)(color >> 24 & 0xFF) / 255.0f;
        GL11.glEnable(2848);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glDepthMask(true);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glHint(3155, 4354);
        RenderUtil.enableBlend();
        GL11.glColor4f(f, f1, f2, f3);
        GL11.glLineWidth(lineWidth);
        GL11.glBegin(2);
        int i = 0;
        while (i <= jopaSlona) {
            GL11.glVertex2d((double)x + Math.sin((double)i * Math.PI / 180.0) * (double)radius, (double)y + Math.cos((double)i * Math.PI / 180.0) * (double)radius);
            ++i;
        }
        GL11.glEnd();
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
        GL11.glHint(3154, 4352);
        GL11.glHint(3155, 4352);
        RenderUtil.disableBlend();
    }

    public static void drawUnfilledCircle(float x, float y, float radius, float lineWidth, int color) {
        float f = (float)(color >> 16 & 0xFF) / 255.0f;
        float f1 = (float)(color >> 8 & 0xFF) / 255.0f;
        float f2 = (float)(color & 0xFF) / 255.0f;
        float f3 = (float)(color >> 24 & 0xFF) / 255.0f;
        GL11.glEnable(2848);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glDepthMask(true);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glHint(3155, 4354);
        RenderUtil.enableBlend();
        GL11.glColor4f(f, f1, f2, f3);
        GL11.glLineWidth(lineWidth);
        GL11.glBegin(2);
        int i = 0;
        while (i <= 360) {
            GL11.glVertex2d((double)x + Math.sin((double)i * Math.PI / 180.0) * (double)radius, (double)y + Math.cos((double)i * Math.PI / 180.0) * (double)radius);
            ++i;
        }
        GL11.glEnd();
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
        GL11.glHint(3154, 4352);
        GL11.glHint(3155, 4352);
        RenderUtil.disableBlend();
    }

    public static void drawCircle228(float x, float y, float radius, int color, int jopaSlona) {
        float f = (float)(color >> 24 & 0xFF) / 255.0f;
        float f1 = (float)(color >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(color >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(color & 0xFF) / 255.0f;
        boolean flag = GL11.glIsEnabled(3042);
        boolean flag1 = GL11.glIsEnabled(2848);
        boolean flag2 = GL11.glIsEnabled(3553);
        if (!flag) {
            GL11.glEnable(3042);
        }
        if (!flag1) {
            GL11.glEnable(2848);
        }
        if (flag2) {
            GL11.glDisable(3553);
        }
        GL11.glEnable(2848);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(f1, f2, f3, f);
        GL11.glLineWidth(2.5f);
        GL11.glBegin(3);
        int i = 0;
        while (i <= jopaSlona) {
            GL11.glVertex2d((double)x + Math.sin((double)i * Math.PI / 180.0) * (double)radius, (double)y + Math.cos((double)i * Math.PI / 180.0) * (double)radius);
            ++i;
        }
        GL11.glEnd();
        GL11.glDisable(2848);
        if (flag2) {
            GL11.glEnable(3553);
        }
        if (!flag1) {
            GL11.glDisable(2848);
        }
        if (!flag) {
            GL11.glDisable(3042);
        }
    }

    public static void drawCircle(float x, float y, float radius, int color) {
        float f = (float)(color >> 24 & 0xFF) / 255.0f;
        float f1 = (float)(color >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(color >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(color & 0xFF) / 255.0f;
        boolean flag = GL11.glIsEnabled(3042);
        boolean flag1 = GL11.glIsEnabled(2848);
        boolean flag2 = GL11.glIsEnabled(3553);
        if (!flag) {
            GL11.glEnable(3042);
        }
        if (!flag1) {
            GL11.glEnable(2848);
        }
        if (flag2) {
            GL11.glDisable(3553);
        }
        GL11.glEnable(2848);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(f1, f2, f3, f);
        GL11.glBegin(9);
        int i = 0;
        while (i <= 360) {
            GL11.glVertex2d((double)x + Math.sin((double)i * Math.PI / 180.0) * (double)radius, (double)y + Math.cos((double)i * Math.PI / 180.0) * (double)radius);
            ++i;
        }
        GL11.glEnd();
        GL11.glDisable(2848);
        if (flag2) {
            GL11.glEnable(3553);
        }
        if (!flag1) {
            GL11.glDisable(2848);
        }
        if (!flag) {
            GL11.glDisable(3042);
        }
    }

    public static void enableScissoring() {
        GL11.glEnable(3089);
    }

    public static void disableScissoring() {
        GL11.glDisable(3089);
    }

    public static void pushAttrib() {
        GL11.glPushAttrib(8256);
    }

    public static void popAttrib() {
        GL11.glPopAttrib();
    }

    public static void color(int color, float alpha) {
        float r = (float)(color >> 16 & 0xFF) / 255.0f;
        float g = (float)(color >> 8 & 0xFF) / 255.0f;
        float b = (float)(color & 0xFF) / 255.0f;
        GL11.glColor4f(r, g, b, alpha);
    }

    public static void color(int color) {
        RenderUtil.color(color, (float)(color >> 24 & 0xFF) / 255.0f);
    }

    public static void resetColor() {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public static void clear(int mask) {
        GL11.glClear(mask);
    }

    public static void matrixMode(int mode) {
        GL11.glMatrixMode(mode);
    }

    public static void loadIdentity() {
        GL11.glLoadIdentity();
    }

    public static void pushMatrix() {
        GL11.glPushMatrix();
    }

    public static void popMatrix() {
        GL11.glPopMatrix();
    }

    public static void getFloat(int pname, FloatBuffer params) {
        GL11.glGetFloat(pname, params);
    }

    public static void ortho(double left, double right, double bottom, double top, double zNear, double zFar) {
        GL11.glOrtho(left, right, bottom, top, zNear, zFar);
    }

    public static void rotate(float angle, float x, float y, float z) {
        GL11.glRotatef(angle, x, y, z);
    }

    public static void scale(float x, float y, float z) {
        GL11.glScalef(x, y, z);
    }

    public static Color rainbow(int speed, int index, float saturation, float brightness, float opacity) {
        int angle = (int)((System.currentTimeMillis() / (long)speed + (long)index) % 360L);
        float hue = (float)angle / 360.0f;
        Color color = new Color(Color.HSBtoRGB(hue, saturation, brightness));
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), Math.max(0, Math.min(255, (int)(opacity * 255.0f))));
    }

    public static void scale(double x, double y, double z) {
        GL11.glScaled(x, y, z);
    }

    public static void translate(float x, float y, float z) {
        GL11.glTranslatef(x, y, z);
    }

    public static void translate(double x, double y, double z) {
        GL11.glTranslated(x, y, z);
    }

    public static void bindTexture(int texture) {
        GL11.glBindTexture(3553, texture);
    }

    public static void depthMask(boolean flagIn) {
        GL11.glDepthMask(flagIn);
    }

    public static void disableBlend() {
        GL11.glDisable(3042);
    }

    public static void enableBlend() {
        GL11.glEnable(3042);
    }

    public static void disableAlpha() {
        GL11.glDisable(3008);
    }

    public static void enableAlpha() {
        GL11.glEnable(3008);
    }

    public static void disableTexture2D() {
        GL11.glDisable(3553);
    }

    public static void enableTexture2D() {
        GL11.glEnable(3553);
    }

    public static void enableLighting() {
        GL11.glEnable(2896);
    }

    public static void disableLighting() {
        GL11.glDisable(2896);
    }

    public static void blendFunc(int srcFactor, int dstFactor) {
        GL11.glBlendFunc(srcFactor, dstFactor);
    }

    public static void setAlphaLimit(float limit) {
        GL11.glEnable(3008);
        GL11.glAlphaFunc(516, (float)((double)limit * 0.01));
    }

    public static long getSystemTime() {
        return Sys.getTime() * 1000L / Sys.getTimerResolution();
    }

    public static int clamp(int num, int min, int max) {
        return num < min ? min : Math.min(num, max);
    }

    public static float clamp(float num, float min, float max) {
        return num < min ? min : Math.min(num, max);
    }

    public static int getRandomInRange(int min, int max) {
        return (int)(Math.random() * (double)(max - min) + (double)min);
    }

    public static double clamp(double num, double min, double max) {
        return num < min ? min : Math.min(num, max);
    }

    public static double getNormalDouble(double d, int numberAfterZopyataya) {
        return new BigDecimal(d).setScale(numberAfterZopyataya, RoundingMode.HALF_EVEN).doubleValue();
    }

    public static double getNormalDouble(double d) {
        return new BigDecimal(d).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    public static void push() {
        GL11.glPushMatrix();
    }

    public static void pop() {
        GL11.glPopMatrix();
    }

    public static void enable(int glTarget) {
        GL11.glEnable(glTarget);
    }

    public static void disable(int glTarget) {
        GL11.glDisable(glTarget);
    }

    public static void start() {
        RenderUtil.enable(3042);
        GL11.glBlendFunc(770, 771);
        RenderUtil.disable(3553);
        RenderUtil.disable(2884);
        RenderUtil.disableAlpha();
        RenderUtil.disable(2929);
    }

    public static void stop() {
        RenderUtil.enableAlpha();
        RenderUtil.enable(2929);
        RenderUtil.enable(2884);
        RenderUtil.enable(3553);
        RenderUtil.disable(3042);
        RenderUtil.color(Color.white);
    }

    public static void startSmooth() {
        RenderUtil.enable(2881);
        RenderUtil.enable(2848);
        RenderUtil.enable(2832);
    }

    public static void endSmooth() {
        RenderUtil.disable(2832);
        RenderUtil.disable(2848);
        RenderUtil.disable(2881);
    }

    public static void begin(int glMode) {
        GL11.glBegin(glMode);
    }

    public static void end() {
        GL11.glEnd();
    }

    public static void vertex(double x, double y) {
        GL11.glVertex2d(x, y);
    }

    public static void translate(double x, double y) {
        GL11.glTranslated(x, y, 0.0);
    }

    public static void scale(double x, double y) {
        GL11.glScaled(x, y, 1.0);
    }

    public static void rotate(double x, double y, double z, double angle) {
        GL11.glRotated(angle, x, y, z);
    }

    public static void color(double red, double green, double blue, double alpha) {
        GL11.glColor4d(red, green, blue, alpha);
    }

    public static void color(double red, double green, double blue) {
        RenderUtil.color(red, green, blue, 1.0);
    }

    public static void color(Color color) {
        if (color == null) {
            color = Color.white;
        }
        RenderUtil.color((float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f, (float)color.getAlpha() / 255.0f);
    }

    public static void color(Color color, int alpha) {
        if (color == null) {
            color = Color.white;
        }
        RenderUtil.color((float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f, 0.5);
    }

    public static void lineWidth(double width) {
        GL11.glLineWidth((float)width);
    }

    public static void rect(double x, double y, double width, double height, boolean filled, Color color) {
        RenderUtil.start();
        if (color != null) {
            RenderUtil.color(color);
        }
        RenderUtil.begin(filled ? 6 : 1);
        RenderUtil.vertex(x, y);
        RenderUtil.vertex(x + width, y);
        RenderUtil.vertex(x + width, y + height);
        RenderUtil.vertex(x, y + height);
        if (!filled) {
            RenderUtil.vertex(x, y);
            RenderUtil.vertex(x, y + height);
            RenderUtil.vertex(x + width, y);
            RenderUtil.vertex(x + width, y + height);
        }
        RenderUtil.end();
        RenderUtil.stop();
    }

    public static void rect(double x, double y, double width, double height, boolean filled) {
        RenderUtil.rect(x, y, width, height, filled, null);
    }

    public static void rect(double x, double y, double width, double height, Color color) {
        RenderUtil.rect(x, y, width, height, true, color);
    }

    public static void rect(double x, double y, double width, double height) {
        RenderUtil.rect(x, y, width, height, true, null);
    }

    public static void rectCentered(double x, double y, double width, double height, boolean filled, Color color) {
        RenderUtil.rect(x -= width / 2.0, y -= height / 2.0, width, height, filled, color);
    }

    public static void rectCentered(double x, double y, double width, double height, boolean filled) {
        RenderUtil.rect(x -= width / 2.0, y -= height / 2.0, width, height, filled, null);
    }

    public static void rectCentered(double x, double y, double width, double height, Color color) {
        RenderUtil.rect(x -= width / 2.0, y -= height / 2.0, width, height, true, color);
    }

    public static void rectCentered(double x, double y, double width, double height) {
        RenderUtil.rect(x -= width / 2.0, y -= height / 2.0, width, height, true, null);
    }

    public static void gradient(double x, double y, double width, double height, boolean filled, Color color1, Color color2) {
        RenderUtil.start();
        GL11.glShadeModel(7425);
        RenderUtil.enableAlpha();
        GL11.glAlphaFunc(516, 0.0f);
        if (color1 != null) {
            RenderUtil.color(color1);
        }
        RenderUtil.begin(filled ? 7 : 1);
        RenderUtil.vertex(x, y);
        RenderUtil.vertex(x + width, y);
        if (color2 != null) {
            RenderUtil.color(color2);
        }
        RenderUtil.vertex(x + width, y + height);
        RenderUtil.vertex(x, y + height);
        if (!filled) {
            RenderUtil.vertex(x, y);
            RenderUtil.vertex(x, y + height);
            RenderUtil.vertex(x + width, y);
            RenderUtil.vertex(x + width, y + height);
        }
        RenderUtil.end();
        GL11.glAlphaFunc(516, 0.1f);
        RenderUtil.disableAlpha();
        GL11.glShadeModel(7424);
        RenderUtil.stop();
    }

    public static void gradient(double x, double y, double width, double height, Color color1, Color color2) {
        RenderUtil.gradient(x, y, width, height, true, color1, color2);
    }

    public static void gradientCentered(double x, double y, double width, double height, Color color1, Color color2) {
        RenderUtil.gradient(x -= width / 2.0, y -= height / 2.0, width, height, true, color1, color2);
    }

    public static void gradientSideways(double x, double y, double width, double height, boolean filled, Color color1, Color color2) {
        RenderUtil.start();
        GL11.glShadeModel(7425);
        RenderUtil.disableAlpha();
        if (color1 != null) {
            RenderUtil.color(color1);
        }
        RenderUtil.begin(filled ? 6 : 1);
        RenderUtil.vertex(x, y);
        RenderUtil.vertex(x, y + height);
        if (color2 != null) {
            RenderUtil.color(color2);
        }
        RenderUtil.vertex(x + width, y + height);
        RenderUtil.vertex(x + width, y);
        RenderUtil.end();
        RenderUtil.enableAlpha();
        GL11.glShadeModel(7424);
        RenderUtil.stop();
    }

    public static void gradientSideways(double x, double y, double width, double height, Color color1, Color color2) {
        RenderUtil.gradientSideways(x, y, width, height, true, color1, color2);
    }

    public static void gradientSidewaysCentered(double x, double y, double width, double height, Color color1, Color color2) {
        RenderUtil.gradientSideways(x -= width / 2.0, y -= height / 2.0, width, height, true, color1, color2);
    }

    public static void polygon(double x, double y, double sideLength, double amountOfSides, boolean filled, Color color) {
        sideLength /= 2.0;
        RenderUtil.start();
        if (color != null) {
            RenderUtil.color(color);
        }
        if (!filled) {
            GL11.glLineWidth(2.0f);
        }
        GL11.glEnable(2848);
        RenderUtil.begin(filled ? 6 : 3);
        double i = 0.0;
        while (i <= amountOfSides / 4.0) {
            double angle = i * 4.0 * (Math.PI * 2) / 360.0;
            RenderUtil.vertex(x + sideLength * Math.cos(angle) + sideLength, y + sideLength * Math.sin(angle) + sideLength);
            i += 1.0;
        }
        RenderUtil.end();
        GL11.glDisable(2848);
        RenderUtil.stop();
    }

    public static void polygon(double x, double y, double sideLength, int amountOfSides, boolean filled) {
        RenderUtil.polygon(x, y, sideLength, amountOfSides, filled, null);
    }

    public static void polygon(double x, double y, double sideLength, int amountOfSides, Color color) {
        RenderUtil.polygon(x, y, sideLength, amountOfSides, true, color);
    }

    public static void polygon(double x, double y, double sideLength, int amountOfSides) {
        RenderUtil.polygon(x, y, sideLength, amountOfSides, true, null);
    }

    public static void polygonCentered(double x, double y, double sideLength, int amountOfSides, boolean filled, Color color) {
        RenderUtil.polygon(x -= sideLength / 2.0, y -= sideLength / 2.0, sideLength, amountOfSides, filled, color);
    }

    public static void polygonCentered(double x, double y, double sideLength, int amountOfSides, boolean filled) {
        RenderUtil.polygon(x -= sideLength / 2.0, y -= sideLength / 2.0, sideLength, amountOfSides, filled, null);
    }

    public static void polygonCentered(double x, double y, double sideLength, int amountOfSides, Color color) {
        RenderUtil.polygon(x -= sideLength / 2.0, y -= sideLength / 2.0, sideLength, amountOfSides, true, color);
    }

    public static void polygonCentered(double x, double y, double sideLength, int amountOfSides) {
        RenderUtil.polygon(x -= sideLength / 2.0, y -= sideLength / 2.0, sideLength, amountOfSides, true, null);
    }

    public static void circle(double x, double y, double radius, boolean filled, Color color) {
        RenderUtil.polygon(x, y, radius, 360.0, filled, color);
    }

    public static void circle(double x, double y, double radius, boolean filled) {
        RenderUtil.polygon(x, y, radius, 360, filled);
    }

    public static void circle(double x, double y, double radius, Color color) {
        RenderUtil.polygon(x, y, radius, 360, color);
    }

    public static void circle(double x, double y, double radius) {
        RenderUtil.polygon(x, y, radius, 360);
    }

    public static void circleCentered(double x, double y, double radius, boolean filled, Color color) {
        RenderUtil.polygon(x -= radius / 2.0, y -= radius / 2.0, radius, 360.0, filled, color);
    }

    public static void circleCentered(double x, double y, double radius, boolean filled) {
        RenderUtil.polygon(x -= radius / 2.0, y -= radius / 2.0, radius, 360, filled);
    }

    public static void circleCentered(double x, double y, double radius, boolean filled, int sides) {
        RenderUtil.polygon(x -= radius / 2.0, y -= radius / 2.0, radius, sides, filled);
    }

    public static void circleCentered(double x, double y, double radius, Color color) {
        RenderUtil.polygon(x -= radius / 2.0, y -= radius / 2.0, radius, 360, color);
    }

    public static void circleCentered(double x, double y, double radius) {
        RenderUtil.polygon(x -= radius / 2.0, y -= radius / 2.0, radius, 360);
    }

    public static void triangle(double x, double y, double sideLength, boolean filled, Color color) {
        RenderUtil.polygon(x, y, sideLength, 3.0, filled, color);
    }

    public static void triangle(double x, double y, double sideLength, boolean filled) {
        RenderUtil.polygon(x, y, sideLength, 3, filled);
    }

    public static void triangle(double x, double y, double sideLength, Color color) {
        RenderUtil.polygon(x, y, sideLength, 3, color);
    }

    public static void triangle(double x, double y, double sideLength) {
        RenderUtil.polygon(x, y, sideLength, 3);
    }

    public static void triangleCentered(double x, double y, double sideLength, boolean filled, Color color) {
        RenderUtil.polygon(x -= sideLength / 2.0, y -= sideLength / 2.0, sideLength, 3.0, filled, color);
    }

    public static void triangleCentered(double x, double y, double sideLength, boolean filled) {
        RenderUtil.polygon(x -= sideLength / 2.0, y -= sideLength / 2.0, sideLength, 3, filled);
    }

    public static void triangleCentered(double x, double y, double sideLength, Color color) {
        RenderUtil.polygon(x -= sideLength / 2.0, y -= sideLength / 2.0, sideLength, 3, color);
    }

    public static void triangleCentered(double x, double y, double sideLength) {
        RenderUtil.polygon(x -= sideLength / 2.0, y -= sideLength / 2.0, sideLength, 3);
    }

    public static void lineNoGl(double firstX, double firstY, double secondX, double secondY, Color color) {
        RenderUtil.start();
        if (color != null) {
            RenderUtil.color(color);
        }
        RenderUtil.lineWidth(1.0f);
        GL11.glEnable(2848);
        RenderUtil.begin(1);
        RenderUtil.vertex(firstX, firstY);
        RenderUtil.vertex(secondX, secondY);
        RenderUtil.end();
        GL11.glDisable(2848);
        RenderUtil.stop();
    }

    public static void line(double firstX, double firstY, double secondX, double secondY, double lineWidth, Color color) {
        RenderUtil.start();
        if (color != null) {
            RenderUtil.color(color);
        }
        RenderUtil.lineWidth(lineWidth);
        GL11.glEnable(2848);
        RenderUtil.begin(1);
        RenderUtil.vertex(firstX, firstY);
        RenderUtil.vertex(secondX, secondY);
        RenderUtil.end();
        GL11.glDisable(2848);
        RenderUtil.stop();
    }

    public static void line(double firstX, double firstY, double secondX, double secondY, double lineWidth) {
        RenderUtil.line(firstX, firstY, secondX, secondY, lineWidth, null);
    }

    public static void line(double firstX, double firstY, double secondX, double secondY, Color color) {
        RenderUtil.line(firstX, firstY, secondX, secondY, 0.0, color);
    }

    public static void line(double firstX, double firstY, double secondX, double secondY) {
        RenderUtil.line(firstX, firstY, secondX, secondY, 0.0, null);
    }

    public static void outlineInlinedGradientRect(double x, double y, double width, double height, double inlineOffset, Color color1, Color color2) {
        RenderUtil.gradient(x, y, width, inlineOffset, color1, color2);
        RenderUtil.gradient(x, y + height - inlineOffset, width, inlineOffset, color2, color1);
        RenderUtil.gradientSideways(x, y, inlineOffset, height, color1, color2);
        RenderUtil.gradientSideways(x + width - inlineOffset, y, inlineOffset, height, color2, color1);
    }

    public static void roundedRect(double x, double y, double width, double height, double edgeRadius, Color color) {
        double angle;
        double halfRadius = edgeRadius / 2.0;
        width -= halfRadius;
        height -= halfRadius;
        float sideLength = (float)edgeRadius;
        sideLength /= 2.0f;
        RenderUtil.start();
        if (color != null) {
            RenderUtil.color(color);
        }
        RenderUtil.begin(6);
        double i = 180.0;
        while (i <= 270.0) {
            angle = i * (Math.PI * 2) / 360.0;
            RenderUtil.vertex(x + (double)sideLength * Math.cos(angle) + (double)sideLength, y + (double)sideLength * Math.sin(angle) + (double)sideLength);
            i += 1.0;
        }
        RenderUtil.vertex(x + (double)sideLength, y + (double)sideLength);
        RenderUtil.end();
        RenderUtil.stop();
        sideLength = (float)edgeRadius;
        sideLength /= 2.0f;
        RenderUtil.start();
        if (color != null) {
            RenderUtil.color(color);
        }
        GL11.glEnable(2848);
        RenderUtil.begin(6);
        i = 0.0;
        while (i <= 90.0) {
            angle = i * (Math.PI * 2) / 360.0;
            RenderUtil.vertex(x + width + (double)sideLength * Math.cos(angle), y + height + (double)sideLength * Math.sin(angle));
            i += 1.0;
        }
        RenderUtil.vertex(x + width, y + height);
        RenderUtil.end();
        GL11.glDisable(2848);
        RenderUtil.stop();
        sideLength = (float)edgeRadius;
        sideLength /= 2.0f;
        RenderUtil.start();
        if (color != null) {
            RenderUtil.color(color);
        }
        GL11.glEnable(2848);
        RenderUtil.begin(6);
        i = 270.0;
        while (i <= 360.0) {
            angle = i * (Math.PI * 2) / 360.0;
            RenderUtil.vertex(x + width + (double)sideLength * Math.cos(angle), y + (double)sideLength * Math.sin(angle) + (double)sideLength);
            i += 1.0;
        }
        RenderUtil.vertex(x + width, y + (double)sideLength);
        RenderUtil.end();
        GL11.glDisable(2848);
        RenderUtil.stop();
        sideLength = (float)edgeRadius;
        sideLength /= 2.0f;
        RenderUtil.start();
        if (color != null) {
            RenderUtil.color(color);
        }
        GL11.glEnable(2848);
        RenderUtil.begin(6);
        i = 90.0;
        while (i <= 180.0) {
            angle = i * (Math.PI * 2) / 360.0;
            RenderUtil.vertex(x + (double)sideLength * Math.cos(angle) + (double)sideLength, y + height + (double)sideLength * Math.sin(angle));
            i += 1.0;
        }
        RenderUtil.vertex(x + (double)sideLength, y + height);
        RenderUtil.end();
        GL11.glDisable(2848);
        RenderUtil.stop();
        RenderUtil.rect(x + halfRadius, y + halfRadius, width - halfRadius, height - halfRadius, color);
        RenderUtil.rect(x, y + halfRadius, edgeRadius / 2.0, height - halfRadius, color);
        RenderUtil.rect(x + width, y + halfRadius, edgeRadius / 2.0, height - halfRadius, color);
        RenderUtil.rect(x + halfRadius, y, width - halfRadius, halfRadius, color);
        RenderUtil.rect(x + halfRadius, y + height, width - halfRadius, halfRadius, color);
    }

    public static void roundedOutLine(double x, double y, double width, double height, double thickness, double edgeRadius, Color color) {
        double angle;
        double halfRadius = edgeRadius / 2.0;
        width -= halfRadius;
        height -= halfRadius;
        float sideLength = (float)edgeRadius;
        sideLength /= 2.0f;
        RenderUtil.start();
        if (color != null) {
            RenderUtil.color(color);
        }
        GL11.glEnable(2848);
        RenderUtil.begin(1);
        double i = 180.0;
        while (i <= 270.0) {
            angle = i * (Math.PI * 2) / 360.0;
            RenderUtil.vertex(x + (double)sideLength * Math.cos(angle) + (double)sideLength, y + (double)sideLength * Math.sin(angle) + (double)sideLength);
            i += 1.0;
        }
        RenderUtil.vertex(x + (double)sideLength, y + (double)sideLength);
        RenderUtil.end();
        RenderUtil.stop();
        sideLength = (float)edgeRadius;
        sideLength /= 2.0f;
        RenderUtil.start();
        if (color != null) {
            RenderUtil.color(color);
        }
        GL11.glEnable(2848);
        RenderUtil.begin(1);
        i = 0.0;
        while (i <= 90.0) {
            angle = i * (Math.PI * 2) / 360.0;
            RenderUtil.vertex(x + width + (double)sideLength * Math.cos(angle), y + height + (double)sideLength * Math.sin(angle));
            i += 1.0;
        }
        RenderUtil.vertex(x + width, y + height);
        RenderUtil.end();
        GL11.glDisable(2848);
        RenderUtil.stop();
        sideLength = (float)edgeRadius;
        sideLength /= 2.0f;
        RenderUtil.start();
        if (color != null) {
            RenderUtil.color(color);
        }
        GL11.glEnable(2848);
        RenderUtil.begin(1);
        i = 270.0;
        while (i <= 360.0) {
            angle = i * (Math.PI * 2) / 360.0;
            RenderUtil.vertex(x + width + (double)sideLength * Math.cos(angle), y + (double)sideLength * Math.sin(angle) + (double)sideLength);
            i += 1.0;
        }
        RenderUtil.vertex(x + width, y + (double)sideLength);
        RenderUtil.end();
        GL11.glDisable(2848);
        RenderUtil.stop();
        sideLength = (float)edgeRadius;
        sideLength /= 2.0f;
        RenderUtil.start();
        if (color != null) {
            RenderUtil.color(color);
        }
        GL11.glEnable(2848);
        RenderUtil.begin(1);
        i = 90.0;
        while (i <= 180.0) {
            angle = i * (Math.PI * 2) / 360.0;
            RenderUtil.vertex(x + (double)sideLength * Math.cos(angle) + (double)sideLength, y + height + (double)sideLength * Math.sin(angle));
            i += 1.0;
        }
        RenderUtil.vertex(x + (double)sideLength, y + height);
        RenderUtil.end();
        GL11.glDisable(2848);
        RenderUtil.stop();
    }

    public static void roundedRectCustom(double x, double y, double width, double height, double edgeRadius, Color color, boolean topLeft, boolean topRight, boolean bottomLeft, boolean bottomRight) {
        double angle;
        double i;
        double halfRadius = edgeRadius / 2.0;
        width -= halfRadius;
        height -= halfRadius;
        float sideLength = (float)edgeRadius;
        sideLength /= 2.0f;
        RenderUtil.start();
        if (color != null) {
            RenderUtil.color(color);
        }
        if (topLeft) {
            GL11.glEnable(2848);
            RenderUtil.begin(6);
            i = 180.0;
            while (i <= 270.0) {
                angle = i * (Math.PI * 2) / 360.0;
                RenderUtil.vertex(x + (double)sideLength * Math.cos(angle) + (double)sideLength, y + (double)sideLength * Math.sin(angle) + (double)sideLength);
                i += 1.0;
            }
            RenderUtil.vertex(x + (double)sideLength, y + (double)sideLength);
            RenderUtil.end();
            GL11.glDisable(2848);
            RenderUtil.stop();
        } else {
            RenderUtil.rect(x, y, (double)sideLength, (double)sideLength, color);
        }
        sideLength = (float)edgeRadius;
        sideLength /= 2.0f;
        RenderUtil.start();
        if (color != null) {
            RenderUtil.color(color);
        }
        if (bottomRight) {
            GL11.glEnable(2848);
            RenderUtil.begin(6);
            i = 0.0;
            while (i <= 90.0) {
                angle = i * (Math.PI * 2) / 360.0;
                RenderUtil.vertex(x + width + (double)sideLength * Math.cos(angle), y + height + (double)sideLength * Math.sin(angle));
                i += 1.0;
            }
            RenderUtil.vertex(x + width, y + height);
            RenderUtil.end();
            GL11.glDisable(2848);
            RenderUtil.stop();
        } else {
            RenderUtil.rect(x + width, y + height, (double)sideLength, (double)sideLength, color);
        }
        sideLength = (float)edgeRadius;
        sideLength /= 2.0f;
        RenderUtil.start();
        if (color != null) {
            RenderUtil.color(color);
        }
        if (topRight) {
            GL11.glEnable(2848);
            RenderUtil.begin(6);
            i = 270.0;
            while (i <= 360.0) {
                angle = i * (Math.PI * 2) / 360.0;
                RenderUtil.vertex(x + width + (double)sideLength * Math.cos(angle), y + (double)sideLength * Math.sin(angle) + (double)sideLength);
                i += 1.0;
            }
            RenderUtil.vertex(x + width, y + (double)sideLength);
            RenderUtil.end();
            GL11.glDisable(2848);
            RenderUtil.stop();
        } else {
            RenderUtil.rect(x + width, y, (double)sideLength, (double)sideLength, color);
        }
        sideLength = (float)edgeRadius;
        sideLength /= 2.0f;
        RenderUtil.start();
        if (color != null) {
            RenderUtil.color(color);
        }
        if (bottomLeft) {
            GL11.glEnable(2848);
            RenderUtil.begin(6);
            i = 90.0;
            while (i <= 180.0) {
                angle = i * (Math.PI * 2) / 360.0;
                RenderUtil.vertex(x + (double)sideLength * Math.cos(angle) + (double)sideLength, y + height + (double)sideLength * Math.sin(angle));
                i += 1.0;
            }
            RenderUtil.vertex(x + (double)sideLength, y + height);
            RenderUtil.end();
            GL11.glDisable(2848);
            RenderUtil.stop();
        } else {
            RenderUtil.rect(x, y + height, (double)sideLength, (double)sideLength, color);
        }
        RenderUtil.rect(x + halfRadius, y + halfRadius, width - halfRadius, height - halfRadius, color);
        RenderUtil.rect(x, y + halfRadius, edgeRadius / 2.0, height - halfRadius, color);
        RenderUtil.rect(x + width, y + halfRadius, edgeRadius / 2.0, height - halfRadius, color);
        RenderUtil.rect(x + halfRadius, y, width - halfRadius, halfRadius, color);
        RenderUtil.rect(x + halfRadius, y + height, width - halfRadius, halfRadius, color);
    }

    public static void roundedRectTop(double x, double y, double width, double height, double edgeRadius, Color color) {
        double halfRadius = edgeRadius / 2.0;
        RenderUtil.circle(x, y, edgeRadius, color);
        RenderUtil.circle(x + (width -= halfRadius) - edgeRadius / 2.0, y, edgeRadius, color);
        RenderUtil.rect(x, y + halfRadius, width + halfRadius, height -= halfRadius, color);
        RenderUtil.rect(x + halfRadius, y, width - halfRadius, halfRadius, color);
    }

    public static void roundedRectBottom(double x, double y, double width, double height, double edgeRadius, Color color) {
        double halfRadius = edgeRadius / 2.0;
        RenderUtil.circle(x + (width -= halfRadius) - edgeRadius / 2.0, y + (height -= halfRadius) - edgeRadius / 2.0, edgeRadius, color);
        RenderUtil.circle(x, y + height - edgeRadius / 2.0, edgeRadius, color);
        RenderUtil.rect(x, y, width + halfRadius, height, color);
        RenderUtil.rect(x + halfRadius, y + height, width - halfRadius, halfRadius, color);
    }

    public static void roundedRectRight(double x, double y, double width, double height, double edgeRadius, Color color1, Color color2) {
        double halfRadius = edgeRadius / 2.0;
        RenderUtil.circle(x + (width -= halfRadius) - edgeRadius / 2.0, y, edgeRadius, color2);
        RenderUtil.circle(x + width - edgeRadius / 2.0, y + (height -= halfRadius) - edgeRadius / 2.0, edgeRadius, color2);
        RenderUtil.gradientSideways(x, y, width, height + halfRadius, color1, color2);
        RenderUtil.rect(x + width, y + halfRadius, 5.0, height - halfRadius, color2);
    }

    public static void roundedRectRightTop(double x, double y, double width, double height, double edgeRadius, Color color1, Color color2) {
        double halfRadius = edgeRadius / 2.0;
        RenderUtil.circle(x + (width -= halfRadius) - edgeRadius / 2.0, y, edgeRadius, color2);
        RenderUtil.gradientSideways(x, y, width, (height -= halfRadius) + halfRadius, color1, color2);
        RenderUtil.rect(x + width, y + halfRadius, 5.0, height, color2);
    }

    public static void roundedRectRightBottom(double x, double y, double width, double height, double edgeRadius, Color color1, Color color2) {
        double halfRadius = edgeRadius / 2.0;
        RenderUtil.circle(x + (width -= halfRadius) - edgeRadius / 2.0, y + (height -= halfRadius) - edgeRadius / 2.0, edgeRadius, color2);
        RenderUtil.gradientSideways(x, y, width, height + halfRadius, color1, color2);
        RenderUtil.rect(x + width, y, 5.0, height, color2);
    }

    public static void drawBorder(float x, float y, float x2, float y2, float width, int color1) {
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        RenderUtil.color(new Color(color1));
        GL11.glLineWidth(width);
        RenderUtil.glBegin(2);
        GL11.glVertex2d(x2, y);
        GL11.glVertex2d(x, y);
        GL11.glVertex2d(x, y2);
        GL11.glVertex2d(x2, y2);
        RenderUtil.glEnd();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
    }

    public static void drawTracerLine(double x, double y, double z, float red, float green, float blue, float alpha, float lineWdith) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glEnable(2848);
        GL11.glDisable(2929);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3042);
        GL11.glLineWidth(lineWdith);
        GL11.glColor4f(red, green, blue, alpha);
        GL11.glBegin(2);
        GL11.glVertex3d(0.0, 1.62f, 0.0);
        GL11.glVertex3d(x, y, z);
        GL11.glEnd();
        GL11.glDisable(3042);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }

    public static void color4f(float red, float green, float blue, float alpha) {
        GL11.glColor4f(red, green, blue, alpha);
    }

    public static void lineWidth(float width) {
        GL11.glLineWidth(width);
    }

    public static void glBegin(int mode) {
        GL11.glBegin(mode);
    }

    public static void glEnd() {
        GL11.glEnd();
    }

    public static void putVertex3d(double x, double y, double z) {
        GL11.glVertex3d(x, y, z);
    }

    public static void drawCircle(int x, int y, double r, float f1, float f2, float f3, float f) {
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(f1, f2, f3, f);
        GL11.glBegin(2);
        int i = 0;
        while (i <= 360) {
            double x2 = Math.sin((double)i * Math.PI / 180.0) * r;
            double y2 = Math.cos((double)i * Math.PI / 180.0) * r;
            GL11.glVertex2d((double)x + x2, (double)y + y2);
            ++i;
        }
        GL11.glEnd();
        GL11.glDisable(2848);
        GL11.glEnable(3553);
        GL11.glDisable(3042);
    }

    public static void drawFilledCircle(int x, int y, double r, int c) {
        float f = (float)(c >> 24 & 0xFF) / 255.0f;
        float f1 = (float)(c >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(c >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(c & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(f1, f2, f3, f);
        GL11.glBegin(6);
        int i = 0;
        while (i <= 360) {
            double x2 = Math.sin((double)i * Math.PI / 180.0) * r;
            double y2 = Math.cos((double)i * Math.PI / 180.0) * r;
            GL11.glVertex2d((double)x + x2, (double)y + y2);
            ++i;
        }
        GL11.glEnd();
        GL11.glDisable(2848);
        GL11.glEnable(3553);
        GL11.glDisable(3042);
    }

    public static void drawFilledCircle(int x, int y, double r, int c, int quality) {
        float f = (float)(c >> 24 & 0xFF) / 255.0f;
        float f1 = (float)(c >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(c >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(c & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(f1, f2, f3, f);
        GL11.glBegin(6);
        int i = 0;
        while (i <= 360 / quality) {
            double x2 = Math.sin((double)(i * quality) * Math.PI / 180.0) * r;
            double y2 = Math.cos((double)(i * quality) * Math.PI / 180.0) * r;
            GL11.glVertex2d((double)x + x2, (double)y + y2);
            ++i;
        }
        GL11.glEnd();
        GL11.glDisable(2848);
        GL11.glEnable(3553);
        GL11.glDisable(3042);
    }

    public static void drawFilledCircle(double x, double y, double r, int c, int quality) {
        float f = (float)(c >> 24 & 0xFF) / 255.0f;
        float f1 = (float)(c >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(c >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(c & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(f1, f2, f3, f);
        GL11.glBegin(6);
        int i = 0;
        while (i <= 360 / quality) {
            double x2 = Math.sin((double)(i * quality) * Math.PI / 180.0) * r;
            double y2 = Math.cos((double)(i * quality) * Math.PI / 180.0) * r;
            GL11.glVertex2d(x + x2, y + y2);
            ++i;
        }
        GL11.glEnd();
        GL11.glDisable(2848);
        GL11.glEnable(3553);
        GL11.glDisable(3042);
    }

    public static void drawFilledCircleNoGL(int x, int y, double r, int c) {
        float f = (float)(c >> 24 & 0xFF) / 255.0f;
        float f1 = (float)(c >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(c >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(c & 0xFF) / 255.0f;
        GL11.glColor4f(f1, f2, f3, f);
        GL11.glBegin(6);
        int i = 0;
        while (i <= 18) {
            double x2 = Math.sin((double)(i * 20) * Math.PI / 180.0) * r;
            double y2 = Math.cos((double)(i * 20) * Math.PI / 180.0) * r;
            GL11.glVertex2d((double)x + x2, (double)y + y2);
            ++i;
        }
        GL11.glEnd();
    }

    public static void drawFilledCircleNoGL(int x, int y, double r, int c, int quality) {
        float f = (float)(c >> 24 & 0xFF) / 255.0f;
        float f1 = (float)(c >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(c >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(c & 0xFF) / 255.0f;
        GL11.glColor4f(f1, f2, f3, f);
        GL11.glBegin(6);
        int i = 0;
        while (i <= 360 / quality) {
            double x2 = Math.sin((double)(i * quality) * Math.PI / 180.0) * r;
            double y2 = Math.cos((double)(i * quality) * Math.PI / 180.0) * r;
            GL11.glVertex2d((double)x + x2, (double)y + y2);
            ++i;
        }
        GL11.glEnd();
    }

    public static void quickDrawRect(float x, float y, float x2, float y2, int color) {
        RenderUtil.glColor(color);
        RenderUtil.glBegin(7);
        GL11.glVertex2d(x2, y);
        GL11.glVertex2d(x, y);
        GL11.glVertex2d(x, y2);
        GL11.glVertex2d(x2, y2);
        RenderUtil.glEnd();
    }

    public static void quickDrawBorderedRect(float x, float y, float x2, float y2, float width, int color1, int color2) {
        RenderUtil.quickDrawRect(x, y, x2, y2, color2);
        RenderUtil.glColor(color1);
        GL11.glLineWidth(width);
        RenderUtil.glBegin(2);
        GL11.glVertex2d(x2, y);
        GL11.glVertex2d(x, y);
        GL11.glVertex2d(x, y2);
        GL11.glVertex2d(x2, y2);
        RenderUtil.glEnd();
    }

    private static void glColor(int hex) {
        float alpha = (float)(hex >> 24 & 0xFF) / 255.0f;
        float red = (float)(hex >> 16 & 0xFF) / 255.0f;
        float green = (float)(hex >> 8 & 0xFF) / 255.0f;
        float blue = (float)(hex & 0xFF) / 255.0f;
        RenderUtil.color(red, green, blue, alpha);
    }


    public static void rainbowRectangle(float x, float y, float width, float height, float divider) {
        int i = 0;
        while ((float)i <= width) {
            RenderUtil.rect((double)(x + (float)i), (double)y, 1.0, (double)height, new Color(RenderUtil.getColor((float)i / divider, 0.7f, 1.0f)));
            ++i;
        }
    }

    public static int getColor(float hueoffset, float saturation, float brightness) {
        float speed = 4500.0f;
        float hue = (float)(System.currentTimeMillis() % 4500L) / 4500.0f;
        return Color.HSBtoRGB(hue - hueoffset / 54.0f, saturation, brightness);
    }
}
