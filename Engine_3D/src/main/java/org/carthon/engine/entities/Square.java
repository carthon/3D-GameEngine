package org.carthon.engine.entities;

import lombok.AllArgsConstructor;
import org.carthon.engine.data.structs.Pair;
import org.carthon.engine.data.structs.Vector3;
import org.carthon.engine.render.MeshLoader;

import java.util.Vector;

@AllArgsConstructor
public class Square {
    Vector3 position;
    float width, height;
    // Indices of the vertices that form the triangles (indices must be in groups of 3)
    final int[] indices = {
            0, 1, 2, // Triangle with vertices 0, 1, 2
            2, 3, 0
    };
    // Vertices of the triangle (x, y)
    final Vector3[] vertices = new Vector3[]{
            new Vector3(-0.5f, 0.5f,0f),
            new Vector3(-0.5f, -0.5f,0f),
            new Vector3(0.5f, -0.5f,0f),
            new Vector3(0.5f, 0.5f,0f),
    };
    public Square(float width, float height){
        this.width = width;
        this.height = height;
    }
    public Pair<int[], Vector3[]> getShape() { return new Pair<int[], Vector3[]>(indices, vertices); }
}
