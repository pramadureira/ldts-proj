package com.aor.journey.controller.menu;

import com.aor.journey.model.menu.HelperMenu;
import com.aor.journey.model.menu.MainMenu;
import com.aor.journey.state.GameState;
import com.aor.journey.state.MainMenuState;

public class HelperMenuController extends MenuController<HelperMenu> {
    public HelperMenuController(HelperMenu menu){
        super(menu);
    }

    @Override
    protected void select(GameState game) {
        game.setCurrState(new MainMenuState(new MainMenu()));
    }
}