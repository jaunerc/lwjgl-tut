package ch.travbit.lwjgl.engine.opengl.variables;

import static org.lwjgl.opengl.GL20.*;

/**
 * This class represents a glsl attribute.
 */
public class Attribute {

    /**
     * the attribute location id
     */
    private int id;
    /**
     * the glsl data type
     */
    private int dataType;
    /**
     * the size of the payload (e.g. 2 for a 2d vector)
     */
    private int size;

    public Attribute(int id, int dataType, int size) {
        this.id = id;
        this.dataType = dataType;
        this.size = size;
    }

    /**
     * Enables or disables this attribute.
     * @param enable whether the attribute should be enabled or not
     */
    public void enable(boolean enable) {
        if (enable) {
            glEnableVertexAttribArray(id);
        } else {
            glDisableVertexAttribArray(id);
        }
    }

    /**
     * Binds the current values of this attribute to the OpenGL program.
     */
    public void bind() {
        glVertexAttribPointer(id, size, dataType, false, 0, 0);
    }
}
