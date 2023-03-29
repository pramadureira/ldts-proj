package com.aor.journey.viewer.game.places;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.Warrior;
import com.aor.journey.model.game.places.Place;
import com.aor.journey.viewer.game.elements.PortalViewer;
import com.aor.journey.viewer.game.elements.TrapViewer;
import com.aor.journey.viewer.game.elements.WallViewer;
import com.aor.journey.viewer.game.elements.WarriorViewer;

public class ConcretePlaceViewer extends PlaceViewer<Place> {
    public ConcretePlaceViewer(Place place){
        super(place);
    }

    @Override
    protected void drawElements(GUI gui) {
        drawElement(gui, Warrior.getInstance(), new WarriorViewer());
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getPortals(), new PortalViewer());
        drawElements(gui, getModel().getTraps(), new TrapViewer());

        gui.drawText(new Position(0,GUI.HEIGHT ), "Lives: " + Warrior.getInstance().getLives() + "/" + Warrior.MAX_LIVES, "#FFD700");
        gui.drawText(new Position(0,GUI.HEIGHT+1 ), "Coins: " + Warrior.getInstance().getCoins(), "#FFD700");
        gui.drawText(new Position(12,GUI.HEIGHT+1 ), "Traps: " + Warrior.getInstance().getCurrTraps() + "/" + Warrior.MAX_TRAPS, "#FFD700");
    }
}
