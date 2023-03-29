package com.aor.journey;

import com.aor.journey.GUI.GUI;
import com.aor.journey.GUI.LanternaGUI;
import com.aor.journey.state.GameState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    GUI gui;
    private final GameState gameState;
    Game() throws IOException, URISyntaxException, FontFormatException {
        gui = new LanternaGUI();
        gameState = new GameState();
    }

    public void run() throws IOException {
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while(gameState.getCurrState() != null) {
            long startTime = System.currentTimeMillis();

            gameState.getCurrState().step(gameState, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
        gui.close();
    }
}
