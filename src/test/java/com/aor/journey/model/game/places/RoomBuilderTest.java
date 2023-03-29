package com.aor.journey.model.game.places;

import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.Warrior;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RoomBuilderTest {
    @Test
    void roomBuilderTest() throws IOException {
        Warrior.resetInstance();
        Room room = new RoomBuilder("test").createPlace();
        assertEquals(2,room.getWalls().size());
        assertEquals(2,room.getPortals().size());
        assertEquals(2,room.getCoins().size());
        assertEquals(1,room.getWaters().size());
        assertEquals(5,room.getMonsters().size());

        assertEquals(new Position(5, 2), Warrior.getInstance().getPosition());

        assertEquals(new Position(0,0),room.getWalls().get(0).getPosition());
        assertEquals(new Position(1,0),room.getWalls().get(1).getPosition());
        assertEquals(room.getDoor(),room.getWalls().get(1));
        assertEquals(new Position(2,0),room.getPortals().get(0).getPosition());
        assertEquals(new Position(4,0),room.getPortals().get(1).getPosition());
        assertEquals(new Position(0,1),room.getCoins().get(0).getPosition());
        assertEquals(new Position(1,1),room.getCoins().get(1).getPosition());
        assertEquals(new Position(3,1),room.getWaters().get(0).getPosition());
        assertEquals(new Position(0,2),room.getMonsters().get(0).getPosition());
        assertEquals(new Position(1,2),room.getMonsters().get(1).getPosition());
        assertEquals(new Position(2,2),room.getMonsters().get(2).getPosition());
        assertEquals(new Position(3,2),room.getMonsters().get(3).getPosition());
        assertEquals(new Position(4,2),room.getMonsters().get(4).getPosition());
    }
}
