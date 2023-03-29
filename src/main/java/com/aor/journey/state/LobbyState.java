package com.aor.journey.state;

import com.aor.journey.controller.Controller;
import com.aor.journey.controller.game.LobbyController;
import com.aor.journey.model.game.places.Lobby;
import com.aor.journey.viewer.Viewer;
import com.aor.journey.viewer.game.places.LobbyDecorator;

public class LobbyState extends PlaceState<Lobby> {
    public LobbyState(Lobby lobby) { super(lobby); }
    protected Viewer<Lobby> getViewer(){
        return new LobbyDecorator(getModel());
    }
    protected Controller<Lobby> getController(){
        return new LobbyController(getModel());
    }
}
