package com.aor.journey.model.game.places;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.Portal;
import com.aor.journey.model.game.elements.Trap;
import com.aor.journey.model.game.elements.Wall;

import java.util.ArrayList;
import java.util.List;

public abstract class Place {
    private final int width;
    private final int height;
    protected List<Wall> walls = new ArrayList<>();
    protected List<Portal> portals = new ArrayList<>();
    protected List<Trap> traps = new ArrayList<>();

    public Place(){
        width = GUI.WIDTH;
        height = GUI.HEIGHT;
    }
    public void setWalls(List<Wall> walls){
        this.walls = walls;
    }
    public List<Wall> getWalls() {
        return walls;
    }
    public void setPortals(List<Portal> portals) {
        this.portals = portals;
    }
    public List<Portal> getPortals() {
        return portals;
    }
    public List<Trap> getTraps() {
        return traps;
    }
    public void addTrap(Trap trap) {
        traps.add(trap);
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }


    public boolean isPortal(Position position){
        for(Portal portal: portals)
            if(portal.getPosition().equals(position))
                return true;
        return false;
    }

    public Portal getPortalAt(Position position){
        for(Portal portal: portals)
            if(portal.getPosition().equals(position))
                return portal;
        return portals.get(0);
    }

    public boolean removeTrapAt(Position position){
        for(Trap trap: traps)
            if(trap.getPosition().equals(position)) {
                traps.remove(trap);
                return true;
            }
        return false;
    }
}
