package com.aor.journey.viewer.game.places;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.places.Place;

public class PlaceDecorator<T extends Place> extends PlaceViewer<T>{
    private ConcretePlaceViewer viewer;
    public PlaceDecorator(T place) {
        super(place);
        this.viewer = new ConcretePlaceViewer(place);
    }

    @Override
    protected void drawElements(GUI gui) {
        viewer.drawElements(gui);
    }
}
