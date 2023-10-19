package org.carthon.engine.environment;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.carthon.engine.entities.Entity;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
public class Scene {
    @Setter
    private List<Entity> entities;
    @Setter
    private Camera activeCamera;

    public Scene(){
        entities = new ArrayList<>();
    }
    public Scene(Camera camera){
        activeCamera = camera;
        entities = new ArrayList<>();
    }
    public void addEntity(Entity entity){
        entities.add(entity);
    }
}
