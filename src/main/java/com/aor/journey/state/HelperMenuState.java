package com.aor.journey.state;

import com.aor.journey.controller.Controller;
import com.aor.journey.controller.menu.HelperMenuController;
import com.aor.journey.model.menu.HelperMenu;
import com.aor.journey.viewer.Viewer;
import com.aor.journey.viewer.menu.HelperMenuViewer;

public class HelperMenuState extends MenuState<HelperMenu>{
    public HelperMenuState(HelperMenu menu) { super(menu); }
    protected Viewer<HelperMenu> getViewer(){
        return new HelperMenuViewer(getModel());
    }
    protected Controller<HelperMenu> getController(){
        return new HelperMenuController(getModel());
    }
}
