package com.aor.journey.controller.game;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.*;
import com.aor.journey.model.game.places.Room;
import com.aor.journey.state.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WarriorControllerTest {
    private WarriorController controller;
    private Room room;
    private GameState gameState;

    @BeforeEach
    void setUp(){
        Warrior.resetInstance();
        Warrior.getInstance().setPosition(new Position(5, 5));
        room = new Room();
        controller = new WarriorController(room);
        gameState = Mockito.mock (GameState.class);
    }

    @Test
    void moveWarriorRightEmptyTest() {
        controller.moveWarriorRight();
        assertEquals(new Position(6, 5), Warrior.getInstance().getPosition());
    }
    @Test
    void moveWarriorRightNotEmptyTest() {
        room.setWalls(List.of(new Wall(6, 5)));
        controller.moveWarriorRight();
        assertEquals(new Position(5, 5), Warrior.getInstance().getPosition());
    }
    @Test
    void moveWarriorLeftEmptyTest() {
        controller.moveWarriorLeft();
        assertEquals(new Position(4, 5), Warrior.getInstance().getPosition());
    }
    @Test
    void moveWarriorLeftNotEmptyTest() {
        room.setWalls(List.of(new Wall(4, 5)));
        controller.moveWarriorLeft();
        assertEquals(new Position(5, 5), Warrior.getInstance().getPosition());
    }
    @Test
    void moveWarriorUpEmptyTest() {
        controller.moveWarriorUp();
        assertEquals(new Position(5, 4), Warrior.getInstance().getPosition());
    }
    @Test
    void moveWarriorUpNotEmptyTest() {
        room.setWalls(List.of(new Wall(5, 4)));
        controller.moveWarriorUp();
        assertEquals(new Position(5, 5), Warrior.getInstance().getPosition());
    }
    @Test
    void moveWarriorDownEmptyTest() {
        controller.moveWarriorDown();
        assertEquals(new Position(5, 6), Warrior.getInstance().getPosition());
    }
    @Test
    void moveWarriorDownNotEmptyTest() {
        room.setWalls(List.of(new Wall(5, 6)));
        controller.moveWarriorDown();
        assertEquals(new Position(5, 5), Warrior.getInstance().getPosition());
    }

    @Test
    void collectCoinTest(){
        List<Coin> coins = new ArrayList<>((List.of(new Coin(6, 5))));
        room.setCoins(coins);

        assertEquals(1,((Room)controller.getModel()).getCoins().size());
        controller.moveWarriorRight();
        assertEquals(0,((Room)controller.getModel()).getCoins().size());

        assertEquals(1, Warrior.getInstance().getCoins());
    }
    @Test
    void collisionWithMonsterTest(){
        room.setMonsters(List.of(new SimpleMonster(6, 5)));

        assertEquals(5,Warrior.getInstance().getLives());
        controller.moveWarriorRight();
        assertEquals(4,Warrior.getInstance().getLives());
    }
    @Test
    void collisionWithWaterTest(){
        room.setWaters(List.of(new Water(6, 5)));

        assertFalse(Warrior.getInstance().isWet());
        controller.moveWarriorRight();
        assertTrue(Warrior.getInstance().isWet());
    }

    @Test
    void stepTest() throws IOException {
        controller.step(gameState, GUI.ACTION.UP,1);
        assertEquals(new Position(5,4),Warrior.getInstance().getPosition());

        controller.step(gameState,GUI.ACTION.LEFT,1);
        assertEquals(new Position(4,4),Warrior.getInstance().getPosition());

        controller.step(gameState,GUI.ACTION.RIGHT,1);
        assertEquals(new Position(5,4),Warrior.getInstance().getPosition());

        controller.step(gameState,GUI.ACTION.DOWN,1);
        assertEquals(new Position(5,5),Warrior.getInstance().getPosition());

        controller.step(gameState,GUI.ACTION.USE,1);
        assertEquals(2,Warrior.getInstance().getCurrTraps());

        controller.step(gameState,GUI.ACTION.INTERACT,1);
        assertEquals(3,Warrior.getInstance().getCurrTraps());
    }
    @Test
    void zeroTrapsTest() throws IOException {
        Warrior.getInstance().setPosition(new Position(10,10));
        controller.step(gameState,GUI.ACTION.USE,1);
        assertEquals(2,Warrior.getInstance().getCurrTraps());
        assertTrue(room.removeTrapAt(new Position(10,10)));

        Warrior.getInstance().setPosition(new Position(11,11));
        controller.step(gameState,GUI.ACTION.USE,1);
        assertEquals(1,Warrior.getInstance().getCurrTraps());
        assertTrue(room.removeTrapAt(new Position(11,11)));

        Warrior.getInstance().setPosition(new Position(12,12));
        controller.step(gameState,GUI.ACTION.USE,1);
        assertEquals(0,Warrior.getInstance().getCurrTraps());
        assertTrue(room.removeTrapAt(new Position(12,12)));

        Warrior.getInstance().setPosition(new Position(13,13));
        controller.step(gameState,GUI.ACTION.USE,1);
        assertEquals(0,Warrior.getInstance().getCurrTraps());
        assertFalse(room.removeTrapAt(new Position(13,13)));

    }
}
