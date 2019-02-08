package ch.travbit.lwjgl.engine.ui;

/**
 * This interface provides methods for a graphical user interface.
 */
public interface Window {

    /**
     * Initializes the window.
     */
    void init();

    /**
     * Updates the window. This method should invoked after each render call.
     */
    void update();

    /**
     * Sets the clear color.
     * @param color clear color in the rgba format.
     */
    void setClearColor(RgbaColor color);

    /**
     * Whether the window should close.
     * @return True, if the window should close.
     */
    boolean shouldClose();

    /**
     * Whether the window is resized.
     * @return True, if the window is resized.
     */
    boolean isResized();

    /**
     * Whether the key with the given code is pressed.
     * @return True, if the corresponding key is pressed.
     */
    boolean isKeyPressed(int keyCode);
}
