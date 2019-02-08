package ch.travbit.lwjgl;

import ch.travbit.lwjgl.engine.Engine;
import ch.travbit.lwjgl.engine.Game;
import ch.travbit.lwjgl.engine.ui.Window;
import ch.travbit.lwjgl.engine.ui.WindowFactory;

public class Main {

    private Main() {}

    public static void main(String[] args) {
        Game pseudo = new PseudoGame();
        Window window = WindowFactory.createBasicWindow();
        Engine engine = new Engine(pseudo, window);

        engine.start();
    }
}
