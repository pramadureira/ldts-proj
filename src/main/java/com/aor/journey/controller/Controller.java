package com.aor.journey.controller;

import com.aor.journey.GUI.GUI;
import com.aor.journey.state.GameState;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(GameState game, GUI.ACTION action, long time) throws IOException;
}
