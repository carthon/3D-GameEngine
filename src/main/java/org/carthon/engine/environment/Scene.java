package org.carthon.engine.environment;

import lombok.EqualsAndHashCode;
import org.carthon.engine.entities.model.ModelData;
import org.carthon.engine.entities.model.Model;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
public class Scene {
    public List<ModelData> models;

    public Scene(){
        models = new ArrayList<>();
    }
    public void addModel(Model model){
        models.add(model);
    }
    public List<ModelData> getModels() {
        return models;
    }
}
