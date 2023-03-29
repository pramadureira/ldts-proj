package com.aor.journey.controller.menu;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.menu.MainMenu;
import com.aor.journey.state.GameState;
import com.aor.journey.state.HelperMenuState;
import com.aor.journey.state.LobbyState;
import com.aor.journey.state.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MainMenuControllerTest {
    private MainMenuController controller;
    private GameState game;
    @BeforeEach
    void setUp() throws IOException {
        MainMenu mainMenu = new MainMenu();
        controller = new MainMenuController(mainMenu);
        game = new GameState();
        game.setCurrState(new MainMenuState(mainMenu));
    }

    @Test
    void stepTest() throws IOException {
        assertEquals(controller.getModel().isSelected(0),controller.getModel().isSelectedStart());
        assertEquals(controller.getModel().isSelected(1),controller.getModel().isSelectedHelp());
        assertEquals(controller.getModel().isSelected(2),controller.getModel().isSelectedQuit());

        controller.step(game, GUI.ACTION.DOWN,1);
        assertEquals(controller.getModel().isSelected(1),controller.getModel().isSelected(controller.getModel().getCurrentEntry()));

        controller.step(game, GUI.ACTION.UP,1);
        assertEquals(controller.getModel().isSelected(0),controller.getModel().isSelected(controller.getModel().getCurrentEntry()));

        controller.step(game, GUI.ACTION.DOWN,1);
        controller.step(game, GUI.ACTION.DOWN,1);
        assertEquals(controller.getModel().isSelected(2),controller.getModel().isSelected(controller.getModel().getCurrentEntry()));

    }
    @Test
    void selectStartTest() throws IOException {
        assertTrue(controller.getModel().isSelectedStart());
        assertFalse(controller.getModel().isSelectedHelp());
        assertFalse(controller.getModel().isSelectedQuit());

        controller.step(game, GUI.ACTION.SELECT,1);
        assertTrue(game.getCurrState() instanceof LobbyState);
    }
    @Test
    void selectHelpTest() throws IOException {
        controller.step(game, GUI.ACTION.DOWN,1);

        assertFalse(controller.getModel().isSelectedStart());
        assertTrue(controller.getModel().isSelectedHelp());
        assertFalse(controller.getModel().isSelectedQuit());

        controller.step(game, GUI.ACTION.SELECT,1);
        assertTrue(game.getCurrState() instanceof HelperMenuState);
    }
    @Test
    void selectQuitTest() throws IOException {
        controller.step(game, GUI.ACTION.DOWN,1);
        controller.step(game, GUI.ACTION.DOWN,1);

        assertFalse(controller.getModel().isSelectedStart());
        assertFalse(controller.getModel().isSelectedHelp());
        assertTrue(controller.getModel().isSelectedQuit());

        controller.step(game, GUI.ACTION.SELECT,1);
        assertNull(game.getCurrState());
    }

}
