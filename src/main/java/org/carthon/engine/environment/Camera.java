package org.carthon.engine.environment;

import org.carthon.engine.data.structs.Matrix4;

public class Camera {
    private float cameraX, cameraY, cameraZ;
    private float yaw;

    public Camera(float x, float y, float z) {
        cameraX = x;
        cameraY = y;
        cameraZ = z;
        yaw = 0.0f; // Ángulo inicial de rotación en el eje y
    }

    public void rotateY(float angle) {
        yaw += angle;
    }

    public Matrix4 getViewMatrix() {
        Matrix4 viewMatrix = new Matrix4();
        viewMatrix.setIdentity();
        viewMatrix.rotateY(yaw);
        viewMatrix.translate(-cameraX, -cameraY, -cameraZ);
        return viewMatrix;
    }
}