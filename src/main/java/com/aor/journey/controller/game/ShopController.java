package com.aor.journey.controller.game;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.elements.Warrior;
import com.aor.journey.model.game.places.Shop;
import com.aor.journey.model.menu.MainMenu;
import com.aor.journey.model.menu.ShopMenu;
import com.aor.journey.state.GameState;
import com.aor.journey.state.MainMenuState;
import com.aor.journey.state.ShopMenuState;

import java.io.IOException;

public class ShopController extends PlaceController<Shop> {
    public ShopController(Shop shop) {
        super(shop);
    }
    @Override
    public void step(GameState game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT) {
            game.setLastPlaceState(game.getCurrState());
            game.setCurrState(new MainMenuState(new MainMenu()));
        } else {
            warriorController.step(game, action, time);

            if (getModel().isShopkeeper(Warrior.getInstance().getPosition())) game.setCurrState(new ShopMenuState(new ShopMenu()));

            if (getModel().isPortal(Warrior.getInstance().getPosition())) teleport(game, getModel().getPortalAt(Warrior.getInstance().getPosition()).getType());
        }
    }
}
