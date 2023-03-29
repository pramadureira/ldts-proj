package com.aor.journey.behaviour.collision;

import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.*;
import com.aor.journey.model.game.places.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CollisionTest {

    private Room room;
    @BeforeEach
    void setUp(){
        room = new Room();
        Warrior.resetInstance();
    }
    @Test
    void waterCollisionWetTest(){
        FireMonster fireMonster = new FireMonster(5,5);
        room.setMonsters(new ArrayList<>(List.of(fireMonster)));
        Warrior.getInstance().setPosition(new Position(5,5));
        Warrior.getInstance().wet();
        WaterCollision waterCollision = new WaterCollision();
        waterCollision.collide(room, fireMonster,new Position(5,5));

        assertEquals(0,room.getMonsters().size());
        assertEquals(Warrior.MAX_LIVES,Warrior.getInstance().getLives());
        assertFalse(Warrior.getInstance().isWet());

    }
    @Test
    void waterCollisionNotWetTest(){
        FireMonster fireMonster = new FireMonster(5,5);
        room.setMonsters(new ArrayList<>(List.of(fireMonster)));
        Warrior.getInstance().setPosition(new Position(5,5));
        WaterCollision waterCollision = new WaterCollision();
        waterCollision.collide(room, fireMonster,new Position(5,5));

        assertEquals(1,room.getMonsters().size());
        assertEquals(Warrior.MAX_LIVES-1,Warrior.getInstance().getLives());
    }

    @Test
    void waterCollisionAgainstWaterTest(){
        FireMonster fireMonster = new FireMonster(5,5);
        room.setMonsters(new ArrayList<>(List.of(fireMonster)));
        room.setWaters(List.of(new Water(5, 5)));
        WaterCollision waterCollision = new WaterCollision();
        waterCollision.collide(room, fireMonster,new Position(5,5));

        assertEquals(0,room.getMonsters().size());
        assertEquals(1,room.getWaters().size());
    }

    @Test
    void smashCollisionTest(){
        EggMonster eggMonster = new EggMonster(5,5);
        room.setMonsters(new ArrayList<>(List.of(eggMonster)));
        Warrior.getInstance().setPosition(new Position(5,5));
        SmashCollision smashCollision = new SmashCollision();
        smashCollision.collide(room,eggMonster,new Position(5,5));

        assertEquals(0,room.getMonsters().size());
        assertEquals(Warrior.MAX_LIVES,Warrior.getInstance().getLives());
    }

    @Test
    void simpleCollisionTest(){
        SimpleMonster simpleMonster = new SimpleMonster(5,5);
        room.setMonsters(new ArrayList<>(List.of(simpleMonster)));
        Warrior.getInstance().setPosition(new Position(5,5));
        SimpleCollision simpleCollision = new SimpleCollision();
        simpleCollision.collide(room,simpleMonster,new Position(5,5));

        assertEquals(Warrior.MAX_LIVES-1,Warrior.getInstance().getLives());
        assertEquals(1,room.getMonsters().size());
    }
    @Test
    void simpleCollisionTrapTest(){
        Warrior.getInstance().setCurrTraps(0);
        SimpleMonster simpleMonster = new SimpleMonster(5,5);
        room.setMonsters(new ArrayList<>(List.of(simpleMonster)));
        room.addTrap(new Trap(5,5));
        SimpleCollision simpleCollision = new SimpleCollision();
        simpleCollision.collide(room,simpleMonster,new Position(5,5));

        assertEquals(0,room.getTraps().size());
        assertEquals(0,room.getMonsters().size());
        assertEquals(1, Warrior.getInstance().getCurrTraps());
    }

}

