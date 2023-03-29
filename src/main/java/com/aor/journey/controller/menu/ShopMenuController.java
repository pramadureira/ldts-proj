package com.aor.journey.controller.menu;

import com.aor.journey.model.game.elements.Warrior;
import com.aor.journey.model.game.places.ShopBuilder;
import com.aor.journey.model.menu.ShopMenu;
import com.aor.journey.state.GameState;
import com.aor.journey.state.ShopState;

import java.io.IOException;


public class ShopMenuController extends MenuController<ShopMenu> {
    public ShopMenuController(ShopMenu menu){
        super(menu);
    }

    @Override
    protected void select(GameState game) throws IOException {
        if (getModel().isSelectedLives()) {
            if (Warrior.getInstance().getCoins() >= 5 && Warrior.getInstance().getLives() < Warrior.MAX_LIVES) {
                Warrior.getInstance().increaseLives();
                Warrior.getInstance().useCoins(5);
            }
        }
        if (getModel().isSelectedTraps()) {
            if(Warrior.getInstance().getCoins() >= 10 && Warrior.getInstance().getCurrTraps() < Warrior.MAX_TRAPS){
                Warrior.getInstance().increaseCurrTraps();
                Warrior.getInstance().useCoins(10);
            }
        }
        if (getModel().isSelectedClose())
            game.setCurrState(new ShopState(new ShopBuilder().createPlace()));
    }
}
