package ch.travbit.lwjgl.engine.opengl.variables;

import org.joml.Matrix3f;

import static org.lwjgl.opengl.GL20.glGetAttribLocation;
import static org.lwjgl.opengl.GL20.glGetUniformLocation;

/**
 * This class represents a loader for glsl attributes and uniforms.
 */
public class Loader {

    /**
     * the returned id if a location is not found
     */
    private final static int NOT_FOUND = -1;

    private int program;

    public Loader(int program) {
        this.program = program;
    }

    public Attribute loadAttribute(String name, int dataType, int size) {
        final int id = glGetAttribLocation(program, name);
        if (id == NOT_FOUND) {
            throw new IllegalArgumentException("attribute location for " + name + " not found.");
        }
        return new Attribute(id, dataType, size);
    }

    public Uniform<Matrix3f> loadUniformMatrix3(String name) {
        final int id = glGetUniformLocation(program, name);
        if (id == NOT_FOUND) {
            throw new IllegalArgumentException("uniform location for " + name + " not found.");
        }
        return new UniformMatrix3(id);
    }
}
