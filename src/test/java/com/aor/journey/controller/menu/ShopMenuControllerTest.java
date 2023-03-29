package com.aor.journey.controller.menu;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.elements.Warrior;
import com.aor.journey.model.menu.ShopMenu;
import com.aor.journey.state.GameState;
import com.aor.journey.state.ShopMenuState;
import com.aor.journey.state.ShopState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class ShopMenuControllerTest {
    private ShopMenuController controller;
    private ShopMenu shopMenu;

    private ShopMenuState shopMenuState;
    private GameState game;
    @BeforeEach
    void setUp() throws IOException {
        Warrior.resetInstance();
        shopMenu = new ShopMenu();
        shopMenuState = new ShopMenuState(shopMenu);
        controller = new ShopMenuController(shopMenu);
        game = new GameState();
        game.setCurrState(shopMenuState);
    }
    @Test
    void stepTest() throws IOException {
        assertEquals(controller.getModel().isSelected(0),controller.getModel().isSelectedLives());
        assertEquals(controller.getModel().isSelected(1),controller.getModel().isSelectedTraps());
        assertEquals(controller.getModel().isSelected(2),controller.getModel().isSelectedClose());

        controller.step(game, GUI.ACTION.DOWN,1);
        assertEquals(controller.getModel().isSelected(1),controller.getModel().isSelected(controller.getModel().getCurrentEntry()));

        controller.step(game, GUI.ACTION.UP,1);
        assertEquals(controller.getModel().isSelected(0),controller.getModel().isSelected(controller.getModel().getCurrentEntry()));

        controller.step(game, GUI.ACTION.DOWN,1);
        controller.step(game, GUI.ACTION.DOWN,1);
        assertEquals(controller.getModel().isSelected(2),controller.getModel().isSelected(controller.getModel().getCurrentEntry()));

    }
    @Test
    void buyTest() throws IOException {
        Warrior.getInstance().setCoins(5);
        Warrior.getInstance().setLives(Warrior.MAX_LIVES);
        controller.step(game, GUI.ACTION.SELECT,1);
        // Don't decrease the coins because warrior have the MAX_LIVES
        assertEquals(5,Warrior.getInstance().getCoins());
        assertEquals(Warrior.MAX_LIVES,Warrior.getInstance().getLives());

        Warrior.getInstance().setCoins(4);
        Warrior.getInstance().setLives(1);
        controller.step(game, GUI.ACTION.SELECT,1);
        // Not enough coins
        assertEquals(4,Warrior.getInstance().getCoins());
        assertEquals(1,Warrior.getInstance().getLives());

        Warrior.getInstance().setCoins(5);
        Warrior.getInstance().setLives(1);
        controller.step(game, GUI.ACTION.SELECT,1);
        // Buy 1 live for 5 coin
        assertEquals(0,Warrior.getInstance().getCoins());
        assertEquals(2,Warrior.getInstance().getLives());

        controller.step(game, GUI.ACTION.DOWN,1);

        Warrior.getInstance().setCoins(10);
        Warrior.getInstance().setCurrTraps(Warrior.MAX_TRAPS);
        controller.step(game, GUI.ACTION.SELECT,1);
        // Don't decrease the coins because warrior have the MAX_TRAPS
        assertEquals(10,Warrior.getInstance().getCoins());
        assertEquals(Warrior.MAX_TRAPS,Warrior.getInstance().getCurrTraps());

        Warrior.getInstance().setCoins(9);
        Warrior.getInstance().setCurrTraps(1);
        controller.step(game, GUI.ACTION.SELECT,1);
        // Not enough coins
        assertEquals(9,Warrior.getInstance().getCoins());
        assertEquals(1,Warrior.getInstance().getCurrTraps());

        Warrior.getInstance().setCoins(10);
        Warrior.getInstance().setCurrTraps(3);
        controller.step(game, GUI.ACTION.SELECT,1);
        // Buy 1 trap for 10 coin
        assertEquals(0,Warrior.getInstance().getCoins());
        assertEquals(4,Warrior.getInstance().getCurrTraps());
    }
    @Test
    void selectCloseTest() throws IOException {
        controller.step(game, GUI.ACTION.DOWN,1);
        controller.step(game, GUI.ACTION.DOWN,1);
        assertTrue(controller.getModel().isSelectedClose());
        assertFalse(controller.getModel().isSelectedLives());
        assertFalse(controller.getModel().isSelectedTraps());
        controller.step(game, GUI.ACTION.SELECT,1);
        assertTrue(game.getCurrState() instanceof ShopState);
    }

}

