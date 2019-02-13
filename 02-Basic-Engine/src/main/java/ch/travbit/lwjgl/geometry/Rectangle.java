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

    private final static int[] INDICES = new int[] {
            0, 1, 2,
            0, 3, 2
    };

    public Rectangle(Mesh mesh) {
        this(mesh, false);
    }

    public Rectangle(Mesh mesh, boolean isRotating) {
        super(mesh, isRotating);
        mesh.storeBuffers(VERTICES, INDICES);
    }
}
