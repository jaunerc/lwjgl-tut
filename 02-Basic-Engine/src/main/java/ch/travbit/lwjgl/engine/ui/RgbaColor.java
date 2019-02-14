package ch.travbit.lwjgl.engine.ui;

import org.joml.Vector4f;

/**
 * This enum represents colors in the rgba format.
 */
public class RgbaColor {
    public final static RgbaColor BLACK = new RgbaColor(0, 0, 0, 1);
    public final static RgbaColor WHITE = new RgbaColor(1, 1, 1, 1);

    private float r, g, b, a;

    public RgbaColor() {
        this(BLACK.r, BLACK.g, BLACK.b, BLACK.a);
    }

    public RgbaColor(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public Vector4f asVector() {
        return new Vector4f(r, g, b, a);
    }

    public void set(Vector4f colorVector) {
        setR(colorVector.x);
        setG(colorVector.y);
        setB(colorVector.z);
        setA(colorVector.w);
    }

    public void set(float r, float g, float b, float a) {
        setR(r);
        setG(g);
        setB(b);
        setA(a);
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public float getG() {
        return g;
    }

    public void setG(float g) {
        this.g = g;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }
}
