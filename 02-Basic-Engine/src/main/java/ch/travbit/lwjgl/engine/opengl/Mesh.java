package ch.travbit.lwjgl.engine.opengl;

import ch.travbit.lwjgl.engine.opengl.variables.Attribute;
import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15C.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;

/**
 * This class represents a collection of buffer information.
 */
public class Mesh {

    private Attribute positionAtr;
    private Attribute colorAtr;
    private int verticesBufferId;
    private int indicesBufferId;
    private int colorsBufferId;

    private int indicesCount;

    public Mesh(Attribute positionAtr, Attribute colorAtr) {
        this.positionAtr = positionAtr;
        this.colorAtr = colorAtr;
        verticesBufferId = -1;
        indicesBufferId = -1;
        colorsBufferId = -1;
        indicesCount = 0;
    }

    /**
     * Saves the given vertices and indices to the OpenGL buffers.
     * @param vertices a list of vertices
     * @param colors a list of rgba colors
     * @param indices a list of indices
     */
    public void storeBuffers(float[] vertices, float[] colors, int[] indices) {
        FloatBuffer verticesBuffer = null;
        FloatBuffer colorsBuffer = null;
        IntBuffer indicesBuffer = null;

        try {
            verticesBufferId = glGenBuffers();
            verticesBuffer = MemoryUtil.memAllocFloat(vertices.length);
            verticesBuffer.put(vertices).flip();
            glBindBuffer(GL_ARRAY_BUFFER, verticesBufferId);
            glBufferData(GL_ARRAY_BUFFER, verticesBuffer, GL_STATIC_DRAW);

            colorsBufferId = glGenBuffers();
            colorsBuffer = MemoryUtil.memAllocFloat(colors.length);
            colorsBuffer.put(colors).flip();
            glBindBuffer(GL_ARRAY_BUFFER, colorsBufferId);
            glBufferData(GL_ARRAY_BUFFER, colorsBuffer, GL_STATIC_DRAW);

            indicesCount = indices.length;

            indicesBufferId = glGenBuffers();
            indicesBuffer = MemoryUtil.memAllocInt(indicesCount);
            indicesBuffer.put(indices).flip();
            glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, indicesBufferId);
            glBufferData(GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL_STATIC_DRAW);
        } finally {
            if (verticesBuffer != null) {
                MemoryUtil.memFree(verticesBuffer);
            }
            if (colorsBuffer != null) {
                MemoryUtil.memFree(colorsBuffer);
            }
            if (indicesBuffer != null) {
                MemoryUtil.memFree(indicesBuffer);
            }
        }
    }

    /**
     * Renders this mesh. This function binds the buffers and invokes a OpenGL draw command.
     */
    public void render() {
        // vertices
        glBindBuffer(GL_ARRAY_BUFFER, verticesBufferId);
        positionAtr.bind();
        positionAtr.enable(true);

        // colors
        glBindBuffer(GL_ARRAY_BUFFER, colorsBufferId);
        colorAtr.bind();
        colorAtr.enable(true);

        // indices
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, indicesBufferId);
        glDrawElements(GL_TRIANGLES, indicesCount, GL_UNSIGNED_INT, 0);

        // Restore state
        positionAtr.enable(false);
        glDisableVertexAttribArray(indicesBufferId);
    }
}
