package com.aor.journey.viewer.game.elements;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawColour(wall.getPosition(), "#808080");
    }
}
