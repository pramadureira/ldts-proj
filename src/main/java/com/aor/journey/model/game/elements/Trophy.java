package com.aor.journey.model.game.elements;

import com.aor.journey.model.game.places.Room;

public class Trophy extends Element{

    private final Room.Type type;
    public Trophy(int x, int y, Room.Type type) {
        super(x, y);
        this.type = type;
    }

    public Room.Type getType() {
        return type;
    }
}
