package ch.travbit.lwjgl.engine.opengl.variables;

/**
 * This class represents a glsl uniform.
 * @param <T> the type of data that is bind to the uniform.
 */
public abstract class Uniform<T> {

    /**
     * the uniform location id
     */
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

    /**
     * Binds the given value to the uniform. This method must be implemented with an OpenGL command.
     * @param value the value to bind to the uniform
     */
    public abstract void bind(T value);
}
