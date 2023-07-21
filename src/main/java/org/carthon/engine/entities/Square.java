package org.carthon.engine.entities;

import org.carthon.engine.data.structs.Pair;
import org.carthon.engine.data.structs.Shape;
import org.carthon.engine.data.structs.Vector3;

public class Square extends Entity{
    Vector3 position;
    float width, height;
    Shape shape;
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
    final Vector3[] colours = new Vector3[]{
            new Vector3(0.5f, 0.0f, 0.0f),
            new Vector3(0.0f, 0.5f, 0.0f),
            new Vector3(0.0f, 0.0f, 0.5f),
            new Vector3(0.0f, 0.5f, 0.5f),
    };
    public Square(Vector3 position, float width, float height){
        this.position = position;
        Init(width, height);
        shape = new Shape(indices, vertices, colours);
    }
    public void Init(float width, float height){
        this.width = width;
        this.height = height;
        for (int i = 0; i < vertices.length; i++){
            vertices[i] = vertices[i].mul(new Vector3(width, height, 0)).add(position);
        }
    }
    public Shape getShape() { return shape; }
}
