package com.aor.journey.viewer.game.elements;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.elements.Trophy;

public class TrophyViewer implements ElementViewer<Trophy> {
    @Override
    public void draw(Trophy trophy, GUI gui) {
        switch (trophy.getType()){
            case FIRE -> gui.drawElement(trophy.getPosition(), 'F', "#FF0000");
            case METAL -> gui.drawElement(trophy.getPosition(), 'M', "#808080");
            case WATER -> gui.drawElement(trophy.getPosition(), 'W', "#0000FF");
            case GRASS -> gui.drawElement(trophy.getPosition(), 'G', "#00FF00");
        }
    }
}
