package org.carthon.engine;

import org.carthon.engine.data.structs.Vector3;
import org.carthon.engine.entities.Cube;
import org.carthon.engine.entities.Quad;
import org.carthon.engine.environment.SceneManager;
import org.carthon.engine.render.Display;
import org.carthon.engine.render.MeshLoader;
import org.carthon.engine.render.Renderer;
import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;

import static org.carthon.engine.render.DisplayManager.initDisplay;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glViewport;

public class GameEngine implements Runnable{
    public static MeshLoader Loader;
    public static Renderer Renderer;
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
        Loader = new MeshLoader();
        Renderer = new Renderer();
        sceneManager = new SceneManager();
        Quad square = new Quad(new Vector3(1.5f,1.5f,-3f), 2,1);
        Cube cube = new Cube(new Vector3(0,0,-5f), 2,1);
        sceneManager.getScene(0).addEntity(square);
        sceneManager.getScene(0).addEntity(cube);
        Renderer.init();
    }
    public void gameLoop(){
        while(!glfwWindowShouldClose(display.getDisplayId())){
            glViewport(0, 0, display.getWidth(), display.getHeight());
            Renderer.prepare();
            Renderer.render(sceneManager.getScene(0));
            display.updateDisplay();
        }
    }
    public void end(){
        display.destroy();
        Loader = null;
        Renderer = null;
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
