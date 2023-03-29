package com.aor.journey.behaviour.move;

import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.Monster;
import com.aor.journey.model.game.places.Room;

public abstract class Move {
    protected long lastMovement;

    public Move(){
        lastMovement = 0;
    }
    public abstract boolean move(Room room, long time, Monster monster);

    protected void moveMonster(Room room, Monster monster, Position position) {
        if (room.isEmpty(position)) {
            monster.setPosition(position);
        }
    }
}
