package org.carthon.engine.data.structs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vector3 {
    float x = 0, y = 0, z = 0;

    public Vector3 add(Vector3 b){
        return new Vector3(x + b.x, y + b.y, z + b.z);
    }
    public Vector3 subtract(Vector3 b){
        return new Vector3(x - b.x, y - b.y, z - b.z);
    }
    public Vector3 mul(Vector3 b){
        return new Vector3(x * b.x, y * b.y, z * b.z);
    }
    public float[] toFloats() { return new float[] { x, y, z }; }
}
