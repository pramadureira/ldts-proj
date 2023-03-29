package com.aor.journey.controller.game;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.elements.Portal;
import com.aor.journey.model.game.elements.Warrior;
import com.aor.journey.model.game.places.Lobby;
import com.aor.journey.model.game.places.Room;
import com.aor.journey.state.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaceControllerTest {
    private GameState game;

    @BeforeEach
    void setUp() throws IOException {
        game = new GameState();
    }

    @Test
    void teleportTest() throws IOException {
        LobbyController controller = new LobbyController(new Lobby());
        controller.teleport(game, Portal.Type.SHOP);
        assertTrue(game.getCurrState() instanceof ShopState);
        controller.teleport(game, Portal.Type.LOBBY);
        assertTrue(game.getCurrState() instanceof LobbyState);
        controller.teleport(game,Portal.Type.HOME);
        assertTrue(game.getCurrState() instanceof HomeState);
        controller.teleport(game, Portal.Type.FIREDUNGEON);
        assertTrue(game.getCurrState() instanceof RoomState);
        controller.teleport(game, Portal.Type.WATERDUNGEON);
        assertTrue(game.getCurrState() instanceof RoomState);
        controller.teleport(game, Portal.Type.METALDUNGEON);
        assertTrue(game.getCurrState() instanceof RoomState);
        controller.teleport(game, Portal.Type.GRASSDUNGEON);
        assertTrue(game.getCurrState() instanceof RoomState);
    }

    @Test
    void roomControllerTest() throws IOException {
        RoomController roomController = new RoomController(new Room());
        roomController.step(game,GUI.ACTION.QUIT,1);
        assertTrue(game.getCurrState() instanceof MainMenuState);

        for (int i = 0; i<5;i++){
            Warrior.getInstance().decreaseLives();
        }
        roomController.step(game,GUI.ACTION.NONE,1);
        assertTrue(game.getCurrState() instanceof GameOverMenuState);
        assertTrue(game.getLastPlaceState() instanceof LobbyState);
    }

    @Test
    void stepTest() throws IOException {
        LobbyController controller = new LobbyController(new Lobby());
        controller.step(game, GUI.ACTION.QUIT, 1);
        assertTrue(game.getCurrState() instanceof MainMenuState);
    }

}
