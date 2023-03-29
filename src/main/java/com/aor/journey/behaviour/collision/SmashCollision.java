package com.aor.journey.behaviour.collision;

import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.Monster;
import com.aor.journey.model.game.elements.Warrior;
import com.aor.journey.model.game.places.Room;

public class SmashCollision extends Collision{
    @Override
    public void collide(Room room, Monster monster, Position position) {
        if (Warrior.getInstance().getPosition().equals(position))
            room.killMonster(monster);
    }
}
