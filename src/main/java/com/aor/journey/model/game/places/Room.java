package com.aor.journey.model.game.places;

import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.Coin;
import com.aor.journey.model.game.elements.Monster;
import com.aor.journey.model.game.elements.Wall;
import com.aor.journey.model.game.elements.Water;

import java.util.ArrayList;
import java.util.List;

public class Room extends Place{
    private List<Monster> monsters = new ArrayList<>();
    private List<Coin> coins = new ArrayList<>();
    private List<Water> waters = new ArrayList<>();
    private Wall door;
    private Type type;

    public void setMonsters(List<Monster> monsters){
        this.monsters = monsters;
    }
    public List<Monster> getMonsters() {
        return monsters;
    }
    public List<Coin> getCoins() {
        return coins;
    }
    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }
    public List<Water> getWaters() {
        return waters;
    }
    public void setWaters(List<Water> waters) {
        this.waters = waters;
    }
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public Wall getDoor() {
        return door;
    }
    public void setDoor(Wall door) {
        this.door = door;
    }

    public boolean isMonster(Position position){
        for (Monster monster : monsters)
            if (monster.getPosition().equals(position))
                return true;
        return false;
    }

    public Monster getMonster(Position position){
        for (Monster monster : monsters)
            if (monster.getPosition().equals(position))
                return monster;
        return null;
    }

    public boolean isWater(Position position){
        for (Water water : waters)
            if (water.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isCoin(Position position){
        for (Coin coin : coins)
            if (coin.getPosition().equals(position)) {
                return true;
            }
        return false;
    }

    public void removeCoin(Position position){
        for (Coin coin : coins)
            if (coin.getPosition().equals(position)) {
                coins.remove(coin);
                break;
            }
    }

    public void openDoor(){
        walls.remove(door);
    }

    public void killMonster(Monster monster){
        monsters.remove(monster);
        if (monsters.isEmpty()) openDoor();
    }

    public enum Type {FIRE, GRASS, METAL, WATER}
}
