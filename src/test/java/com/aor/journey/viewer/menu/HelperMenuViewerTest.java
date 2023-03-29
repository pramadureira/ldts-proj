package com.aor.journey.viewer.menu;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.Position;
import com.aor.journey.model.menu.HelperMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class HelperMenuViewerTest {
    private HelperMenu helperMenu;
    private HelperMenuViewer viewer;
    private GUI gui;

    @BeforeEach
    public void setup() {
        helperMenu = new HelperMenu();
        viewer = new HelperMenuViewer(helperMenu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    public void drawElementsTest() {
        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(2,2),"Use the arrows to move","#FFFFFF");

        for (int i = 0; i < helperMenu.getNumberEntries(); i++) {
            Mockito.verify(gui, Mockito.times(1)).drawText(
                    new Position(gui.WIDTH/3+2, 20 + i),helperMenu.getEntry(i),
                    helperMenu.isSelected(i) ? "#FF6347" : "#FFFFFF"
            );
        }
    }
}
