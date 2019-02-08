package ch.travbit.lwjgl.engine.opengl;

import org.lwjgl.opengl.GLUtil;
import org.lwjgl.system.Callback;

import java.io.IOException;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL20C.glCreateProgram;

/**
 * This class represents a wrapper to the OpenGL program.
 */
public class GlProgram {

    private int programId;

    private Callback debugProc;

    public GlProgram() {
        programId = -1;
        debugProc = null;
    }

    /**
     * Creates a new OpenGL program. The id to the program is stored in the field programId.
     * @param vertexShaderResource The resource path to the VertexShader
     * @param fragmentShaderResource The resource path to the FragmentShader
     * @throws IOException
     */
    public void create(String vertexShaderResource, String fragmentShaderResource) throws IOException {
        debugProc = GLUtil.setupDebugMessageCallback();

        programId = glCreateProgram();
        int vertexShader = ShaderUtil.createShader(vertexShaderResource, GL_VERTEX_SHADER, null);
        int fragmentShader = ShaderUtil.createShader(fragmentShaderResource, GL_FRAGMENT_SHADER, null);

        glAttachShader(programId, vertexShader);
        glAttachShader(programId, fragmentShader);
        glLinkProgram(programId);

        int linked = glGetProgrami(programId, GL_LINK_STATUS);
        String programLog = glGetProgramInfoLog(programId);
        if (programLog.trim().length() > 0) {
            System.err.println(programLog);
        }
        if (linked == 0) {
            throw new AssertionError("Could not link program");
        }
    }

    public int getProgramId() {
        return programId;
    }
}
