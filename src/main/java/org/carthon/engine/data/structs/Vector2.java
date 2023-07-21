package org.carthon.engine.data.structs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vector2 {
    float x = 0, y = 0;

    public Vector2 add(Vector2 b){
        return new Vector2(x + b.x, y + b.y);
    }
    public Vector2 subtract(Vector2 b){
        return new Vector2(x - b.x, y - b.y);
    }
    public Vector2 mul(Vector2 b){
        return new Vector2(x * b.x, y * b.y);
    }
    public float[] toFloats() { return new float[] { x, y }; }
}
