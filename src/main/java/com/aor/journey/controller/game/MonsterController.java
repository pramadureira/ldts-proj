package com.aor.journey.controller.game;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.elements.Monster;
import com.aor.journey.model.game.places.Room;
import com.aor.journey.state.GameState;

import java.util.ArrayList;
import java.util.List;

public class MonsterController extends GameController<Room> {
    public MonsterController(Room room) {
        super(room);
    }

    @Override
    public void step(GameState game, GUI.ACTION action, long time) {
        List<Monster> monsters = new ArrayList<>(getModel().getMonsters());
        for (Monster monster : monsters) {
            boolean monsterMoved = monster.getMove().move(getModel(), time, monster);
            if(monsterMoved){
                monster.update();
                monster.getCollision().collide(getModel(), monster, monster.getPosition());
            }
        }
    }
}
