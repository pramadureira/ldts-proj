package com.aor.journey.model.game.elements;

import com.aor.journey.behaviour.collision.SimpleCollision;
import com.aor.journey.behaviour.move.FastFollowMove;
import com.aor.journey.behaviour.move.RandomMove;

public class WaterMonster extends Monster{
    int count;
    public WaterMonster(int x, int y) {
        super(x, y, new SimpleCollision(), new RandomMove());
        count = 0;
    }

    @Override
    public void update() {
        count++;
        if(count >= 5 && getMove() instanceof RandomMove){
            count = 0;
            setMove(new FastFollowMove());
        }else if(count >= 10 && getMove() instanceof FastFollowMove) {
            count = 0;
            setMove(new RandomMove());
        }
    }
}
