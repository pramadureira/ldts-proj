package com.aor.journey.model.game.places;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DungeonTest {
    @Test
    void dungeonTest() throws IOException {
        Dungeon fireDungeon = new Dungeon("fire");
        Dungeon waterDungeon = new Dungeon("water");
        Dungeon metalDungeon = new Dungeon("metal");
        Dungeon grassDungeon = new Dungeon("grass");

        assertEquals(Room.Type.FIRE,fireDungeon.getCurrentRoom().getType());
        assertEquals(3,fireDungeon.getRooms().size());
        assertEquals(Room.Type.WATER,waterDungeon.getCurrentRoom().getType());
        assertEquals(3,fireDungeon.getRooms().size());
        assertEquals(Room.Type.METAL,metalDungeon.getCurrentRoom().getType());
        assertEquals(3,fireDungeon.getRooms().size());
        assertEquals(Room.Type.GRASS,grassDungeon.getCurrentRoom().getType());
        assertEquals(3,fireDungeon.getRooms().size());
    }
    @Test
    void addRoomTest() throws IOException {
        Room room = new Room();
        Dungeon dungeon = new Dungeon("fire");
        dungeon.addRoom(room);
        assertEquals(Room.Type.FIRE,room.getType());
        assertEquals(4,dungeon.getRooms().size());
    }

    @Test
    void moveToNextRoomTest() throws IOException {
        Dungeon dungeon = new Dungeon("fire");
        Room room1 = dungeon.getCurrentRoom();
        dungeon.moveToNextRoom();
        Room room2 = dungeon.getCurrentRoom();
        dungeon.moveToNextRoom();
        Room room3 = dungeon.getCurrentRoom();
        dungeon.moveToNextRoom();
        Room room4 = dungeon.getCurrentRoom();
        assertNotEquals(room1, room2);
        assertNotEquals(room2, room3);
        assertEquals(room3, room4);
    }
}
