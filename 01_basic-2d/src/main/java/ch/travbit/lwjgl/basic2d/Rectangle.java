package ch.travbit.lwjgl.basic2d;

import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.ARBVertexArrayObject.glBindVertexArray;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15C.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30C.glGenVertexArrays;

public class Rectangle {

    private float[] vertices;
    private int[] lines;

    private int posVboId;
    private int linVboId;

    public Rectangle() {
        vertices = new float[] {
                -0.5f, -0.5f,
                0.5f, -0.5f,
                0.5f, 0.5f,
                -0.5f, 0.5f,
        };

        lines = new int[] {
                0, 1,
                1, 2,
                2, 3,
                3, 0
        };

        storeBuffers();
    }

    private void storeBuffers() {
        FloatBuffer positionBuffer = null;
        IntBuffer lineBuffer = null;


        posVboId = glGenBuffers();
        positionBuffer = MemoryUtil.memAllocFloat(vertices.length);
        positionBuffer.put(vertices).flip();
        glBindBuffer(GL_ARRAY_BUFFER, posVboId);
        glBufferData(GL_ARRAY_BUFFER, positionBuffer, GL_STATIC_DRAW);

        linVboId = glGenBuffers();
        lineBuffer = MemoryUtil.memAllocInt(lines.length);
        lineBuffer.put(lines).flip();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, linVboId);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, lineBuffer, GL_STATIC_DRAW);

    }

    public void render(int program) {
        int aVertexPositionId = glGetAttribLocation(program, "aVertexPosition");

        // Draw
        glBindBuffer(GL_ARRAY_BUFFER, posVboId);
        glVertexAttribPointer(aVertexPositionId, 2, GL_FLOAT, false, 0, 0);
        glEnableVertexAttribArray(aVertexPositionId);

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, linVboId);
        glDrawElements(GL_LINES, 8, GL_UNSIGNED_INT, 0);

        // Restore state
        glDisableVertexAttribArray(posVboId);
        glDisableVertexAttribArray(linVboId);
    }
}
