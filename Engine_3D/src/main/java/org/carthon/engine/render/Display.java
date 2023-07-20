package org.carthon.engine.render;

import lombok.Getter;

import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;

@Getter
public class Display {
    long displayId;

    public Display(long displayId){
        this.displayId = displayId;
    }
    public void updateDisplay(){
        glfwSwapBuffers(displayId);
        glfwPollEvents();
    }
}
