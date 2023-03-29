package com.aor.journey.model.game.elements;

import com.aor.journey.behaviour.collision.WaterCollision;
import com.aor.journey.behaviour.move.FastRandomMove;

public class FireMonster extends Monster{
    public FireMonster(int x, int y) {
        super(x, y, new WaterCollision(), new FastRandomMove());
    }

    @Override
    public void update() {

    }
}
