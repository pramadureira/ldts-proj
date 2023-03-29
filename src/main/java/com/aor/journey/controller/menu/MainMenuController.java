package com.aor.journey.controller.menu;

import com.aor.journey.model.menu.HelperMenu;
import com.aor.journey.model.menu.MainMenu;
import com.aor.journey.state.GameState;
import com.aor.journey.state.HelperMenuState;

public class MainMenuController extends MenuController<MainMenu> {
    public MainMenuController(MainMenu menu){
        super(menu);
    }

    @Override
    protected void select(GameState game) {
        if (getModel().isSelectedQuit()) game.setCurrState(null);
        if (getModel().isSelectedStart()) game.setCurrState(game.getLastPlaceState());
        if (getModel().isSelectedHelp()) game.setCurrState(new HelperMenuState(new HelperMenu()));
    }
}
