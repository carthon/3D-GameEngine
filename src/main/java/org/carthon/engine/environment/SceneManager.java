package org.carthon.engine.environment;

import java.util.HashMap;

public class SceneManager {
    HashMap<Integer, Scene> scenes;
    int sceneIndex;
    public SceneManager(){
        scenes = new HashMap<>();
        sceneIndex = 0;
        addScene(new Scene());
    }
    public int addScene(Scene scene){
        scenes.put(sceneIndex, scene);
        sceneIndex++;
        return sceneIndex-1;
    }

    public Scene getScene(int index) { return scenes.get(index); }
}
