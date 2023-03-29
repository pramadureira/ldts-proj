package com.aor.journey.model.game.elements;

import com.aor.journey.model.game.places.Room;

import java.util.HashMap;

public class Warrior extends Element{
    private static Warrior instance;
    public final static int MAX_LIVES = 5;
    public final static int MAX_TRAPS = 10;
    private int lives;
    private int coins;
    private int currTraps;
    private final HashMap<Room.Type, Boolean> trophies;
    private boolean wet = false;

    private Warrior(int x, int y) {
        super(x, y);

        this.lives = 5;
        this.coins = 0;
        this.currTraps = 3;

        trophies = new HashMap<>() {{
            put(Room.Type.FIRE, false);
            put(Room.Type.GRASS, false);
            put(Room.Type.METAL, false);
            put(Room.Type.WATER, false);
        }};
    }
    public static Warrior getInstance() {
        if (instance == null) {
            instance = new Warrior(0,0);
        }

        return instance;
    }
    public static void resetInstance() {
        instance = null;
    }
    public void decreaseLives() {
        this.lives--;
    }
    public void increaseLives(){
        if (lives < MAX_LIVES) {
            this.lives++;
        }
    }
    public void increaseCoins(){
        this.coins++;
    }
    public void useCoins(int amount) { this.coins -= amount; }
    public void decreaseCurrTraps(){
        this.currTraps--;
    }
    public void increaseCurrTraps() {
        this.currTraps++;
    }
    public void setCurrTraps(int traps) { this.currTraps = traps; }
    public int getCurrTraps() {
        return currTraps;
    }
    public void setCoins(int coins) {this.coins = coins;}
    public void setLives(int lives) {this.lives = lives;}
    public int getLives() {
        return lives;
    }
    public int getCoins(){
        return coins;
    }
    public void wet(){
        wet = true;
    }
    public void dry() {
        wet = false;
    }
    public boolean isWet(){
        return wet;
    }
    public HashMap<Room.Type, Boolean> getTrophies() {
        return trophies;
    }
}
