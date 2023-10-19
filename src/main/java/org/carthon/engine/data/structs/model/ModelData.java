package org.carthon.engine.data.structs.model;

public abstract class ModelData {
    protected int vaoID;
    protected int eboID; //Se encarga de indicar el índice donde se almacena el orden de renderizado de triangulos
    protected int vertexCount;
    public int getVaoID() { return vaoID; }
    public int getEboID() { return eboID; }
    public int getVertexCount() { return vertexCount; }
}
