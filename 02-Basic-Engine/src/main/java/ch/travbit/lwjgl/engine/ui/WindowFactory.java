package ch.travbit.lwjgl.engine.ui;

public class WindowFactory {

    private WindowFactory() {}

    public static Window createBasicWindow() {
        return new GLFWWindow(800, 800, "Basic window");
    }
}
