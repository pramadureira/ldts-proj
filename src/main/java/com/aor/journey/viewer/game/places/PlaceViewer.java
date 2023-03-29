package com.aor.journey.viewer.game.places;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.elements.Element;
import com.aor.journey.viewer.Viewer;
import com.aor.journey.viewer.game.elements.ElementViewer;

import java.util.List;

public abstract class PlaceViewer<P> extends Viewer<P> {

    public PlaceViewer(P place){
        super(place);
    }

    protected <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    protected <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
