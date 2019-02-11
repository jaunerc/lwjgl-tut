package ch.travbit.lwjgl.engine.ui;

/**
 * This class provides a factory to create glfw windows
 */
public class WindowFactory {

    private WindowFactory() {}

    /**
     * Creates a simple squared window with 800x800 pixels.
     * @return the produced window
     */
    public static Window createBasicWindow() {
        return new GLFWWindow(800, 800, "Basic window");
    }
}
