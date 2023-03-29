package com.aor.journey.viewer.game.places;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.places.Lobby;

public class LobbyDecorator extends PlaceDecorator<Lobby> {
    public LobbyDecorator(Lobby lobby) {
        super(lobby);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.setupGameFrame("#006400");
        super.drawElements(gui);
    }
}