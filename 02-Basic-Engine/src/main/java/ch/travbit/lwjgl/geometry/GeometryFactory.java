package ch.travbit.lwjgl.geometry;

import ch.travbit.lwjgl.engine.Entity;
import ch.travbit.lwjgl.engine.opengl.Mesh;
import ch.travbit.lwjgl.engine.opengl.variables.Attribute;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL20.glGetAttribLocation;

public class GeometryFactory {

    private final static String VERTEX_ATTRIB_NAME = "aVertexPosition";

    private Attribute posAttribute;

    public GeometryFactory(int programId) {
        int aVertexPositionId = glGetAttribLocation(programId, VERTEX_ATTRIB_NAME);
        posAttribute = new Attribute(aVertexPositionId, GL_FLOAT, 2);
    }

    public Entity createRectangle() {
        Mesh mesh = new Mesh(posAttribute);
        return new Rectangle(mesh);
    }
}
