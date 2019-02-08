package ch.travbit.lwjgl.engine.ui;

/**
 * This enum represents colors in the rgba format.
 */
public enum RgbaColor {
    BLACK(0f, 0f, 0f, 1f), WHITE(1f, 1f, 1f, 1f);

    public float r, g, b, a;

    RgbaColor(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }
}
