package ch.travbit.lwjgl.geometry;

import ch.travbit.lwjgl.engine.Entity;
import ch.travbit.lwjgl.engine.opengl.Mesh;
import ch.travbit.lwjgl.engine.opengl.variables.Attribute;
import ch.travbit.lwjgl.engine.opengl.variables.Loader;

import static org.lwjgl.opengl.GL11.GL_FLOAT;

/**
 * This class represents a factory for geometry objects.
 */
public class GeometryFactory {

    private final static String VERTEX_ATTRIB_NAME = "aVertexPosition";
    private final static String COLOR_ATTRIB_NAME = "aVertexColor";

    private Attribute posAttribute;
    private Attribute colorAttribute;

    public GeometryFactory(int programId) {
        Loader loader = new Loader(programId);
        posAttribute = loader.loadAttribute(VERTEX_ATTRIB_NAME, GL_FLOAT, 2);
        colorAttribute = loader.loadAttribute(COLOR_ATTRIB_NAME, GL_FLOAT, 4);
    }

    /**
     * Creates a simple rectangle with default values.
     * @return rectangle object
     */
    public Entity createRectangle() {
        Mesh mesh = new Mesh(posAttribute, colorAttribute);
        return new Rectangle(mesh);
    }

    /**
     * Creates a green rectangle.
     * @return a rectangle object
     */
    public Entity createGreenRectangle() {
        float[] greenColors = {
                0, 1, 0, 1,
                0, 1, 0, 1,
                0, 1, 0, 1,
                0, 1, 0, 1
        };
        return createColoredRectangle(greenColors);
    }

    /**
     * Creates a rectangle with a different color for each vertex.
     * @return a rectangle object
     */
    public Entity createDiffColoredRectangle() {
        float[] colors = {
                1, 0, 0, 1,
                0, 1, 0, 1,
                0, 0, 1, 1,
                1, 1, 1, 1
        };
        return createColoredRectangle(colors);
    }

    private Entity createColoredRectangle(float[] colors) {
        Mesh mesh = new Mesh(posAttribute, colorAttribute);
        return new Rectangle(mesh, false, colors);
    }

    public Entity createSolidCircle() {
        Mesh mesh = new Mesh(posAttribute, colorAttribute);
        return new Circle(mesh, 32);
    }
}
