package com.aor.journey.viewer.menu;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.Position;
import com.aor.journey.model.menu.HelperMenu;

public class HelperMenuViewer extends MenuViewer<HelperMenu> {
    public HelperMenuViewer(HelperMenu menu){
        super(menu);
    }
    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(2,2),"Use the arrows to move","#FFFFFF");
        gui.drawText(new Position(2,3),"X to place traps","#FFFFFF");
        gui.drawText(new Position(2,4),"Z to collect traps","#FFFFFF");
        gui.drawText(new Position(2,5),"Q to open the menu","#FFFFFF");
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(gui.WIDTH/3+2, 20 + i),getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FF6347" : "#FFFFFF");
    }
}
