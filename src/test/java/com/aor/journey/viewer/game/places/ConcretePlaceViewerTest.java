package com.aor.journey.viewer.game.places;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.Warrior;
import com.aor.journey.model.game.places.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class ConcretePlaceViewerTest {
    private GUI gui;

    @BeforeEach
    void setup(){
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void concretePlaceViewerTest() throws IOException {
        Room room = new Room();
        ConcretePlaceViewer concretePlaceViewer = new ConcretePlaceViewer(room);
        concretePlaceViewer.draw(gui);


        Mockito.verify(gui,Mockito.times(1)).drawText(new Position(0,GUI.HEIGHT ), "Lives: " + Warrior.getInstance().getLives() + "/" + Warrior.MAX_LIVES, "#FFD700");
        Mockito.verify(gui,Mockito.times(1)).drawText(new Position(0,GUI.HEIGHT+1 ), "Coins: " + Warrior.getInstance().getCoins(), "#FFD700");
        Mockito.verify(gui,Mockito.times(1)).drawText(new Position(12,GUI.HEIGHT+1 ), "Traps: " + Warrior.getInstance().getCurrTraps() + "/" + Warrior.MAX_TRAPS, "#FFD700");

    }
}

