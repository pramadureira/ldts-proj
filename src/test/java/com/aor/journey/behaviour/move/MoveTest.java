package com.aor.journey.behaviour.move;

import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.*;
import com.aor.journey.model.game.places.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoveTest {
    private Room room;
    @BeforeEach
    void setUp(){
        room = new Room();
    }
    @Test
    void RandomMoveTest(){
        RandomMove randomMove = new RandomMove();
        SimpleMonster simpleMonster = new SimpleMonster(5,5);
        assertFalse(randomMove.move(room,1,simpleMonster));
        assertEquals(new Position(5,5),simpleMonster.getPosition());
        assertFalse(randomMove.move(room,1000,simpleMonster));
        assertEquals(new Position(5,5),simpleMonster.getPosition());
        assertTrue(randomMove.move(room,1001,simpleMonster));
        assertNotEquals(new Position(5,5),simpleMonster.getPosition());

    }
    @Test
    void fastRandomMoveTest(){
        FastRandomMove fastRandomMove = new FastRandomMove();
        FireMonster fireMonster = new FireMonster(5,5);
        assertFalse(fastRandomMove.move(room,1,fireMonster));
        assertEquals(new Position(5,5),fireMonster.getPosition());
        assertFalse(fastRandomMove.move(room,400,fireMonster));
        assertEquals(new Position(5,5),fireMonster.getPosition());
        assertTrue(fastRandomMove.move(room,401,fireMonster));
        assertNotEquals(new Position(5,5),fireMonster.getPosition());
    }
    @Test
    void hatchingMoveTest(){
        EggMonster eggMonster = new EggMonster(5,5);
        HatchingMove hatchingMove = new HatchingMove();
        assertFalse(hatchingMove.move(room,1,eggMonster));
        assertEquals(new Position(5,5),eggMonster.getPosition());
        assertTrue(hatchingMove.move(room,25001,eggMonster));
        assertEquals(new Position(5,5),eggMonster.getPosition());
    }
    @Test
    void fastFollowMoveTest(){
        WaterMonster waterMonster = new WaterMonster(5,5);
        FastFollowMove fastFollowMove = new FastFollowMove();
        assertFalse(fastFollowMove.move(room,1,waterMonster));
        assertEquals(new Position(5,5),waterMonster.getPosition());
        assertFalse(fastFollowMove.move(room,250,waterMonster));
        assertEquals(new Position(5,5),waterMonster.getPosition());

        // TEST DIAGONAL
        Warrior.getInstance().setPosition(new Position(1,1));
        assertTrue(fastFollowMove.move(room,251,waterMonster));
        assertEquals(new Position(4,4),waterMonster.getPosition());

        // TEST UP
        waterMonster.setPosition(new Position(5,5));
        Warrior.getInstance().setPosition(new Position(5,7));
        assertTrue(fastFollowMove.move(room,501,waterMonster));
        assertEquals(new Position(5,6),waterMonster.getPosition());

        // TEST DOWN
        waterMonster.setPosition(new Position(5,5));
        Warrior.getInstance().setPosition(new Position(5,3));
        assertTrue(fastFollowMove.move(room,751,waterMonster));
        assertEquals(new Position(5,4),waterMonster.getPosition());

        // TEST LEFT
        waterMonster.setPosition(new Position(5,5));
        Warrior.getInstance().setPosition(new Position(3,5));
        assertTrue(fastFollowMove.move(room,1001,waterMonster));
        assertEquals(new Position(4,5),waterMonster.getPosition());

        // TEST RIGHT
        waterMonster.setPosition(new Position(5,5));
        Warrior.getInstance().setPosition(new Position(7,5));
        assertTrue(fastFollowMove.move(room,1251,waterMonster));
        assertEquals(new Position(6,5),waterMonster.getPosition());
    }
    @Test
    void followMove(){
        MetalMonster metalMonster = new MetalMonster(5,5);
        FollowMove followMove = new FollowMove();
        assertFalse(followMove.move(room,1,metalMonster));
        assertEquals(new Position(5,5),metalMonster.getPosition());
        assertFalse(followMove.move(room,500,metalMonster));
        assertEquals(new Position(5,5),metalMonster.getPosition());

        // TEST DIAGONAL
        Warrior.getInstance().setPosition(new Position(1,1));
        assertTrue(followMove.move(room,501,metalMonster));
        assertEquals(new Position(4,4),metalMonster.getPosition());

        // TEST UP
        metalMonster.setPosition(new Position(5,5));
        Warrior.getInstance().setPosition(new Position(5,7));
        assertTrue(followMove.move(room,1001,metalMonster));
        assertEquals(new Position(5,6),metalMonster.getPosition());

        // TEST DOWN
        metalMonster.setPosition(new Position(5,5));
        Warrior.getInstance().setPosition(new Position(5,3));
        assertTrue(followMove.move(room,1501,metalMonster));
        assertEquals(new Position(5,4),metalMonster.getPosition());

        // TEST LEFT
        metalMonster.setPosition(new Position(5,5));
        Warrior.getInstance().setPosition(new Position(3,5));
        assertTrue(followMove.move(room,2001,metalMonster));
        assertEquals(new Position(4,5),metalMonster.getPosition());

        // TEST RIGHT
        metalMonster.setPosition(new Position(5,5));
        Warrior.getInstance().setPosition(new Position(7,5));
        assertTrue(followMove.move(room,2501,metalMonster));
        assertEquals(new Position(6,5),metalMonster.getPosition());
     }
}
