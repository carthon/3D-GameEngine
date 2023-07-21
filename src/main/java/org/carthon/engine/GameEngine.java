package org.carthon.engine;

import org.carthon.engine.data.structs.Vector3;
import org.carthon.engine.entities.Square;
import org.carthon.engine.environment.Camera;
import org.carthon.engine.environment.SceneManager;
import org.carthon.engine.render.Display;
import org.carthon.engine.render.MeshLoader;
import org.carthon.engine.render.Renderer;
import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;

import static org.carthon.engine.render.DisplayManager.initDisplay;
import static org.lwjgl.glfw.GLFW.*;

public class GameEngine implements Runnable{
    private Camera camera;
    MeshLoader loader;
    Renderer renderer;
    Display display;
    SceneManager sceneManager;
    private final Thread gameLoopThread;
    public GameEngine(){
        gameLoopThread = new Thread(this, "GAME_LOOP_THREAD");
    }
    public void start(){
        String osName = System.getProperty("os.name");
        if (osName.contains("Mac") ) {
            gameLoopThread.run();
        } else {
            gameLoopThread.start();
        }
    }
    public void init() throws Exception {
        System.out.printf(String.format("LWJGL Version %S\n", Version.getVersion()));
        GLFWErrorCallback.createPrint(System.err).set();

        // Inicializar GLFW
        if (!glfwInit()) {
            throw new RuntimeException("Failed to initialize GLFW");
        }

        display = initDisplay("Game Engine", 1080, 640);
        if(display.getDisplayId() == 0) {
            glfwTerminate();
            throw new RuntimeException(String.format("Failed to create window: %d", display.getDisplayId()));
        }

        camera = new Camera(0,0,0);
        loader = new MeshLoader();
        renderer = new Renderer();
        sceneManager = new SceneManager();
        Square square = new Square(Vector3.ZERO, 1,1);
        sceneManager.getScene(0).addModel(loader.loadToVAO(square.getShape()));
        renderer.init();
    }
    public void gameLoop(){
        while(!glfwWindowShouldClose(display.getDisplayId())){
            renderer.prepare();
            renderer.render(sceneManager.getScene(0));
            display.updateDisplay();
        }
    }
    public void end(){
        display.destroy();
        camera = null;
        loader = null;
        renderer = null;
    }

    @Override
    public void run() {
        try {
            init();
            gameLoop();
        } catch (Exception excp) {
            excp.printStackTrace();
        } finally {
            end();
        }
    }
}
