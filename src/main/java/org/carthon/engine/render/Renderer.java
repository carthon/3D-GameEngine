package org.carthon.engine.render;

import org.carthon.engine.entities.model.ModelData;
import org.carthon.engine.environment.Scene;
import org.carthon.utils.Utils;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL30.glBindVertexArray;

public class Renderer {
    ShaderProgram shaderProgram;

    public void init() throws Exception {
        shaderProgram = new ShaderProgram();
        shaderProgram.createVertexShader(Utils.loadResourceRaw("shaders/default/vertex.vs"));
        shaderProgram.createFragmentShader(Utils.loadResourceRaw("shaders/default/fragment.fs"));
        shaderProgram.link();
    }
    public void prepare(){
        glClearColor(1,0,0,1);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }
    public void render(Scene scene){
        shaderProgram.bind();
        for (ModelData model: scene.getModels()){
            glBindVertexArray(model.getVaoID());
            glEnableVertexAttribArray(0);
            glEnableVertexAttribArray(1);
            glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, model.getEboID());
            glDrawElements(GL_TRIANGLES, model.getVertexCount(), GL_UNSIGNED_INT, 0);
            glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
            glDisableVertexAttribArray(0);
            glDisableVertexAttribArray(1);
            glBindVertexArray(0);
        }
        shaderProgram.unbind();
    }
}
