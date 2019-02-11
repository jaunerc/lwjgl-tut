package ch.travbit.lwjgl;

import ch.travbit.lwjgl.engine.Entity;
import ch.travbit.lwjgl.engine.Game;
import ch.travbit.lwjgl.engine.opengl.Mesh;
import ch.travbit.lwjgl.engine.opengl.variables.Attribute;
import ch.travbit.lwjgl.engine.opengl.variables.Uniform;
import ch.travbit.lwjgl.engine.opengl.variables.UniformMatrix3;
import ch.travbit.lwjgl.geometry.GeometryFactory;
import ch.travbit.lwjgl.geometry.Rectangle;
import org.joml.Matrix3f;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL20.*;

public class PseudoGame implements Game {

    private List<Entity> rects;

    private Uniform<Matrix3f> transformMat;

    public PseudoGame() {
        rects = new ArrayList<>();
    }

    @Override
    public void init(int programId) {
        int transformId = glGetUniformLocation(programId, "uTransformMat");
        transformMat = new UniformMatrix3(transformId);

        GeometryFactory factory = new GeometryFactory(programId);
        Entity rectangle = factory.createRectangle();

        rects.add(rectangle);
    }

    @Override
    public void render() {
        Matrix3f transform = new Matrix3f();

        float invAspect = (float) 300 / 300;
        transform.scaling(invAspect, 1, 1) // correct the aspect ratio with some scaling
                .rotateZ(0.2f * (float) Math.toRadians(45)) // rotate 45 degrees per second
                .scale(0.5f); // make everything a bit smaller
        // and upload it to the shader
        transformMat.bind(transform);

        rects.forEach(Entity::render);
    }
}
