package com.aor.journey.viewer.menu;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.Warrior;
import com.aor.journey.model.menu.ShopMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ShopMenuViewerTest {
    private ShopMenu shopMenu;
    private ShopMenuViewer viewer;
    private GUI gui;

    @BeforeEach
    public void setup() {
        shopMenu = new ShopMenu();
        viewer = new ShopMenuViewer(shopMenu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    public void drawElementsTest() {
        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5,5),"Shop","#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0,GUI.HEIGHT ), "Lives: " + Warrior.getInstance().getLives()+ "/" + Warrior.getInstance().MAX_LIVES, "#FFD700");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0,GUI.HEIGHT+1 ), "Coins: " + Warrior.getInstance().getCoins(), "#FFD700");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(12,GUI.HEIGHT+1 ), "Traps: " + Warrior.getInstance().getCurrTraps() + "/" + Warrior.getInstance().MAX_TRAPS, "#FFD700");

        for (int i = 0; i < shopMenu.getNumberEntries(); i++) {
            Mockito.verify(gui, Mockito.times(1)).drawText(
                    new Position(5, 7 + i),shopMenu.getEntry(i),
                    shopMenu.isSelected(i) ? "#FF6347" : "#FFFFFF"
            );
        }
    }

}
