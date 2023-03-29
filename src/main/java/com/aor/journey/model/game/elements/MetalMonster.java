package com.aor.journey.model.game.elements;

import com.aor.journey.behaviour.collision.SimpleCollision;
import com.aor.journey.behaviour.move.FastRandomMove;
import com.aor.journey.behaviour.move.FollowMove;

public class MetalMonster extends Monster {
    public MetalMonster(int x, int y) {
        super(x, y, new SimpleCollision(), new FastRandomMove());
    }

    @Override
    public void update() {
        if(getMove() instanceof FastRandomMove && this.getPosition().near(Warrior.getInstance().getPosition())){
            setMove(new FollowMove());
        }
    }
}
