package com.aor.journey.controller.game;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.elements.Warrior;
import com.aor.journey.model.game.places.LobbyBuilder;
import com.aor.journey.model.game.places.Room;
import com.aor.journey.model.menu.GameOverMenu;
import com.aor.journey.model.menu.MainMenu;
import com.aor.journey.state.GameOverMenuState;
import com.aor.journey.state.GameState;
import com.aor.journey.state.LobbyState;
import com.aor.journey.state.MainMenuState;

import java.io.IOException;

public class RoomController extends PlaceController<Room>{
    private final MonsterController monsterController;
    public RoomController(Room room) {
        super(room);
        this.monsterController = new MonsterController(room);
    }

    @Override
    public void step(GameState game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT) {
            game.setLastPlaceState(game.getCurrState());
            game.setCurrState(new MainMenuState(new MainMenu()));
        } else if (Warrior.getInstance().getLives() <= 0) {
            Warrior.resetInstance();
            game.setLastPlaceState(new LobbyState(new LobbyBuilder().createPlace()));
            game.setCurrState(new GameOverMenuState(new GameOverMenu()));
        } else {
            warriorController.step(game, action, time);
            monsterController.step(game, action, time);

            if (getModel().isPortal(Warrior.getInstance().getPosition())) teleport(game, getModel().getPortalAt(Warrior.getInstance().getPosition()).getType());
        }
    }
}
