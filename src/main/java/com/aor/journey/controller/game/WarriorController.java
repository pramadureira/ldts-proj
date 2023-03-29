package com.aor.journey.controller.game;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.Monster;
import com.aor.journey.model.game.elements.Trap;
import com.aor.journey.model.game.elements.Warrior;
import com.aor.journey.model.game.places.Place;
import com.aor.journey.model.game.places.Room;
import com.aor.journey.state.GameState;

import java.io.IOException;

public class WarriorController extends GameController<Place> {
    public WarriorController(Place place) {
        super(place);
    }

    public void moveWarriorUp() {
        moveWarrior(Warrior.getInstance().getPosition().getUp());
    }
    public void moveWarriorDown() {
        moveWarrior(Warrior.getInstance().getPosition().getDown());
    }
    public void moveWarriorLeft() {
        moveWarrior(Warrior.getInstance().getPosition().getLeft());
    }
    public void moveWarriorRight() {
        moveWarrior(Warrior.getInstance().getPosition().getRight());
    }
    @Override
    public void step(GameState game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP -> moveWarriorUp();
            case RIGHT -> moveWarriorRight();
            case DOWN -> moveWarriorDown();
            case LEFT -> moveWarriorLeft();
            case USE -> placeTrap();
            case INTERACT ->  collectTrap();
        }
    }

    protected void moveWarrior(Position position) {
        if (getModel().isEmpty(position)) {
            Warrior.getInstance().setPosition(position);
            if (getModel() instanceof Room) detectWarriorCollisions(position);
        }
    }

    private void placeTrap(){
        if(Warrior.getInstance().getCurrTraps() > 0){
            Warrior.getInstance().decreaseCurrTraps();
            getModel().addTrap(new Trap(Warrior.getInstance().getPosition()));
        }
    }

    private void collectTrap(){
        if(getModel().removeTrapAt(Warrior.getInstance().getPosition())){
            Warrior.getInstance().increaseCurrTraps();
        }
    }

    private void detectWarriorCollisions(Position position){
        Room room = (Room) getModel();
        Monster monster = room.getMonster(position);
        if (monster != null) monster.getCollision().collide(room, monster, position);
        if (room.isCoin(position)) {
            Warrior.getInstance().increaseCoins();
            room.removeCoin(position);
        }
        if (room.isWater(position))
            Warrior.getInstance().wet();
    }
}
