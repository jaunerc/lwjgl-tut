package ch.travbit.lwjgl.shapes;

import ch.travbit.lwjgl.engine.Entity;
import ch.travbit.lwjgl.engine.opengl.Mesh;
import ch.travbit.lwjgl.engine.opengl.variables.Attribute;
import ch.travbit.lwjgl.engine.opengl.variables.Loader;
import ch.travbit.lwjgl.engine.ui.RgbaColor;

import static org.lwjgl.opengl.GL11.GL_FLOAT;

/**
 * This class represents a factory for shapes objects.
 */
public class ShapeFactory {

    private final static String VERTEX_ATTRIB_NAME = "aVertexPosition";
    private final static String COLOR_ATTRIB_NAME = "aVertexColor";

    private Attribute posAttribute;
    private Attribute colorAttribute;

    public ShapeFactory(int programId) {
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

    /**
     * Creates a rectangle with the given color list.
     * @param colors a list of colors for each vertex.
     * @return a rectangle object.
     */
    private Entity createColoredRectangle(float[] colors) {
        Mesh mesh = new Mesh(posAttribute, colorAttribute);
        return new Rectangle(mesh, false, colors);
    }

    /**
     * Creates a circle with the default values. There are enough points to create a smooth circle line.
     * @return a circle object.
     */
    public Entity createCircle() {
        Mesh mesh = new Mesh(posAttribute, colorAttribute);
        return new Circle(mesh, 32);
    }

    /**
     * Creates a blue circle.
     * @return a circle object
     */
    public Entity createBlueCircle() {
        Mesh mesh = new Mesh(posAttribute, colorAttribute);
        return new Circle(mesh, 32, new RgbaColor(0, 0, 1, 1));
    }

    /**
     * Creates a yellow hexagon. This is just a circle with only 6 points.
     * @return a hexagon
     */
    public Entity createYellowHexagon() {
        Mesh mesh = new Mesh(posAttribute, colorAttribute);
        return new Circle(mesh, 6, new RgbaColor(1, 1, 0, 1));

    }
}
