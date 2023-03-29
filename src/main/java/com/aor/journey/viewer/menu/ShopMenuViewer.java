package com.aor.journey.viewer.menu;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.Warrior;
import com.aor.journey.model.menu.ShopMenu;

public class ShopMenuViewer extends MenuViewer<ShopMenu> {
    public ShopMenuViewer(ShopMenu menu){
        super(menu);
    }
    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(5,5),"Shop","#FFFFFF");
        gui.drawText(new Position(0,GUI.HEIGHT ), "Lives: " + Warrior.getInstance().getLives()+ "/" + Warrior.getInstance().MAX_LIVES, "#FFD700");
        gui.drawText(new Position(0,GUI.HEIGHT+1 ), "Coins: " + Warrior.getInstance().getCoins(), "#FFD700");
        gui.drawText(new Position(12,GUI.HEIGHT+1 ), "Traps: " + Warrior.getInstance().getCurrTraps() + "/" + Warrior.getInstance().MAX_TRAPS, "#FFD700");
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 7 + i),getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FF6347" : "#FFFFFF");
    }
}
