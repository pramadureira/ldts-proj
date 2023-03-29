package com.aor.journey.model.game.elements;

import com.aor.journey.model.game.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElementTest {
    @Test
    public void setPositionTest(){

        Element element = new Element(5,5);
        Position position = new Position(10,10);

        element.setPosition(position);
        assertEquals(position,element.getPosition());

    }
}
