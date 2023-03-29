package com.aor.journey.model.game.elements;

import com.aor.journey.behaviour.collision.SimpleCollision;
import com.aor.journey.behaviour.collision.SmashCollision;
import com.aor.journey.behaviour.move.FollowMove;
import com.aor.journey.behaviour.move.HatchingMove;

public class EggMonster extends Monster {
    public EggMonster(int x, int y) {
        super(x, y, new SmashCollision(), new HatchingMove());
    }

    @Override
    public void update() {
        if(getMove() instanceof HatchingMove){
            setMove(new FollowMove());
            setCollision(new SimpleCollision());
        }
    }
}
