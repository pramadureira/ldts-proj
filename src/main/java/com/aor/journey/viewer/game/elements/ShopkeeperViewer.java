package com.aor.journey.viewer.game.elements;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.elements.Shopkeeper;

public class ShopkeeperViewer implements ElementViewer<Shopkeeper> {
    @Override
    public void draw(Shopkeeper shopkeeper, GUI gui) {
        gui.drawElement(shopkeeper.getPosition(),'U', "#9B7A01");
    }
}
