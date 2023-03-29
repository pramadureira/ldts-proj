package com.aor.journey.viewer.game.elements;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.elements.Coin;

public class CoinViewer implements ElementViewer<Coin> {
    @Override
    public void draw(Coin coin, GUI gui) {
        gui.drawElement(coin.getPosition(),'O', "#FFFF00");
    }
}
