package com.aor.journey.model.game.places;

import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.Portal;
import com.aor.journey.model.game.elements.Wall;
import com.aor.journey.model.game.elements.Warrior;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LobbyBuilder extends PlaceBuilder{
    public LobbyBuilder() throws IOException {
        super("lobby");
    }
    @Override
    public Lobby createPlace() {
        Lobby lobby = new Lobby();

        List<Wall> walls = new ArrayList<>();
        List<Portal> portals = new ArrayList<>();

        for(int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'W') Warrior.getInstance().setPosition(new Position(x, y));
                if (line.charAt(x) == '#') walls.add(new Wall(x, y));
                if (line.charAt(x) == 'S') portals.add(new Portal(x, y, Portal.Type.SHOP));
                if (line.charAt(x) == 'H') portals.add(new Portal(x, y, Portal.Type.HOME));
                if (line.charAt(x) == 'F') portals.add(new Portal(x, y, Portal.Type.FIREDUNGEON));
                if (line.charAt(x) == 'G') portals.add(new Portal(x, y, Portal.Type.GRASSDUNGEON));
                if (line.charAt(x) == 'A') portals.add(new Portal(x, y, Portal.Type.WATERDUNGEON));
                if (line.charAt(x) == 'M') portals.add(new Portal(x, y, Portal.Type.METALDUNGEON));
            }
        }

        lobby.setWalls(walls);
        lobby.setPortals(portals);

        return lobby;
    }
}
