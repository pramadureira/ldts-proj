package com.aor.journey.model.game.places;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dungeon {
    private List<Room> rooms;
    private Room currentRoom;
    private Room.Type type;

    public Dungeon(String dungeonName) throws IOException {
        this.rooms = new ArrayList<>();
        this.currentRoom = null;
        if(Objects.equals(dungeonName, "fire")) type = Room.Type.FIRE;
        else if(Objects.equals(dungeonName, "water")) type = Room.Type.WATER;
        else if(Objects.equals(dungeonName, "metal")) type = Room.Type.METAL;
        else if(Objects.equals(dungeonName, "grass")) type = Room.Type.GRASS;

        for (int i = 1; i <= 3; i++) {
            this.addRoom(new RoomBuilder(dungeonName + "/" + dungeonName + i).createPlace());
        }
    }

    public void addRoom(Room room) {
        room.setType(type);
        this.rooms.add(room);

        if (this.currentRoom == null) {
            this.currentRoom = room;
        }
    }

    public List<Room> getRooms(){
        return rooms;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public boolean moveToNextRoom() {
        int currentIndex = this.rooms.indexOf(this.currentRoom);

        if (currentIndex < this.rooms.size() - 1) {
            this.currentRoom = this.rooms.get(currentIndex + 1);
            return true;
        }
        return false;
    }
}