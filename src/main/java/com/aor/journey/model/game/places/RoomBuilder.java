package com.aor.journey.model.game.places;

import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RoomBuilder extends PlaceBuilder {
    public RoomBuilder(){
        super();
    }
    public RoomBuilder(String roomName) throws IOException {
        super(roomName);
    }
    @Override
    public Room createPlace() {
        Room room = new Room();
        List<Wall> walls = new ArrayList<>();
        List<Portal> portals = new ArrayList<>();
        List<Monster> monsters = new ArrayList<>();
        List<Coin> coins = new ArrayList<>();
        List<Water> waters = new ArrayList<>();

        for(int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == '#') walls.add(new Wall(x, y));
                if (line.charAt(x) == 'W') Warrior.getInstance().setPosition(new Position(x, y));
                if (line.charAt(x) == 'N') portals.add(new Portal(x, y, Portal.Type.NEXTROOM));
                if (line.charAt(x) == 'L') portals.add(new Portal(x, y, Portal.Type.LOBBY));
                if (line.charAt(x) == 'S') monsters.add(new SimpleMonster(x, y));
                if (line.charAt(x) == 'F') monsters.add(new FireMonster(x, y));
                if (line.charAt(x) == 'V') monsters.add(new WaterMonster(x, y));
                if (line.charAt(x) == 'M') monsters.add(new MetalMonster(x, y));
                if (line.charAt(x) == 'E') monsters.add(new EggMonster(x, y));
                if (line.charAt(x) == 'C') coins.add(new Coin(x, y));
                if (line.charAt(x) == 'A') waters.add(new Water(x, y));
                if (line.charAt(x) == 'D'){
                    Wall door = new Wall(x, y);
                    walls.add(door);
                    room.setDoor(door);
                }
            }
        }

        room.setWalls(walls);
        room.setPortals(portals);
        room.setMonsters(monsters);
        room.setCoins(coins);
        room.setWaters(waters);

        return room;
    }
}
