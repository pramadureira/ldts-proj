package com.aor.journey.viewer.menu;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.Position;
import com.aor.journey.model.menu.GameOverMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GameOverMenuViewerTest {

    private GameOverMenu gameOverMenu;
    private GameOverMenuViewer viewer;
    private GUI gui;

    @BeforeEach
    public void setup() {
        gameOverMenu = new GameOverMenu();
        viewer = new GameOverMenuViewer(gameOverMenu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    public void drawElementsTest() {
        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 5), "You are dead.", "#FFFFFF");
        for (int i = 0; i < gameOverMenu.getNumberEntries(); i++) {
            Mockito.verify(gui, Mockito.times(1)).drawText(
                    new Position(gui.WIDTH/2 - gameOverMenu.getEntry(i).length(), 7 + i), gameOverMenu.getEntry(i),
                    gameOverMenu.isSelected(i) ? "#FF6347" : "#FFFFFF"
            );
        }
    }
}
