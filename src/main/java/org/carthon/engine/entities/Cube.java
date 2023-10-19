package org.carthon.engine.entities;

import org.carthon.engine.data.structs.Vector3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Cube extends Entity{
    enum Faces {
        TOP, BOTTOM, FRONT, BACK, LEFT, RIGHT
    }
    int width, height;
    float[] vertices = new float[]{
            // VO
            -0.5f, 0.5f, 0.5f,
            // V1
            -0.5f, -0.5f, 0.5f,
            // V2
            0.5f, -0.5f, 0.5f,
            // V3
            0.5f, 0.5f, 0.5f,
            // V4
            -0.5f, 0.5f, -0.5f,
            // V5
            0.5f, 0.5f, -0.5f,
            // V6
            -0.5f, -0.5f, -0.5f,
            // V7
            0.5f, -0.5f, -0.5f,
    };
    float[] colors = new float[]{
            0.5f, 0.0f, 0.0f,
            0.0f, 0.5f, 0.0f,
            0.0f, 0.0f, 0.5f,
            0.0f, 0.5f, 0.5f,
            0.5f, 0.0f, 0.0f,
            0.0f, 0.5f, 0.0f,
            0.0f, 0.0f, 0.5f,
            0.0f, 0.5f, 0.5f,
    };
    int[] indices = new int[]{
            // Front face
            0, 1, 3, 3, 1, 2,
            // Top Face
            4, 0, 3, 5, 4, 3,
            // Right face
            3, 2, 7, 5, 3, 7,
            // Left face
            6, 1, 0, 6, 0, 4,
            // Bottom face
            2, 1, 6, 2, 6, 7,
            // Back face
            7, 6, 4, 7, 4, 5,
    };
    public Cube(Vector3 position, int width, int height){
        this.transform.setPosition(position);
        this.transform.setRotation(new Vector3(3,20,3));
        this.width = width;
        this.height = height;
        vertices[2] *= width;
        vertices[3] *= width;
        vertices[7] *= width;
        vertices[5] *= width;
        vertices[0] *= height;
        vertices[4] *= height;
        vertices[3] *= height;
        vertices[5] *= height;
        loadModel(indices, vertices, colors);
    }
}
