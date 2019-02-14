package ch.travbit.lwjgl.geometry;

import ch.travbit.lwjgl.engine.Entity;
import ch.travbit.lwjgl.engine.opengl.Mesh;
import ch.travbit.lwjgl.engine.ui.RgbaColor;

public class Circle extends Entity {

    public Circle(Mesh mesh, int numPoints) {
        this(mesh, numPoints, RgbaColor.BLACK);
    }

    public Circle(Mesh mesh, int numPoints, RgbaColor fillColor) {
        super(mesh);
        float[] vertices = calculateVertices(numPoints);
        int[] indices = calculateIndices(numPoints);
        float[] colors = defineBasicColors(numPoints, fillColor);
        mesh.storeBuffers(vertices, colors, indices);
    }

    private float[] calculateVertices(int numPoints) {
        float[] vertices = new float[numPoints * 2 + 2];
        float angle = 2 * (float) Math.PI / numPoints;

        // set the center of the circle as the first vertex.
        vertices[0] = 0f;
        vertices[1] = 0f;

        float phi = 0;
        for (int i = 0, j = 0; i < numPoints + 1; i++, j+=2) {
            float x = (float) Math.sin(phi);
            float y = (float) Math.cos(phi);
            vertices[j] = x;
            vertices[j+1] = y;
            phi += angle;
        }

        return vertices;
    }

    private int[] calculateIndices(int numPoints) {
        int[] triangles = new int[numPoints * 3 + 3];

        for (int i = 0, j = 0; i < numPoints + 1; i++, j+=3) {
            triangles[j] = 0;
            triangles[j+1] = i-1;
            triangles[j+2] = i;
        }

        return triangles;
    }

    private float[] defineBasicColors(int numPoints, RgbaColor fillColor) {
        float[] colors = new float[numPoints * 4 + 4];

        for (int i = 0; i < numPoints * 4; i+=4) {
            colors[i] = fillColor.getR();
            colors[i+1] = fillColor.getG();
            colors[i+2] = fillColor.getB();
            colors[i+3] = fillColor.getA();
        }
        return colors;
    }
}
