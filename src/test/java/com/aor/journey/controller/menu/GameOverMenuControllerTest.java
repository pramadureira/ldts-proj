package com.aor.journey.controller.menu;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.menu.GameOverMenu;
import com.aor.journey.state.GameOverMenuState;
import com.aor.journey.state.GameState;
import com.aor.journey.state.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverMenuControllerTest {
    private GameOverMenuController controller;
    private GameState game;
    @BeforeEach
    void setUp() throws IOException {
        GameOverMenu gameOverMenu = new GameOverMenu();
        controller = new GameOverMenuController(gameOverMenu);
        game = new GameState();
        game.setCurrState(new GameOverMenuState(gameOverMenu));
    }

    @Test
    void stepTest() throws IOException {
        controller.step(game, GUI.ACTION.DOWN,1);
        assertEquals(controller.getModel().isSelected(1),controller.getModel().isSelected(controller.getModel().getCurrentEntry()));

        controller.step(game, GUI.ACTION.DOWN,1);
        assertEquals(controller.getModel().isSelected(0),controller.getModel().isSelected(controller.getModel().getCurrentEntry()));
    }
    @Test
    void selectBackTest() throws IOException {
        assertTrue(controller.getModel().isSelectedBack());
        assertFalse(controller.getModel().isSelectedQuit());
        controller.step(game, GUI.ACTION.SELECT,1);
        assertTrue(game.getCurrState() instanceof MainMenuState);
    }
    @Test
    void selectExitTest() throws IOException {
        controller.step(game, GUI.ACTION.DOWN,1);
        assertTrue(controller.getModel().isSelectedQuit());
        assertFalse(controller.getModel().isSelectedBack());
        controller.step(game, GUI.ACTION.SELECT,1);
        assertNull(game.getCurrState());
    }
}
