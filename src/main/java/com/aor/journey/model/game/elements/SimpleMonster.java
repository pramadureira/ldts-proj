package com.aor.journey.model.game.elements;

import com.aor.journey.behaviour.collision.SimpleCollision;
import com.aor.journey.behaviour.move.RandomMove;

public class SimpleMonster extends Monster{
    public SimpleMonster(int x, int y) {
        super(x, y, new SimpleCollision(), new RandomMove());
    }

    @Override
    public void update() {

    }
}
