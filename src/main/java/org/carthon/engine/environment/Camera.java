package org.carthon.engine.environment;

import org.carthon.engine.render.Display;
import org.joml.Matrix4f;

public class Camera {
    private float cameraX, cameraY, cameraZ;
    private float yaw;
    /**
     * Field of View in Radians
     */
    private static final float FOV = (float) Math.toRadians(60.0f);

    private static final float Z_NEAR = 0.01f;

    private static final float Z_FAR = 1000.f;

    private Matrix4f projectionMatrix;
    private Display display;

    public Camera(float x, float y, float z, Display window) {
        cameraX = x;
        cameraY = y;
        cameraZ = z;
        display = window;
        yaw = 0.0f; // Ángulo inicial de rotación en el eje y
        float aspectRatio = (float) window.getWidth() / window.getHeight();
        projectionMatrix = new Matrix4f().perspective(FOV, aspectRatio,
                Z_NEAR, Z_FAR);
    }

    public void rotateY(float angle) {
        yaw += angle;
    }

    public Matrix4f getViewMatrix() {
        return projectionMatrix;
    }
}