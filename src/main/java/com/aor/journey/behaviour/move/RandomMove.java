package com.aor.journey.behaviour.move;

import com.aor.journey.model.game.elements.Monster;
import com.aor.journey.model.game.places.Room;

public class RandomMove extends Move {
    @Override
    public boolean move(Room room, long time, Monster monster) {
        if (this.lastMovement == 0) {
            this.lastMovement = time;
        } else if(time - lastMovement >= 1000){
            this.lastMovement = time;
            moveMonster(room, monster, monster.getPosition().getRandom());
            return true;
        }
        return false;
    }
}
