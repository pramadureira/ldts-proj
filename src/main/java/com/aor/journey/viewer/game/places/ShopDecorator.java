package com.aor.journey.viewer.game.places;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.places.Shop;
import com.aor.journey.viewer.game.elements.ShopkeeperViewer;

public class ShopDecorator extends PlaceDecorator<Shop>{
    public ShopDecorator(Shop shop) {
        super(shop);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.setupGameFrame("#5A3A05");
        drawElement(gui, getModel().getShopkeeper(), new ShopkeeperViewer());
        super.drawElements(gui);
    }
}
