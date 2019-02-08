package ch.travbit.lwjgl.basic2d;

import org.joml.Matrix3f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.opengl.GLUtil;
import org.lwjgl.system.Callback;

import java.io.IOException;
import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Window window = new Window();

        GLCapabilities caps;
        Callback debugProc;

        caps = GL.createCapabilities();
        debugProc = GLUtil.setupDebugMessageCallback();

        glClearColor(1.0f, 1.0f, 1.0f, 0.0f);

        int program = GlUtil.createProgram();

        int uTransformMatId = glGetUniformLocation(program, "uTransformMat");
        FloatBuffer matrixBuffer = BufferUtils.createFloatBuffer(9);
        Matrix3f transform = new Matrix3f();
        float angle = 0f;

        Rectangle rectangle = new Rectangle();

        while (!window.shouldClose()) {
            //glfwPollEvents();

            glClear(GL_COLOR_BUFFER_BIT);

            glUseProgram(program);

            float invAspect = (float) 300 / 300;
            transform.scaling(invAspect, 1, 1) // correct the aspect ratio with some scaling
                    .rotateZ(angle * (float) Math.toRadians(45)) // rotate 45 degrees per second
                    .scale(0.5f); // make everything a bit smaller
            // and upload it to the shader
            glUniformMatrix3fv(uTransformMatId, false, transform.get(matrixBuffer));

            rectangle.render(program);

            glUseProgram(0);

            angle += 0.02f;
            if (angle >= 2) {
                angle = 0f;
            }
            window.update();
        }
    }
}
