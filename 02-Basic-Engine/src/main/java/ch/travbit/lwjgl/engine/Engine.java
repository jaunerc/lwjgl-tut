package ch.travbit.lwjgl.engine;

import ch.travbit.lwjgl.engine.opengl.GlProgram;
import ch.travbit.lwjgl.engine.ui.Window;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL20.glUseProgram;

public class Engine {

    private final static Logger LOGGER = LogManager.getLogger();

    private final static String VERTEX_RESOURCE = "VertexShader.vs";
    private final static String FRAGMENT_RESOURCE = "FragmentShader.fs";

    private GlProgram glProgram;

    private Game game;

    private Window window;

    public Engine(Game game, Window window) {
        this.game = game;
        this.window = window;
        glProgram = new GlProgram();
    }

    private void init() throws IOException {
        LOGGER.info("initialize");
        window.init();
        glProgram.create(VERTEX_RESOURCE, FRAGMENT_RESOURCE);
        game.init(glProgram.getProgramId());
    }

    public void start() {
        try {
            init();
            gameLoop();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }

    private void gameLoop() {
        while (!window.shouldClose()) {
            glClear(GL_COLOR_BUFFER_BIT);

            glUseProgram(glProgram.getProgramId());

            game.render();

            glUseProgram(0);

            window.update();
        }
    }

    public void shutdown() {
        LOGGER.info("shutdown engine");
    }
}
