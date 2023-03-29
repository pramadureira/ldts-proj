package com.aor.journey.model.game.elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WarriorTest {
    @BeforeEach
    void setup() {
        Warrior.resetInstance();
    }

    @Test
    void decreaseLivesTest(){
        Warrior.getInstance().decreaseLives();
        assertEquals(4,Warrior.getInstance().getLives());

    }
    @Test
    void increaseLivesTest(){
        Warrior.getInstance().increaseLives(); // Warrior with max lives
        assertEquals(Warrior.MAX_LIVES,Warrior.getInstance().getLives());

        Warrior.getInstance().setLives(3);
        Warrior.getInstance().increaseLives();
        assertEquals(4,Warrior.getInstance().getLives());

    }

    @Test
    void increaseCoinsTest(){
        Warrior.getInstance().setCoins(10);
        Warrior.getInstance().increaseCoins();
        assertEquals(11,Warrior.getInstance().getCoins());
    }
    @Test
    void useCoinsTest(){
        Warrior.getInstance().setCoins(10);
        Warrior.getInstance().useCoins(10);
        assertEquals(0,Warrior.getInstance().getCoins());
    }
    @Test
    void decreaseCurrTraps(){
        Warrior.getInstance().decreaseCurrTraps();
        assertEquals(2,Warrior.getInstance().getCurrTraps());
    }

    @Test
    void increaseCurrTraps(){
        Warrior.getInstance().increaseCurrTraps();
        assertEquals(4,Warrior.getInstance().getCurrTraps());
    }
    @Test
    void wetDryTest(){
        Warrior.getInstance().wet();
        assertEquals(true,Warrior.getInstance().isWet());

        Warrior.getInstance().dry();
        assertEquals(false,Warrior.getInstance().isWet());

    }

}
