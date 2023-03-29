package com.aor.journey.viewer.game.places;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.places.Room;
import com.aor.journey.viewer.game.elements.CoinViewer;
import com.aor.journey.viewer.game.elements.MonsterViewer;
import com.aor.journey.viewer.game.elements.WaterViewer;

public class RoomDecorator extends PlaceDecorator<Room> {
    public RoomDecorator(Room room) {
        super(room);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.setupGameFrame("#696969");
        drawElements(gui, getModel().getWaters(), new WaterViewer());
        drawElements(gui, getModel().getCoins(), new CoinViewer());
        drawElements(gui, getModel().getMonsters(), new MonsterViewer());
        super.drawElements(gui);
    }
}
