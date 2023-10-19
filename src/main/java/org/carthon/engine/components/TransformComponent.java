package org.carthon.engine.components;

import org.carthon.engine.components.Component;
import org.carthon.engine.data.structs.Vector3;
import org.joml.Matrix4f;

public class TransformComponent extends Component {
    private final Matrix4f projectionMatrix;

    protected Vector3 position;
    protected Vector3 rotation;
    protected float scale;
    protected final Matrix4f worldMatrix;

    public TransformComponent() {
        worldMatrix = new Matrix4f().zero();
        projectionMatrix = new Matrix4f();
        position = Vector3.ZERO;
        rotation = Vector3.ZERO;
        scale = 1f;
    }

    public final Matrix4f getProjectionMatrix(float fov, float width, float height, float zNear, float zFar) {
        float aspectRatio = width / height;
        projectionMatrix.identity();
        projectionMatrix.perspective(fov, aspectRatio, zNear, zFar);
        return projectionMatrix;
    }

    public Matrix4f getWorldMatrix() {
        worldMatrix.identity().translate(position.x, position.y, position.z).
                rotateX((float)Math.toRadians(rotation.x)).
                rotateY((float)Math.toRadians(rotation.y)).
                rotateZ((float)Math.toRadians(rotation.z)).
                scale(scale);
        return worldMatrix;
    }

    public void setPosition(Vector3 position){
        this.position = position;
    }
    public void setRotation(Vector3 rotation){
        this.rotation = rotation;
    }
    public void setScale(float scale){
        this.scale = scale;
    }
}
