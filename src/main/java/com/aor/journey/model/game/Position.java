package com.aor.journey.model.game;

import com.aor.journey.model.game.elements.Warrior;

import java.util.Objects;

import static java.lang.Math.abs;

public class Position {
    private final int x, y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean near(Position position) {
        return abs(this.x - position.x) <= 3 && abs(this.y - position.y) <= 3;
    }

    public Position getUp() {
        return new Position(x, y - 1);
    }
    public Position getDown() {
        return new Position(x, y + 1);
    }
    public Position getLeft() {
        return new Position(x - 1, y);
    }
    public Position getRight() {
        return new Position(x + 1, y);
    }

    public Position getRandom() {
        int n = (int) (Math.random() * 4);
        return switch (n) {
            case 0 -> getUp();
            case 1 -> getRight();
            case 2 -> getDown();
            default -> getLeft();
        };
    }

    public Position getToHero() {
        int newX = x;
        int newY = y;

        if(Warrior.getInstance().getPosition().getX() - x > 0) newX += 1;
        else if(Warrior.getInstance().getPosition().getX() - x < 0) newX -= 1;
        if(Warrior.getInstance().getPosition().getY() - y > 0) newY += 1;
        else if(Warrior.getInstance().getPosition().getY() - y < 0) newY -= 1;

        return new Position(newX, newY);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

