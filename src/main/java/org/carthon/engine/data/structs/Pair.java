package org.carthon.engine.data.structs;

public class Pair <T, R> {
    T key;
    R value;
    public Pair(T key, R value){
        this.key = key;
        this.value = value;
    }
    public R getValue() {
        return value;
    }

    public T getKey() {
        return key;
    }
}
