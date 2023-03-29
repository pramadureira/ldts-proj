package com.aor.journey.viewer.menu;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.Position;
import com.aor.journey.model.menu.MainMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MainMenuViewerTest {
    private MainMenu mainMenu;
    private MainMenuViewer viewer;
    private GUI gui;

    @BeforeEach
    public void setUp() {
        mainMenu = new MainMenu();
        viewer = new MainMenuViewer(mainMenu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    public void drawElementsTest() {
        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(GUI.WIDTH/3+2,5),"Menu","#FFFFFF");

        for (int i = 0; i < mainMenu.getNumberEntries(); i++) {
            Mockito.verify(gui, Mockito.times(1)).drawText(
                    new Position(GUI.WIDTH/3+2, 7 + i), mainMenu.getEntry(i),
                    mainMenu.isSelected(i) ? "#FF6347" : "#FFFFFF"
            );
        }
    }
}