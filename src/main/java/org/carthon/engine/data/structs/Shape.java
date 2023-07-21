package org.carthon.engine.data.structs;

import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public class Shape {
    final int[] triangleConfiguration;
    final Vector3[] verticesPosition;
    final Vector3[] colours;

    public int[] getTriangleConfiguration() {
        return triangleConfiguration;
    }

    public Vector3[] getColours() {
        return colours;
    }

    public Vector3[] getVerticesPosition() {
        return verticesPosition;
    }
    public Vector3 getVertexPositionAtIndex(int index) { return verticesPosition[index]; }
    public Vector3 getColourAtIndex(int index) { return (index < colours.length) ? colours[index] : Vector3.ZERO; }
}
