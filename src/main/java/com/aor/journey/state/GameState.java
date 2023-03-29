package com.aor.journey.state;

import com.aor.journey.model.game.places.Dungeon;
import com.aor.journey.model.game.places.LobbyBuilder;
import com.aor.journey.model.menu.MainMenu;

import java.io.IOException;

public class GameState {
    State currState;

    State lastPlaceState;

    Dungeon dungeon;

    public GameState() throws IOException {
        currState = new MainMenuState(new MainMenu());
        lastPlaceState = new LobbyState(new LobbyBuilder().createPlace());
    }
    public void setCurrState(State state) {
        this.currState = state;
    }
    public State getCurrState() {
        return currState;
    }
    public void setLastPlaceState(State state) {
        this.lastPlaceState = state;
    }
    public State getLastPlaceState() {
        return lastPlaceState;
    }
    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }
    public Dungeon getDungeon() {
        return dungeon;
    }
}
