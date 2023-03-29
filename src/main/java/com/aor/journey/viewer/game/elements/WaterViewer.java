package com.aor.journey.viewer.game.elements;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.elements.Water;

public class WaterViewer implements ElementViewer<Water> {
    @Override
    public void draw(Water water, GUI gui) {
        gui.drawColour(water.getPosition(), "#0000FF");
    }
}
