package com.aor.journey.state;

import com.aor.journey.controller.Controller;
import com.aor.journey.controller.menu.GameOverMenuController;
import com.aor.journey.model.menu.GameOverMenu;
import com.aor.journey.viewer.Viewer;
import com.aor.journey.viewer.menu.GameOverMenuViewer;

public class GameOverMenuState extends MenuState<GameOverMenu>{
    public GameOverMenuState(GameOverMenu menu) { super(menu); }
    protected Viewer<GameOverMenu> getViewer(){
        return new GameOverMenuViewer(getModel());
    }
    protected Controller<GameOverMenu> getController(){
        return new GameOverMenuController(getModel());
    }
}
