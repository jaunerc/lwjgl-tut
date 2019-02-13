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
     * Creates a simple rectangle.
     * @return rectangle object
     */
    public Entity createRectangle() {
        Mesh mesh = new Mesh(posAttribute, colorAttribute);
        return new Rectangle(mesh);
    }
}
