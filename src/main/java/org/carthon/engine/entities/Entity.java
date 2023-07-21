package org.carthon.engine.entities;

import org.carthon.engine.components.Component;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Set;

public class Entity {
    protected HashMap<Type, Component> components;
    protected Set<String> tags;

    protected HashMap<Type, Component> getComponents() { return components; }
    public Component getComponent(Type type) { return components.get(type); }
    public boolean hasTag(String tag) { return tags.contains(tag); }
    public void addTag(String tag) { tags.add(tag); }
    public boolean removeTag(String tag) { return tags.remove(tag); }
}
