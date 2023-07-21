package org.carthon.engine.entities.model;

import lombok.Getter;
import lombok.Setter;
import org.carthon.engine.data.structs.Vector3;

public class Model extends ModelData {
    @Getter
    @Setter
    private Vector3[] vertex;
    @Getter
    @Setter
    private int[] indices;
    public Model(int vaoID, int eboID, int vertexCount){
        this.vaoID = vaoID;
        this.eboID = eboID;
        this.vertexCount = vertexCount;
    }

}
