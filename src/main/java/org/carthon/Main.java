package org.carthon;

import org.carthon.engine.GameEngine;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        try {
            gameEngine.start();
        } catch (Exception e) {
            throw new RuntimeException("Engine exception: " + e);
        }

        // Vertices of the triangle (x, y)
        final float[] vertices = {
                -0.5f, 0.5f,    // Vertex 0
                -0.5f, -0.5f,   // Vertex 1
                0.5f, -0.5f,    // Vertex 2
                0.5f, 0.5f      // Vertex 3
        };
        final int[] indices = {
                0, 1, 2, // Triangle with vertices 0, 1, 2
                2, 3, 0
        };
    }
}