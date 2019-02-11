package ch.travbit.lwjgl.engine.opengl.variables;

import org.joml.Matrix3f;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL20.glUniformMatrix3fv;

/**
 * This class represents a uniform to bind Matrix3f values.
 */
public class UniformMatrix3 extends Uniform<Matrix3f> {

    /**
     * the number of values (=capacity) of a 3x3 matrix
     */
    private final static int THREE_DIMENSION_CAPACITY = 9;

    private static FloatBuffer matrixBuffer = BufferUtils.createFloatBuffer(THREE_DIMENSION_CAPACITY);

    public UniformMatrix3(int id) {
        super(id);
    }

    @Override
    public void bind(Matrix3f value) {
        value.get(matrixBuffer);
        glUniformMatrix3fv(getId(), false, matrixBuffer);
    }
}
