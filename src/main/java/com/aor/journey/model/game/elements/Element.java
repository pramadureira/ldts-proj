package com.aor.journey.model.game.elements;

import com.aor.journey.model.game.Position;

public class Element {
    private Position position;

    public Element(Position position) {
        this.position = position;
    }
    public Element(int x, int y) {
        this.position = new Position(x, y);
    }
    public Position getPosition() {
        return this.position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
}
