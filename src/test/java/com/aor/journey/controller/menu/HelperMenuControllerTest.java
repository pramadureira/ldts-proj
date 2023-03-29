package com.aor.journey.controller.menu;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.menu.HelperMenu;
import com.aor.journey.state.GameState;
import com.aor.journey.state.HelperMenuState;
import com.aor.journey.state.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelperMenuControllerTest {
    private HelperMenuController controller;
    private GameState game;


    @BeforeEach
    void setUp() throws IOException {
        HelperMenu helperMenu = new HelperMenu();
        controller = new HelperMenuController(helperMenu);
        game = new GameState();
        game.setCurrState(new HelperMenuState(helperMenu));
    }

    @Test
    void stepTest() throws IOException {
        controller.step(game, GUI.ACTION.DOWN,1); // Just 1 option "Back"
        assertEquals(controller.getModel().isSelected(0),controller.getModel().isSelected(controller.getModel().getCurrentEntry()));

        controller.step(game, GUI.ACTION.UP,1); // Just 1 option "Back"
        assertEquals(controller.getModel().isSelected(0),controller.getModel().isSelected(controller.getModel().getCurrentEntry()));
    }

    @Test
    void selectTest() throws IOException {
        controller.step(game,GUI.ACTION.SELECT,1);
        assertTrue(game.getCurrState() instanceof MainMenuState);
    }
}
