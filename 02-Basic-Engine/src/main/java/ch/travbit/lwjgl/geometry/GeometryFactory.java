package ch.travbit.lwjgl.geometry;

import ch.travbit.lwjgl.engine.Entity;
import ch.travbit.lwjgl.engine.opengl.Mesh;
import ch.travbit.lwjgl.engine.opengl.variables.Attribute;
import ch.travbit.lwjgl.engine.opengl.variables.Loader;

import static org.lwjgl.opengl.GL11.GL_FLOAT;

public class GeometryFactory {

    private final static String VERTEX_ATTRIB_NAME = "aVertexPosition";

    private Attribute posAttribute;

    public GeometryFactory(int programId) {
        Loader loader = new Loader(programId);
        posAttribute = loader.loadAttribute(VERTEX_ATTRIB_NAME, GL_FLOAT, 2);
    }

    public Entity createRectangle() {
        Mesh mesh = new Mesh(posAttribute);
        return new Rectangle(mesh);
    }
}
