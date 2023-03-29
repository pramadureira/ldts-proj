package com.aor.journey.model.game.elements;

import com.aor.journey.behaviour.collision.Collision;
import com.aor.journey.behaviour.move.Move;

public abstract class Monster extends Element{
    private Collision collision;
    private Move move;
    public Monster(int x, int y, Collision collision, Move move) {
        super(x, y);
        this.collision = collision;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }
    public void setMove(Move move) {
        this.move = move;
    }
    public Collision getCollision() {
        return collision;
    }
    public void setCollision(Collision collision) {
        this.collision = collision;
    }

    public abstract void update();
}
