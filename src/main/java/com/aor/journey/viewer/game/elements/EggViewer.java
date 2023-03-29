package com.aor.journey.viewer.game.elements;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.elements.EggMonster;

public class EggViewer implements ElementViewer<EggMonster> {
    public void draw(EggMonster eggMonster, GUI gui) {
        gui.drawElement(eggMonster.getPosition(),'E', "#FFFFFF");
    }
}
