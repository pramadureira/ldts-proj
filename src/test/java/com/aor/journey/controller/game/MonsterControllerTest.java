package com.aor.journey.controller.game;

import com.aor.journey.GUI.GUI;
import com.aor.journey.behaviour.collision.WaterCollision;
import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.FireMonster;
import com.aor.journey.model.game.elements.SimpleMonster;
import com.aor.journey.model.game.elements.Wall;
import com.aor.journey.model.game.elements.Warrior;
import com.aor.journey.model.game.places.Room;
import com.aor.journey.state.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MonsterControllerTest {
    private MonsterController controller;
    private Room room;
    private GameState game;
    private
    @BeforeEach
    void setUp() {
        room = new Room();

        Warrior.getInstance().setPosition(new Position(5,5));

        room.setWalls(List.of());
        room.setMonsters(List.of());

        controller = new MonsterController(room);
        game = Mockito.mock(GameState.class);
    }

    @Test
    void moveMonsters() {

        SimpleMonster monster = new SimpleMonster(5, 5);
        room.setMonsters(List.of(monster));

        controller.step(game, GUI.ACTION.NONE, 1000);
        assertEquals(new Position(5, 5), monster.getPosition());

        FireMonster fireMonster = new FireMonster(5,5);
        room.setMonsters(Arrays.asList(fireMonster));
        controller.step(game, GUI.ACTION.DOWN,1);
        assertFalse(fireMonster.getMove().move(room,1,fireMonster));
        assertTrue(fireMonster.getMove().move(room,401,fireMonster));
        fireMonster.update();
        assertTrue(fireMonster.getCollision() instanceof WaterCollision);
    }

    @Test
    void moveMonstersClosed() {
        SimpleMonster monster = new SimpleMonster(5, 5);
        room.setMonsters(List.of(monster));
        room.setWalls(Arrays.asList(
                new Wall(4, 5),
                new Wall(6, 5),
                new Wall(5, 4),
                new Wall(5, 6)
        ));

        for (int i = 0; i < 10; i++)
            controller.step(game, GUI.ACTION.NONE, 1000);

        assertEquals(new Position(5, 5), monster.getPosition());
    }

    @Test
    void moveMonstersGap() {
        SimpleMonster monster = new SimpleMonster(5, 5);
        room.setMonsters(List.of(monster));
        room.setWalls(Arrays.asList(
                new Wall(4, 5),
                new Wall(6, 5),
                new Wall(5, 4)
        ));

        long time = 0;

        while (monster.getPosition().equals(new Position(5, 5))) {
            time += 500;
            controller.step(game, GUI.ACTION.NONE, time);
        }

        assertEquals(new Position(5, 6), monster.getPosition());
    }


}
