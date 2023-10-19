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
    }
}