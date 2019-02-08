package ch.travbit.lwjgl.engine.opengl.variables;

public abstract class Uniform<T> {

    private int id;

    public Uniform(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void bind(T value);
}
