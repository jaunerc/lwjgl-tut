package ch.travbit.lwjgl.engine;

import ch.travbit.lwjgl.engine.opengl.Mesh;
import org.joml.Vector3f;

public abstract class Entity {

    private Mesh mesh;

    private Vector3f position;

    public Entity(Mesh mesh) {
        this.mesh = mesh;
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

    public abstract void update();

    public void render() {
        mesh.render();
    }
}
