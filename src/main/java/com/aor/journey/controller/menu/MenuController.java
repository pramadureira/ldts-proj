package com.aor.journey.controller.menu;


import com.aor.journey.GUI.GUI;
import com.aor.journey.controller.Controller;
import com.aor.journey.model.menu.Menu;
import com.aor.journey.state.GameState;

import java.io.IOException;

public abstract class MenuController<T extends Menu> extends Controller<T> {
    public MenuController(T model) {
        super(model);
    }

    @Override
    public void step(GameState game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP -> getModel().previousEntry();
            case DOWN -> getModel().nextEntry();
            case SELECT -> {
                select(game);
            }
        }
    }

    protected abstract void select(GameState game) throws IOException;
}
