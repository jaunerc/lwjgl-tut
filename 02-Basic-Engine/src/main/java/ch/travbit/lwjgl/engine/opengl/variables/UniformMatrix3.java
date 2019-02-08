package ch.travbit.lwjgl.engine.opengl.variables;

import org.joml.Matrix3f;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL20.glUniformMatrix3fv;

public class UniformMatrix3 extends Uniform<Matrix3f> {

    private static FloatBuffer matrixBuffer = BufferUtils.createFloatBuffer(9);

    public UniformMatrix3(int id) {
        super(id);
    }

    @Override
    public void bind(Matrix3f value) {
        value.get(matrixBuffer);
        glUniformMatrix3fv(getId(), false, matrixBuffer);
    }
}
