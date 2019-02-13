package ch.travbit.lwjgl.geometry;

import ch.travbit.lwjgl.engine.Entity;
import ch.travbit.lwjgl.engine.opengl.Mesh;

public class Rectangle extends Entity {

    private final static float[] VERTICES = new float[] {
            -0.5f, -0.5f,
            0.5f, -0.5f,
            0.5f, 0.5f,
            -0.5f, 0.5f,
    };

    private final static float[] DEFAULT_COLORS = new float[] {
            1, 0, 0, 1,
            1, 0, 0, 1,
            1, 0, 0, 1,
            1, 0, 0, 1
    };

    private final static int[] INDICES = new int[] {
            0, 1, 2,
            0, 3, 2
    };

    public Rectangle(Mesh mesh) {
        this(mesh, false, DEFAULT_COLORS);
    }

    public Rectangle(Mesh mesh, boolean isRotating, float[] colors) {
        super(mesh, isRotating);
        mesh.storeBuffers(VERTICES, colors, INDICES);
    }
}
