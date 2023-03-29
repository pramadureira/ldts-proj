package com.aor.journey.state;

import com.aor.journey.controller.Controller;
import com.aor.journey.controller.menu.ShopMenuController;
import com.aor.journey.model.menu.ShopMenu;
import com.aor.journey.viewer.Viewer;
import com.aor.journey.viewer.menu.ShopMenuViewer;

public class ShopMenuState extends MenuState<ShopMenu>{
    public ShopMenuState(ShopMenu menu) { super(menu); }
    protected Viewer<ShopMenu> getViewer() { return new ShopMenuViewer(getModel()); }
    protected Controller<ShopMenu> getController() { return new ShopMenuController(getModel()); }
}
