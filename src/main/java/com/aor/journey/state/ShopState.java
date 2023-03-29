package com.aor.journey.state;

import com.aor.journey.controller.Controller;
import com.aor.journey.controller.game.ShopController;
import com.aor.journey.model.game.places.Shop;
import com.aor.journey.viewer.Viewer;
import com.aor.journey.viewer.game.places.ShopDecorator;

public class ShopState extends PlaceState<Shop> {
    public ShopState(Shop shop) { super(shop); }
    protected Viewer<Shop> getViewer(){
        return new ShopDecorator(getModel());
    }
    protected Controller<Shop> getController(){
        return new ShopController(getModel());
    }
}
