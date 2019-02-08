package ch.travbit.lwjgl.engine.ui;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11C.glClearColor;
import static org.lwjgl.system.MemoryUtil.NULL;

public class GLFWWindow implements Window {

    private long handle;
    private int width;
    private int height;
    private boolean isResized;
    private String title;

    public GLFWWindow(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
        handle = -1L;
    }

    @Override
    public void init() {
        // Setup an error callback. The default implementation
        // will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err);

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if (!glfwInit())
            throw new IllegalStateException("Unable to initialize GLFW");

        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

        handle = glfwCreateWindow(width, height, title, NULL, NULL);
        if (handle == NULL)
            throw new RuntimeException("Failed to create the GLFW window");

        glfwSetFramebufferSizeCallback(handle, (window, width, height) -> { // window resize
            this.width = width;
            this.height = height;
            this.isResized = true;
        });

        glfwSetKeyCallback(handle, (window, key, scancode, action, mods) -> { // key handle
            if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
                glfwSetWindowShouldClose(window, true); // set the should close boolean to true
            }
        });

        // get the resolution of the primary monitor and center the window on the screen
        GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(handle, (vidmode.width() - width) / 2, (vidmode.height() - height) / 2);

        glfwMakeContextCurrent(handle); // make the OpenGL context current
        enablevSync(); // enable v-sync

        GL.createCapabilities();

        glfwShowWindow(handle); // make the window visible

        RgbaColor clearColor = RgbaColor.WHITE;
        glClearColor(clearColor.r, clearColor.g, clearColor.b, clearColor.a);
    }

    private void enablevSync() {
        glfwSwapInterval(1);
    }

    @Override
    public void update() {
        glfwSwapBuffers(handle);
        glfwPollEvents();
    }

    @Override
    public void setClearColor(RgbaColor color) {
        glClearColor(color.r, color.g, color.b, color.a);
    }

    @Override
    public boolean shouldClose() {
        return glfwWindowShouldClose(handle);
    }

    @Override
    public boolean isResized() {
        return isResized;
    }

    @Override
    public boolean isKeyPressed(int keyCode) {
        return glfwGetKey(handle, keyCode) == GLFW_PRESS;
    }
}
