package ch.travbit.lwjgl.engine.opengl.variables;

import org.joml.Matrix3f;

import static org.lwjgl.opengl.GL20.glGetAttribLocation;
import static org.lwjgl.opengl.GL20.glGetUniformLocation;

public class Loader {

    private final static int NOT_FOUND = -1;

    private int program;

    public Loader(int program) {
        this.program = program;
    }

    public Attribute loadAttribute(String name, int size, int datatype) {
        final int id = glGetAttribLocation(program, name);
        if (id == NOT_FOUND) {
            throw new IllegalArgumentException("attribute location for " + name + " not found.");
        }
        return new Attribute(id, size, datatype);
    }

    public Uniform<Matrix3f> loadUniformMatrix3(String name) {
        final int id = glGetUniformLocation(program, name);
        if (id == NOT_FOUND) {
            throw new IllegalArgumentException("uniform location for " + name + " not found.");
        }
        return new UniformMatrix3(id);
    }
}
