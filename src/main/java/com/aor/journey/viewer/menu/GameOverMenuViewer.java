package com.aor.journey.viewer.menu;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.Position;
import com.aor.journey.model.menu.GameOverMenu;

public class GameOverMenuViewer extends MenuViewer<GameOverMenu> {

    public GameOverMenuViewer(GameOverMenu menu){
        super(menu);
    }
    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(5,5),"You are dead.","#FFFFFF");
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(gui.WIDTH/2 - getModel().getEntry(i).length(), 7 + i),getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FF6347" : "#FFFFFF");
    }
}
