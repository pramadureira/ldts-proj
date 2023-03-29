package com.aor.journey.viewer.menu;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.Position;
import com.aor.journey.model.menu.MainMenu;

public class MainMenuViewer extends MenuViewer<MainMenu> {
    public MainMenuViewer(MainMenu menu){
        super(menu);
    }
    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(gui.WIDTH/3+2,5),"Menu","#FFFFFF");
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(gui.WIDTH/3+2, 7 + i),getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FF6347" : "#FFFFFF");
    }
}
