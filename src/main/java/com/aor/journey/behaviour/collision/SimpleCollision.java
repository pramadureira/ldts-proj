package com.aor.journey.behaviour.collision;

import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.Monster;
import com.aor.journey.model.game.elements.Warrior;
import com.aor.journey.model.game.places.Room;

public class SimpleCollision extends Collision {
    @Override
    public void collide(Room room, Monster monster, Position position) {
        if (Warrior.getInstance().getPosition().equals(position))
            Warrior.getInstance().decreaseLives();

        if(room.removeTrapAt(position)) {
            room.killMonster(monster);
            Warrior.getInstance().increaseCurrTraps();
        }
    }
}
