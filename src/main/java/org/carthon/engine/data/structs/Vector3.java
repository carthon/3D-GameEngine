package org.carthon.engine.data.structs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vector3{
    public float x = 0, y = 0, z = 0;
    public static Vector3 ZERO = new Vector3(0,0,0);
    public static Vector3 ONE = new Vector3(1,1,1);
    public static Vector3 UP = new Vector3(0,1,0);
    public static Vector3 RIGHT = new Vector3(1,0,0);
    public static Vector3 FORWARD = new Vector3(0,0,1);

    public Vector3 add(Vector3 b){
        return new Vector3(x + b.x, y + b.y, z + b.z);
    }
    public Vector3 subtract(Vector3 b){
        return new Vector3(x - b.x, y - b.y, z - b.z);
    }
    public Vector3 mul(Vector3 b){
        return new Vector3(x * b.x, y * b.y, z * b.z);
    }
    public Vector3 mul(float b){ return new Vector3(x * b, y * b, z * b); }
    public Float[] getFloats(){ return new Float[]{x, y, z}; }
}
