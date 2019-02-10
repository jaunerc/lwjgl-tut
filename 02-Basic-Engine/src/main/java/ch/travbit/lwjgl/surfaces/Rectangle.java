package ch.travbit.lwjgl.surfaces;

import ch.travbit.lwjgl.engine.Entity;
import ch.travbit.lwjgl.engine.opengl.Mesh;

public class Rectangle extends Entity {

    private final static float[] vertices = new float[] {
            -0.5f, -0.5f,
            0.5f, -0.5f,
            0.5f, 0.5f,
            -0.5f, 0.5f,
    };

    private final static int[] indices = new int[] {
            0, 1,
            1, 2,
            2, 3,
            3, 0
    };

    public Rectangle(Mesh mesh) {
        super(mesh);
        mesh.storeBuffers(vertices, indices);
    }

    @Override
    public void update() {
        // no updates at the moment
    }
}
