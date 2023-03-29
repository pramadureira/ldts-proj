package com.aor.journey.model.game.places;

import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.Shopkeeper;

public class  Shop extends Place{
    Shopkeeper shopkeeper;

    public Shopkeeper getShopkeeper() {
        return shopkeeper;
    }

    public void setShopkeeper(Shopkeeper shopkeeper) {
        this.shopkeeper = shopkeeper;
    }

    public boolean isShopkeeper(Position position){
        return shopkeeper.getPosition().equals(position);
    }
}
