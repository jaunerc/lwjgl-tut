package ch.travbit.lwjgl.engine.opengl.variables;

import static org.lwjgl.opengl.GL20.*;

public class Attribute {

    private int id;
    private int datatype;
    private int size;

    public Attribute(int id, int datatype, int size) {
        this.id = id;
        this.datatype = datatype;
        this.size = size;
    }

    public void enable(boolean enable) {
        if (enable) {
            glEnableVertexAttribArray(id);
        } else {
            glDisableVertexAttribArray(id);
        }
    }

    public void bind() {
        glVertexAttribPointer(id, size, datatype, false, 0, 0);
    }
}
