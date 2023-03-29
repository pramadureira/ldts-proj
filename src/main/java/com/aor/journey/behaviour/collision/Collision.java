package com.aor.journey.behaviour.collision;

import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.Monster;
import com.aor.journey.model.game.places.Room;

public abstract class Collision {
    public abstract void collide(Room room, Monster monster, Position position);
}
