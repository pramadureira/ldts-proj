package com.aor.journey.viewer.game.elements;

import com.aor.journey.GUI.GUI;
import com.aor.journey.behaviour.move.FastFollowMove;
import com.aor.journey.behaviour.move.HatchingMove;
import com.aor.journey.model.game.elements.*;

public class MonsterViewer implements ElementViewer<Monster> {

    @Override
    public void draw(Monster monster, GUI gui) {
        if(monster instanceof SimpleMonster) gui.drawElement(monster.getPosition(), 'S', "#000000");
        if(monster instanceof FireMonster) gui.drawElement(monster.getPosition(), 'F', "#FF0000");
        if(monster instanceof WaterMonster) gui.drawElement(monster.getPosition(), 'W', monster.getMove() instanceof FastFollowMove ? "#FF00FF" : "#0000FF");
        if(monster instanceof MetalMonster) gui.drawElement(monster.getPosition(), 'M', "#A9A9A9");
        if(monster instanceof EggMonster) gui.drawElement(monster.getPosition(), 'E', monster.getMove() instanceof HatchingMove ? "#FFFFFF" : "#000000");
    }
}
