package com.aor.journey.state;

import com.aor.journey.controller.Controller;
import com.aor.journey.controller.game.RoomController;
import com.aor.journey.model.game.places.Room;
import com.aor.journey.viewer.Viewer;
import com.aor.journey.viewer.game.places.RoomDecorator;

public class RoomState extends PlaceState<Room> {
    public RoomState(Room room) { super(room); }
    protected Viewer<Room> getViewer(){
        return new RoomDecorator(getModel());
    }
    protected Controller<Room> getController(){
        return new RoomController(getModel());
    }
}
