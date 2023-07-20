package org.carthon.engine.entities;

import org.carthon.engine.data.structs.Vector3;

import java.util.Arrays;
import java.util.List;

public abstract class GameObject {
    protected int vaoID;
    protected int eboID; //Se encarga de indicar el índice donde se almacena el orden de renderizado de triangulos
    protected int vertexCount;
    public int getVaoID() { return vaoID; }
    public int getEboID() { return eboID; }
    public int getVertexCount() { return vertexCount; }
}
