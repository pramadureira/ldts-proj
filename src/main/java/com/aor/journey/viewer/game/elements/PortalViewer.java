package com.aor.journey.viewer.game.elements;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.elements.Portal;

public class PortalViewer implements ElementViewer<Portal> {
    @Override
    public void draw(Portal portal, GUI gui) {
        switch (portal.getType()) {
            case LOBBY -> gui.drawElement(portal.getPosition(), '0', "#800080");
            case SHOP -> gui.drawElement(portal.getPosition(), '0', "#FFFF00");
            case HOME -> gui.drawElement(portal.getPosition(), '0', "#964B00");
            case FIREDUNGEON -> gui.drawElement(portal.getPosition(), '0', "#FF0000");
            case METALDUNGEON -> gui.drawElement(portal.getPosition(), '0', "#808080");
            case WATERDUNGEON -> gui.drawElement(portal.getPosition(), '0', "#0000FF");
            case GRASSDUNGEON -> gui.drawElement(portal.getPosition(), '0', "#00FF00");
            case NEXTROOM -> gui.drawElement(portal.getPosition(), '0', "#8080F0");
        }
    }
}
