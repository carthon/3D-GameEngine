package org.carthon.engine.entities;

import lombok.Getter;
import lombok.Setter;
import org.carthon.engine.data.structs.Vector3;

public class Quad extends Entity{
    float width, height;
    // Indices of the vertices that form the triangles (indices must be in groups of 3)
    final int[] indices = {
            0, 1, 2, // Triangle with vertices 0, 1, 2
            2, 3, 0
    };
    float[] vertices = new float[] {
            -0.5f, 0.5f, -0.5f,    //left-top
            -0.5f, -0.5f, -0.5f,   //left-bottom
            0.5f, -0.5f, -0.5f,    //right-bottom
            0.5f, 0.5f, -0.5f      //right-top
    };
    @Getter
    @Setter
    float[] colors = new float[]{
            0.5f, 0.0f, 0.0f,
            0.0f, 0.5f, 0.0f,
            0.0f, 0.0f, 0.5f,
            0.0f, 0.5f, 0.5f
    };
    public Quad(Vector3 position, float width, float height) {
        this.transform.setPosition(position);
        this.width = width;
        this.height = height;
        vertices[0] *= width;
        vertices[3] *= width;
        vertices[1] *= height;
        vertices[4] *= height;
        loadModel(indices, vertices, colors);
    }
}
