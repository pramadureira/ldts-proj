package com.aor.journey.viewer.game.elements;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.elements.Trap;

public class TrapViewer implements ElementViewer<Trap> {
    @Override
    public void draw(Trap trap, GUI gui) {
        gui.drawElement(trap.getPosition(),'T', "#9B7A01");
    }
}
