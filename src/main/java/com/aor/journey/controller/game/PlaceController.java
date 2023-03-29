package com.aor.journey.controller.game;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.elements.Portal;
import com.aor.journey.model.game.elements.Warrior;
import com.aor.journey.model.game.places.*;
import com.aor.journey.model.menu.MainMenu;
import com.aor.journey.state.*;

import java.io.IOException;

public abstract class  PlaceController<T extends Place> extends GameController<T> {
    protected final WarriorController warriorController;
    public PlaceController(T place) {
        super(place);
        this.warriorController = new WarriorController(place);
    }

    @Override
    public void step(GameState game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT) {
            game.setLastPlaceState(game.getCurrState());
            game.setCurrState(new MainMenuState(new MainMenu()));
        } else {
            warriorController.step(game, action, time);

            if (getModel().isPortal(Warrior.getInstance().getPosition())) teleport(game, getModel().getPortalAt(Warrior.getInstance().getPosition()).getType());
        }
    }

    protected void teleport(GameState game, Portal.Type type) throws IOException {
        Warrior.getInstance().setCurrTraps(Warrior.getInstance().getCurrTraps()+getModel().getTraps().size());
        switch (type) {
            case SHOP -> game.setCurrState(new ShopState(new ShopBuilder().createPlace()));
            case LOBBY -> game.setCurrState(new LobbyState(new LobbyBuilder().createPlace()));
            case HOME -> game.setCurrState(new HomeState(new HomeBuilder().createPlace()));
            case FIREDUNGEON -> {
                game.setDungeon(new Dungeon("fire"));
                game.setCurrState(new RoomState(game.getDungeon().getCurrentRoom()));
            }
            case METALDUNGEON -> {
                game.setDungeon(new Dungeon("metal"));
                game.setCurrState(new RoomState(game.getDungeon().getCurrentRoom()));
            }
            case WATERDUNGEON -> {
                game.setDungeon(new Dungeon("water"));
                game.setCurrState(new RoomState(game.getDungeon().getCurrentRoom()));
            }
            case GRASSDUNGEON -> {
                game.setDungeon(new Dungeon("grass"));
                game.setCurrState(new RoomState(game.getDungeon().getCurrentRoom()));
            }
            case NEXTROOM -> {
                if(game.getDungeon().moveToNextRoom()){
                    game.setCurrState(new RoomState(game.getDungeon().getCurrentRoom()));
                } else {
                    Warrior.getInstance().getTrophies().put(game.getDungeon().getCurrentRoom().getType(), true);
                    game.setCurrState(new LobbyState(new LobbyBuilder().createPlace()));
                }
            }
        }
    }
}
