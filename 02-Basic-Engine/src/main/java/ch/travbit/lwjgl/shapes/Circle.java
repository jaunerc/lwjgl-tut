package ch.travbit.lwjgl.shapes;

import ch.travbit.lwjgl.engine.Entity;
import ch.travbit.lwjgl.engine.opengl.Mesh;
import ch.travbit.lwjgl.engine.ui.RgbaColor;

/**
 * This class represents a circle entity.
 */
public class Circle extends Entity {

    public Circle(Mesh mesh, int numPoints) {
        this(mesh, numPoints, RgbaColor.BLACK);
    }

    public Circle(Mesh mesh, int numPoints, RgbaColor fillColor) {
        super(mesh);
        float[] vertices = calculateVertices(numPoints);
        int[] indices = defineTriangles(numPoints);
        float[] colors = defineFillColors(numPoints, fillColor);
        mesh.storeBuffers(vertices, colors, indices);
    }

    /**
     * Calculates the vertices for this circle. This method generates a list of vertices. Each vertex has two
     * coordinates. These coordinates are consecutive in the list. The first vertex is always the center of the circle.
     * @param numPoints the number of points of the circle
     * @return a list of vertices
     */
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

    /**
     * Defines the indices of the triangles to fill the circle.
     * @param numPoints the number of points of the circle
     * @return a list of triangle indices.
     */
    private int[] defineTriangles(int numPoints) {
        int[] triangles = new int[numPoints * 3 + 3];

        for (int i = 0, j = 0; i < numPoints + 1; i++, j+=3) {
            triangles[j] = 0;
            triangles[j+1] = i-1;
            triangles[j+2] = i;
        }

        return triangles;
    }

    /**
     * Defines the fill color of the circle. The colors are defines for each vertex.
     * @param numPoints the number of points of the circle
     * @param fillColor the fill color of the circle
     * @return a list of rgba colors
     */
    private float[] defineFillColors(int numPoints, RgbaColor fillColor) {
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
