package com.aor.journey.viewer.game.places;

import com.aor.journey.GUI.GUI;
import com.aor.journey.model.game.Position;
import com.aor.journey.model.game.elements.*;
import com.aor.journey.model.game.places.Home;
import com.aor.journey.model.game.places.Lobby;
import com.aor.journey.model.game.places.Room;
import com.aor.journey.model.game.places.Shop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class DecoratorTest {
    private GUI gui;

    @BeforeEach
    void setUp(){
        gui = Mockito.mock(GUI.class);
        Warrior.resetInstance();
    }
    @Test
    void roomDecoratorTest() {
        Room room = new Room();
        RoomDecorator roomDecorator = new RoomDecorator(room);
        room.setWaters(Arrays.asList(new Water(1, 1), new Water(2, 2), new Water(3, 3)));
        room.setCoins(Arrays.asList(new Coin(1, 1), new Coin(2, 2), new Coin(3, 3)));
        room.setMonsters(Arrays.asList(new EggMonster(1, 1), new SimpleMonster(1,1),new FireMonster(1,1),
                new WaterMonster(1,1),new MetalMonster(1,1)));
        roomDecorator.drawElements(gui);

        Mockito.verify(gui, Mockito.times(1)).drawColour(new Position(1, 1), "#0000FF"); // Draw Water Test
        Mockito.verify(gui, Mockito.times(3)).drawColour(Mockito.any(Position.class), Mockito.any(String.class)); // DrawColour Test

        Mockito.verify(gui,Mockito.times(1)).drawElement(new Position(0,0),'W',"#FF0000"); // Draw Warrior Test
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(1,1), 'O', "#FFFF00"); // Draw Coin Test
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(1,1), 'E', "#FFFFFF"); // Draw Egg Test
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(1,1), 'S', "#000000"); // Draw SimpleMonster test

        Mockito.verify(gui, Mockito.times(9)).drawElement(Mockito.any(Position.class),Mockito.any(Character.class),Mockito.any(String.class)); // DrawElement Test
        Mockito.verify(gui,Mockito.times(1)).setupGameFrame("#696969");
    }
    @Test
    void shopDecoratorTest(){
        Shop shop = new Shop();
        ShopDecorator shopDecorator = new ShopDecorator(shop);
        Shopkeeper shopkeeper = new Shopkeeper(5,5);
        shop.setShopkeeper(shopkeeper);
        shopDecorator.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(shopkeeper.getPosition(),'U', "#9B7A01");
        Mockito.verify(gui,Mockito.times(1)).setupGameFrame("#5A3A05");
    }

    @Test
    void lobbyDecoratorTest() {
        Lobby lobby = new Lobby();
        LobbyDecorator lobbyDecorator = new LobbyDecorator(lobby);
        lobby.setWalls(Arrays.asList(new Wall(1,1)));
        lobby.setPortals(Arrays.asList(new Portal(1,1, Portal.Type.SHOP),new Portal(1,2, Portal.Type.HOME),
                new Portal(1,3, Portal.Type.FIREDUNGEON),new Portal(1,4, Portal.Type.GRASSDUNGEON),
                new Portal(1,5, Portal.Type.WATERDUNGEON),new Portal(1,6, Portal.Type.METALDUNGEON)));
        lobbyDecorator.drawElements(gui);
        Mockito.verify(gui,Mockito.times(1)).drawColour(new Position(1,1),"#808080");
        Mockito.verify(gui,Mockito.times(1)).drawElement(new Position(1,1), '0', "#FFFF00");
        Mockito.verify(gui,Mockito.times(1)).drawElement(new Position(1,2), '0', "#964B00");
        Mockito.verify(gui,Mockito.times(1)).drawElement(new Position(1,3), '0', "#FF0000");
        Mockito.verify(gui,Mockito.times(1)).drawElement(new Position(1,4), '0', "#00FF00");
        Mockito.verify(gui,Mockito.times(1)).drawElement(new Position(1,5), '0', "#0000FF");
        Mockito.verify(gui,Mockito.times(1)).drawElement(new Position(1,6), '0', "#808080");

        Mockito.verify(gui,Mockito.times(1)).setupGameFrame("#006400");

    }

    @Test
    void homeDecoratorTest(){
        Home home = new Home();
        HomeDecorator homeDecorator = new HomeDecorator(home);
        home.setTrophies(Arrays.asList(new Trophy(1,1,Room.Type.FIRE)));
        homeDecorator.drawElements(gui);
        Mockito.verify(gui,Mockito.times(1)).drawElement(new Position(1,1), 'F', "#FF0000");
        Mockito.verify(gui,Mockito.times(1)).setupGameFrame("#5A3A05");

    }

}
