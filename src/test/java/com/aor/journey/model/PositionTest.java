package com.aor.journey.model;

import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.Warrior;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    
    @Property
    void moveLeftTest(@ForAll int x, @ForAll int y) {
        assertEquals(x - 1, new Position(x, y).getLeft().getX());
        assertEquals(y, new Position(x, y).getLeft().getY());
    }
    @Property
    void moveRightTest(@ForAll int x, @ForAll int y) {
        assertEquals(x + 1, new Position(x, y).getRight().getX());
        assertEquals(y, new Position(x, y).getRight().getY());
    }

    @Property
    void moveUpTest(@ForAll int x, @ForAll int y) {
        assertEquals(x, new Position(x, y).getUp().getX());
        assertEquals(y - 1, new Position(x, y).getUp().getY());
    }

    @Property
    void moveDownTest(@ForAll int x, @ForAll int y) {
        assertEquals(x, new Position(x, y).getDown().getX());
        assertEquals(y + 1, new Position(x, y).getDown().getY());
    }

    @Test
    void nearTest(){
        Warrior.getInstance().setPosition(new Position(5,5));
        assertFalse(Warrior.getInstance().getPosition().near(new Position(9,9)));
        assertFalse(Warrior.getInstance().getPosition().near(new Position(9,8)));
        assertFalse(Warrior.getInstance().getPosition().near(new Position(8,9)));
        assertTrue(Warrior.getInstance().getPosition().near(new Position(8,8)));
    }
}