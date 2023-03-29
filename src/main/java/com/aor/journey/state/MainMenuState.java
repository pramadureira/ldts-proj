package com.aor.journey.state;

import com.aor.journey.controller.Controller;
import com.aor.journey.controller.menu.MainMenuController;
import com.aor.journey.model.menu.MainMenu;
import com.aor.journey.viewer.Viewer;
import com.aor.journey.viewer.menu.MainMenuViewer;

public class MainMenuState extends MenuState<MainMenu>{
    public MainMenuState(MainMenu menu) { super(menu); }
    protected Viewer<MainMenu> getViewer(){
        return new MainMenuViewer(getModel());
    }
    protected Controller<MainMenu> getController(){
        return new MainMenuController(getModel());
    }
}
