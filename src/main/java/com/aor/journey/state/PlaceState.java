package com.aor.journey.state;

import com.aor.journey.model.game.places.Place;

public abstract class PlaceState<T extends Place> extends State<T>{
    public PlaceState(T model) {
        super(model);
    }
}
