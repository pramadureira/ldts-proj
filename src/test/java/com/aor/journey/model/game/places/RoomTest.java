package com.aor.journey.model.game.places;

import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {
    private Room room;
    private SimpleMonster simpleMonster;
    private FireMonster fireMonster;
    private WaterMonster waterMonster;
    private MetalMonster metalMonster;
    private EggMonster eggMonster;
    @BeforeEach
    void setUp(){
        room = new Room();
    }
    @Test
    public void testMonsterRoom() {
        simpleMonster = new SimpleMonster(1, 1);
        fireMonster = new FireMonster(2, 2);
        eggMonster = new EggMonster(3,3);
        waterMonster = new WaterMonster(4,4);
        metalMonster = new MetalMonster(5,5);
        room.setMonsters(Arrays.asList(simpleMonster,fireMonster,eggMonster,waterMonster,metalMonster));

        assertEquals(5,room.getMonsters().size());

        assertTrue(room.isMonster(new Position(1, 1)));
        assertFalse(room.isMonster(new Position(6, 6)));

        assertTrue(room.getMonsters().get(0) instanceof SimpleMonster);
        assertTrue(room.getMonsters().get(1) instanceof FireMonster);
        assertTrue(room.getMonsters().get(2) instanceof EggMonster);
        assertTrue(room.getMonsters().get(3) instanceof WaterMonster);
        assertTrue(room.getMonsters().get(4) instanceof MetalMonster);
    }

    @Test
    void testWaterRoom(){
        Water water1 = new Water(1,1);
        Water water2 = new Water(2, 2);
        Water water3 = new Water(3, 3);
        room.setWaters(Arrays.asList(water1, water2, water3));

        assertEquals(3, room.getWaters().size());
        assertTrue(room.isWater(new Position(1, 1)));
        assertFalse(room.isWater(new Position(4, 4)));
    }
    @Test
    void testCoinRoom(){
        Coin coin1 = new Coin(1, 1);
        Coin coin2 = new Coin(2, 2);
        Coin coin3 = new Coin(3, 3);
        room.setCoins(new ArrayList<>(Arrays.asList(coin1, coin2, coin3)));

        assertEquals(3, room.getCoins().size());
        assertTrue(room.isCoin(new Position(1, 1)));
        assertFalse(room.isCoin(new Position(4, 4)));

        room.removeCoin(new Position(2, 2));
        assertEquals(2, room.getCoins().size());

    }
}