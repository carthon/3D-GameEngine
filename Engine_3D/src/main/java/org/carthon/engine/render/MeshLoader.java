package org.carthon.engine.render;

import org.carthon.engine.data.structs.Pair;
import org.carthon.engine.data.structs.Vector3;
import org.carthon.engine.entities.RawModel;
import org.lwjgl.opengl.GL30;
import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glDeleteVertexArrays;

public class MeshLoader {
    private List<Integer> vaos = new ArrayList<Integer>();
    private List<Integer> vbos = new ArrayList<Integer>();
    private List<Integer> ebos = new ArrayList<Integer>();

    public RawModel loadToVAO(Pair<int[], Vector3[]> shape){
        int listSize = shape.getValue().length * 3;
        float[] vertices = new float[listSize];
        for (int i = 0, j = 0; j < listSize; i++){
            Vector3 vertex = shape.getValue()[i];
            vertices[j] = vertex.toFloats()[0];
            vertices[j+1] = vertex.toFloats()[1];
            vertices[j+2] = vertex.toFloats()[2];
            j += 3;
        }

        return loadToVAO(vertices, shape.getKey());
    }
    public RawModel loadToVAO(float[] vertices, int[] indices){
        int vaoID = createVAO();
        storeDataAttributeInList(0, 3, vertices);
        int eboID = bindIndicesInList(indices);
        ebos.add(eboID);
        unbindVAO();
        //Vértices por triángulo
        return new RawModel(vaoID, eboID, indices.length);
    }
    /**
     * Creates a new VAO and returns its ID. A VAO holds geometry data that we
     * can render and is physically stored in memory on the GPU, so that it can
     * be accessed very quickly during rendering.
     *
     * Like most objects in OpenGL, the new VAO is created using a "gen" method
     * which returns the ID of the new VAO. In order to use the VAO it needs to
     * be made the active VAO. Only one VAO can be active at a time. To make
     * this VAO the active VAO (so that we can store stuff in it) we have to
     * bind it.
     *
     * @return The ID of the newly created VAO.
     */
    private int createVAO() {
        int vaoId = GL30.glGenVertexArrays();
        vaos.add(vaoId);
        GL30.glBindVertexArray(vaoId);
        return vaoId;
    }
    public void cleanUpData(){
        for (int vao:vaos){
            glDeleteVertexArrays(vao);
        }
        for (int vbo:vbos){
            glDeleteBuffers(vbo);
        }
        for (int eboID:ebos){
            glDeleteBuffers(eboID);
        }
    }
    private void storeDataAttributeInList(int attributeNumber, int dimensions, float[] data){
        FloatBuffer buffer = storeDataInFloatBuffer(data);

        int vboId = glGenBuffers();
        vbos.add(vboId);

        glBindBuffer(GL_ARRAY_BUFFER, vboId);
        glBufferData(GL_ARRAY_BUFFER, buffer, GL_STATIC_DRAW);
        glVertexAttribPointer(attributeNumber, dimensions, GL_FLOAT, false, 0, 0);
        glBindBuffer(GL_ARRAY_BUFFER, 0); //Unloads current VBO when done
        MemoryUtil.memFree(buffer);
    }
    private int bindIndicesInList(int[] data){
        IntBuffer buffer = storeDataInIntBuffer(data);

        int eboId = glGenBuffers();
        vbos.add(eboId);

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, eboId);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, buffer, GL_STATIC_DRAW);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
        MemoryUtil.memFree(buffer);
        return eboId;
    }
    private void unbindVAO() {
        GL30.glBindVertexArray(0);
    }
    private FloatBuffer storeDataInFloatBuffer(float[] data){
        FloatBuffer buffer = MemoryUtil.memAllocFloat(data.length);
        buffer.put(data).flip();
        return buffer;
    }
    private IntBuffer storeDataInIntBuffer(int[] data){
        IntBuffer buffer = MemoryUtil.memAllocInt(data.length);;
        buffer.put(data).flip();
        return buffer;
    }
}
