package org.carthon.engine.render;

import lombok.Getter;

import java.util.Objects;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;

@Getter
public class Display {
    long displayId;
    @Getter
    double secsPerFrame = 1.0d / 144.0d;

    public Display(long displayId){
        this.displayId = displayId;
    }
    public void destroy(){
            // Free the window callbacks and destroy the window
            glfwFreeCallbacks(displayId);
            glfwDestroyWindow(displayId);

            // Terminate GLFW and free the error callback
            glfwTerminate();
            Objects.requireNonNull(glfwSetErrorCallback(null)).free();
    }
    public void updateDisplay(){
        glfwSwapBuffers(displayId);
        glfwPollEvents();
    }
}
