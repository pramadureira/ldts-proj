package com.aor.journey.controller.menu;

import com.aor.journey.model.menu.GameOverMenu;
import com.aor.journey.model.menu.MainMenu;
import com.aor.journey.state.GameState;
import com.aor.journey.state.MainMenuState;

public class GameOverMenuController extends MenuController<GameOverMenu>{
    public GameOverMenuController(GameOverMenu menu){
        super(menu);
    }

    @Override
    protected void select(GameState game) {
        if (getModel().isSelectedBack()) game.setCurrState(new MainMenuState(new MainMenu()));
        if (getModel().isSelectedQuit()) game.setCurrState(null);
    }
}
