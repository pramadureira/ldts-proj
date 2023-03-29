package com.aor.journey.model.game.elements;

public class Portal extends Element {

    public enum Type {
        LOBBY,
        SHOP,
        HOME,
        FIREDUNGEON,
        GRASSDUNGEON,
        METALDUNGEON,
        WATERDUNGEON,
        NEXTROOM
    }
    private final Type type;

    public Portal(int x, int y, Type type) {
        super(x, y);
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}

