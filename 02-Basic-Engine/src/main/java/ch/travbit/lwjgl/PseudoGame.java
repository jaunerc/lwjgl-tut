package ch.travbit.lwjgl;

import ch.travbit.lwjgl.engine.Entity;
import ch.travbit.lwjgl.engine.Game;
import ch.travbit.lwjgl.engine.opengl.variables.Loader;
import ch.travbit.lwjgl.engine.opengl.variables.Uniform;
import ch.travbit.lwjgl.geometry.GeometryFactory;
import org.joml.Matrix3f;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL20.glGetUniformLocation;

public class PseudoGame implements Game {

    private List<Entity> rects;

    private Uniform<Matrix3f> transformMat;
    private Uniform<Matrix3f> projectionMat;


    public PseudoGame() {
        rects = new ArrayList<>();
    }

    @Override
    public void init(int programId) {
        Loader loader = new Loader(programId);
        projectionMat = loader.loadUniformMatrix3("uProjectionMat");
        transformMat = loader.loadUniformMatrix3("uTransformMat");

        GeometryFactory factory = new GeometryFactory(programId);

        Entity rectangleA = factory.createDiffColoredRectangle();
        rectangleA.setRotating(true);
        rectangleA.setPosition(2, 0, 0);

        Entity rectangleB = factory.createGreenRectangle();
        rectangleB.setRotating(true);
        rectangleB.setPosition(-2, 1, 0);

        rects.add(rectangleA);
        rects.add(rectangleB);
    }

    @Override
    public void render() {
        Matrix3f projection = new Matrix3f();
        int screenWidth = 300;
        int screenHeight = 300;
        float invAspect = (float) screenWidth / screenHeight;

        projection.scaling(0.25f*invAspect);
        projectionMat.bind(projection);

        rects.forEach(rect -> {
            rect.update();
            Matrix3f transform = new Matrix3f();
            Matrix3f translationMat = create2dTranslationMat(rect.getPosition());
            transform.rotateZ((float) Math.toRadians(rect.getRotationAngle()))
                .mulLocal(translationMat);
            transformMat.bind(transform);
            rect.render();
        });
    }

    private Matrix3f create2dTranslationMat(Vector3f translation) {
        Matrix3f translationMat = new Matrix3f().identity();
        translationMat.setColumn(2, translation);
        return translationMat;
    }
}
