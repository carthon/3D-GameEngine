package org.carthon.engine.data.structs;

public class Matrix4 {
    private float[] matrix;

    public Matrix4() {
        matrix = new float[16];
        setIdentity();
    }

    public void setIdentity() {
        for (int i = 0; i < 16; i++) {
            matrix[i] = (i % 5 == 0) ? 1.0f : 0.0f;
        }
    }

    public void multiply(Matrix4 other) {
        float[] result = new float[16];

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                float sum = 0.0f;
                for (int k = 0; k < 4; k++) {
                    sum += matrix[row * 4 + k] * other.matrix[k * 4 + col];
                }
                result[row * 4 + col] = sum;
            }
        }

        matrix = result;
    }

    public void rotateY(float angle) {
        Matrix4 rotationMatrix = new Matrix4();
        float cos = (float) Math.cos(angle);
        float sin = (float) Math.sin(angle);
        rotationMatrix.matrix[0] = cos;
        rotationMatrix.matrix[2] = sin;
        rotationMatrix.matrix[8] = -sin;
        rotationMatrix.matrix[10] = cos;

        multiply(rotationMatrix);
    }

    public void translate(float x, float y, float z) {
        matrix[12] += x;
        matrix[13] += y;
        matrix[14] += z;
    }

    public float[] getMatrix() {
        return matrix;
    }
}
