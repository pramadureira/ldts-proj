package com.aor.journey.behaviour.move;

import com.aor.journey.model.game.elements.Monster;
import com.aor.journey.model.game.places.Room;

import java.util.Random;

public class HatchingMove extends Move {
    int hatchTime;
    @Override
    public boolean move(Room room, long time, Monster monster) {
        if (this.lastMovement == 0) {
            this.lastMovement = time;
            hatchTime = new Random().nextInt(20000 + 1) + 5000;
        } else if(time - lastMovement >= hatchTime){
            this.lastMovement = time;
            return true;
        }
        return false;
    }
}
