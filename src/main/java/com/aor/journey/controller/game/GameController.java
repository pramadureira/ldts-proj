package com.aor.journey.controller.game;

import com.aor.journey.controller.Controller;

public abstract class GameController<P> extends Controller<P> {
    public GameController(P place) {
        super(place);
    }
}