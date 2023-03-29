package com.aor.journey.model.game.places;

import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.Portal;
import com.aor.journey.model.game.elements.Shopkeeper;
import com.aor.journey.model.game.elements.Wall;
import com.aor.journey.model.game.elements.Warrior;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShopBuilder extends PlaceBuilder{
    public ShopBuilder() throws IOException {
        super("shop");
    }
    @Override
    public Shop createPlace() {
        Shop shop = new Shop();

        List<Wall> walls = new ArrayList<>();
        List<Portal> portals = new ArrayList<>();

        for(int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'W') Warrior.getInstance().setPosition(new Position(x, y));
                if (line.charAt(x) == '#') walls.add(new Wall(x, y));
                if (line.charAt(x) == 'L') portals.add(new Portal(x, y, Portal.Type.LOBBY));
                if (line.charAt(x) == 'S') shop.setShopkeeper(new Shopkeeper(x, y));
            }
        }

        shop.setWalls(walls);
        shop.setPortals(portals);

        return shop;
    }
}
