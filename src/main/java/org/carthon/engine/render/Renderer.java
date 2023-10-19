package org.carthon.engine.render;

import org.carthon.engine.entities.Entity;
import org.carthon.engine.environment.Scene;
import org.carthon.utils.Utils;

import static org.lwjgl.opengl.GL11.*;

public class Renderer {
    ShaderProgram shaderProgram;

    public void init() throws Exception {
        shaderProgram = new ShaderProgram();
        shaderProgram.createVertexShader(Utils.loadResourceRaw("shaders/default/vertex.vs"));
        shaderProgram.createFragmentShader(Utils.loadResourceRaw("shaders/default/fragment.fs"));
        shaderProgram.link();
        shaderProgram.createUniform("projectionMatrix");
        shaderProgram.createUniform("worldMatrix");
    }
    public void prepare(){
        glClearColor(1,0,0,1);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }
    public void render(Scene scene){
        shaderProgram.bind();
        shaderProgram.setUniform("projectionMatrix", scene.getActiveCamera().getViewMatrix());
        for (Entity entity: scene.getEntities()){
            shaderProgram.setUniform("worldMatrix", entity.transform.getWorldMatrix());
            entity.getModel().render();
        }
        shaderProgram.unbind();
    }
}
