package org.carthon.engine.render;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;

import java.nio.IntBuffer;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

public class DisplayManager {
    public static Display initDisplay(String title, int width, int height){
        long window;
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

        window = glfwCreateWindow(width, height, title, NULL, NULL);
        if (window == NULL) {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        MemoryStack stack = stackPush();
        IntBuffer pWidth = stack.mallocInt(1);
        IntBuffer pHeight = stack.mallocInt(1);

        glfwGetWindowSize(window, pWidth, pHeight);

        GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());

        assert vidMode != null;
        glfwSetWindowPos(
                window,
                (vidMode.width() - pWidth.get(0)) / 2,
                (vidMode.height() - pHeight.get(0)) / 2
        );

        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
        glfwShowWindow(window);

        GL.createCapabilities();
        return new Display(window);
    }
}
