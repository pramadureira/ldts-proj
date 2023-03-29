package com.aor.journey.viewer.game.places;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.places.Home;
import com.aor.journey.viewer.game.elements.TrophyViewer;

public class HomeDecorator extends PlaceDecorator<Home> {
    public HomeDecorator(Home home) {
        super(home);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.setupGameFrame("#5A3A05");
        drawElements(gui, getModel().getTrophies(), new TrophyViewer());
        super.drawElements(gui);
    }
}