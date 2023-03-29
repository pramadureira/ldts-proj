package com.aor.journey.model.game.places;

import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.Portal;
import com.aor.journey.model.game.elements.Trophy;
import com.aor.journey.model.game.elements.Wall;
import com.aor.journey.model.game.elements.Warrior;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeBuilder extends PlaceBuilder {
    public HomeBuilder() throws IOException {
        super("home");
    }

    @Override
    public Home createPlace() {
        Home home = new Home();

        List<Wall> walls = new ArrayList<>();
        List<Portal> portals = new ArrayList<>();
        List<Trophy> trophies = new ArrayList<>();


        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'W') Warrior.getInstance().setPosition(new Position(x, y));
                if (line.charAt(x) == '#') walls.add(new Wall(x, y));
                if (line.charAt(x) == 'L') portals.add(new Portal(x, y, Portal.Type.LOBBY));
                if (line.charAt(x) == 'F') if (Warrior.getInstance().getTrophies().get(Room.Type.FIRE))
                    trophies.add(new Trophy(x, y, Room.Type.FIRE));
                if (line.charAt(x) == 'A') if (Warrior.getInstance().getTrophies().get(Room.Type.WATER))
                    trophies.add(new Trophy(x, y, Room.Type.WATER));
                if (line.charAt(x) == 'M') if (Warrior.getInstance().getTrophies().get(Room.Type.METAL))
                    trophies.add(new Trophy(x, y, Room.Type.METAL));
                if (line.charAt(x) == 'G') if (Warrior.getInstance().getTrophies().get(Room.Type.GRASS))
                    trophies.add(new Trophy(x, y, Room.Type.GRASS));
            }
        }

        home.setWalls(walls);
        home.setPortals(portals);
        home.setTrophies(trophies);

        return home;
    }
}