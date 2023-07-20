package org.carthon.engine.entities;

import lombok.Getter;
import lombok.Setter;
import org.carthon.engine.data.structs.Vector3;

public class RawModel extends GameObject{
    @Getter
    @Setter
    private Vector3[] vertex;
    @Getter
    @Setter
    private int[] indices;
    public RawModel(int vaoID, int eboID,int vertexCount){
        this.vaoID = vaoID;
        this.eboID = eboID;
        this.vertexCount = vertexCount;
    }

}
