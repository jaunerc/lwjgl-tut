package ch.travbit.lwjgl;

import ch.travbit.lwjgl.engine.Entity;
import ch.travbit.lwjgl.engine.Game;
import ch.travbit.lwjgl.engine.opengl.Mesh;
import ch.travbit.lwjgl.engine.opengl.variables.Attribute;
import ch.travbit.lwjgl.surfaces.Rectangle;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL20.glGetAttribLocation;

public class PseudoGame implements Game {

    private List<Rectangle> rects;

    public PseudoGame() {
        rects = new ArrayList<>();
    }

    @Override
    public void init(int programId) {
        int aVertexPositionId = glGetAttribLocation(programId, "aVertexPosition");
        Attribute posAttribute = new Attribute(aVertexPositionId, GL_FLOAT, 2);

        Mesh mesh = new Mesh(posAttribute);
        Rectangle rectangle = new Rectangle(mesh);

        rects.add(rectangle);
    }

    @Override
    public void render() {
        rects.forEach(Entity::render);
    }
}
