package com.aor.journey.state;

import com.aor.journey.controller.Controller;
import com.aor.journey.controller.game.HomeController;
import com.aor.journey.model.game.places.Home;
import com.aor.journey.viewer.Viewer;
import com.aor.journey.viewer.game.places.HomeDecorator;

public class HomeState extends PlaceState<Home> {
    public HomeState(Home home) { super(home); }
    protected Viewer<Home> getViewer(){
        return new HomeDecorator(getModel());
    }
    protected Controller<Home> getController(){
        return new HomeController(getModel());
    }
}