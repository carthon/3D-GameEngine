package org.carthon;

import org.carthon.engine.data.structs.Vector3;
import org.carthon.engine.entities.RawModel;
import org.carthon.engine.entities.Square;
import org.carthon.engine.environment.Camera;
import org.carthon.engine.render.Display;
import org.carthon.engine.render.MeshLoader;
import org.carthon.engine.render.Renderer;
import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;

import java.nio.IntBuffer;

import static org.carthon.engine.render.DisplayManager.initDisplay;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryStack.stackPush;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {
    public static void main(String[] args) {
        System.out.printf(String.format("LWJGL Version %S\n", Version.getVersion()));
        GLFWErrorCallback.createPrint(System.err).set();

        // Inicializar GLFW
        if (!glfwInit()) {
            throw new RuntimeException("Failed to initialize GLFW");
        }

        Display display = initDisplay("Title", 1080, 640);
        if(display.getDisplayId() == 0) {
            glfwTerminate();
            throw new RuntimeException(String.format("Failed to create window: %d", display.getDisplayId()));
        }

        MeshLoader loader = new MeshLoader();
        Renderer renderer = new Renderer();

        // Vertices of the triangle (x, y)
        final float[] vertices = {
                -0.5f, 0.5f,    // Vertex 0
                -0.5f, -0.5f,   // Vertex 1
                0.5f, -0.5f,    // Vertex 2
                0.5f, 0.5f      // Vertex 3
        };
        final int[] indices = {
                0, 1, 2, // Triangle with vertices 0, 1, 2
                2, 3, 0
        };

        Camera camera = new Camera(0,0,0);

        //RawModel model = loader.loadToVAO(vertices, indices);
        RawModel model = loader.loadToVAO(new Square(new Vector3(0,0,0), 5, 2).getShape());

        while(!glfwWindowShouldClose(display.getDisplayId())){
            renderer.prepare();
            renderer.render(model);
            display.updateDisplay();
        }
        glfwTerminate();
        System.out.println("GLFW process terminated");
    }
}