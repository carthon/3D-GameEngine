package org.carthon.engine.entities;

import lombok.Getter;
import org.carthon.engine.GameEngine;
import org.carthon.engine.components.Component;
import org.carthon.engine.components.TransformComponent;
import org.carthon.engine.data.structs.Vector3;
import org.carthon.engine.data.structs.model.Model;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Entity {
    @Getter
    protected Model model;
    protected HashMap<Type, Component> components;
    public TransformComponent transform;
    protected Set<String> tags;

    public Entity() {
        components = new HashMap<>();
        tags = new HashSet<>();
        transform = new TransformComponent();
        components.put(TransformComponent.class, transform);
    }
    public void loadModel(int[] indices, float[] vertices, float[] colours){
        this.model = GameEngine.Loader.loadToVAO(indices, vertices, colours, 3);
    }
    public void loadModel(int[] indices, float[] vertices, float[] colours, int dimensions){
        this.model = GameEngine.Loader.loadToVAO(indices, vertices, colours, dimensions);
    }

    protected HashMap<Type, Component> getComponents() { return components; }
    public Component getComponent(Type type) { return components.get(type); }
    public boolean hasTag(String tag) { return tags.contains(tag); }
    public void addTag(String tag) { tags.add(tag); }
    public boolean removeTag(String tag) { return tags.remove(tag); }
}
