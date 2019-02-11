package ch.travbit.lwjgl.engine;

import ch.travbit.lwjgl.engine.opengl.Mesh;
import org.joml.Vector3f;

public abstract class Entity {

    private Mesh mesh;

    private Vector3f position;

    private boolean isRotating;
    private int rotationAngle;

    public Entity(Mesh mesh) {
        this(mesh, false);
    }

    public Entity(Mesh mesh, boolean isRotating) {
        this.mesh = mesh;
        this.isRotating = isRotating;
        rotationAngle = 0;
        position = new Vector3f();
    }

    public Mesh getMesh() {
        return mesh;
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(float x, float y, float z) {
        position.set(x, y, z);
    }

    public boolean isRotating() {
        return isRotating;
    }

    public void setRotating(boolean rotating) {
        isRotating = rotating;
    }

    public int getRotationAngle() {
        return rotationAngle;
    }

    public void setRotationAngle(int rotationAngle) {
        this.rotationAngle = rotationAngle;
    }

    public void update() {
        if (isRotating) {
            rotationAngle++;

            if (rotationAngle > 360) {
                rotationAngle = 0;
            }
        }
    }

    public void render() {
        mesh.render();
    }
}
