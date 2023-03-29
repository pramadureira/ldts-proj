package com.aor.journey.viewer.game.elements;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.elements.Warrior;

public class WarriorViewer implements ElementViewer<Warrior> {
    @Override
    public void draw(Warrior warrior, GUI gui) {
        gui.drawElement(warrior.getPosition(),'W', warrior.isWet() ? "#ADD8E6" : "#FF0000");
    }
}
