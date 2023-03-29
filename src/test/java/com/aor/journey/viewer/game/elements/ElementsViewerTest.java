package com.aor.journey.viewer.game.elements;

import com.aor.journey.GUI.GUI;
import com.aor.journey.behaviour.move.FastFollowMove;
import com.aor.journey.behaviour.move.FollowMove;
import com.aor.journey.model.game.elements.*;
import com.aor.journey.model.game.places.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ElementsViewerTest {

    private GUI gui;


    @BeforeEach
    public void setUp() {
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawColourWaterTest() {
        WaterViewer waterViewer = new WaterViewer();
        Water water = new Water(5, 5);
        waterViewer.draw(water, gui);
        Mockito.verify(gui, Mockito.times(1)).drawColour(water.getPosition(), "#0000FF");
    }

    @Test
    void drawElementEggTest() {
        EggViewer eggViewer = new EggViewer();
        EggMonster eggMonster = new EggMonster(5, 5);
        eggViewer.draw(eggMonster, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(eggMonster.getPosition(), 'E', "#FFFFFF");
    }

    @Test
    void drawElementCoinTest() {
        CoinViewer coinViewer = new CoinViewer();
        Coin coin = new Coin(5, 5);
        coinViewer.draw(coin, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(coin.getPosition(), 'O', "#FFFF00");
    }

    @Test
    void drawElementShopkeeperTest() {
        ShopkeeperViewer shopkeeperViewer = new ShopkeeperViewer();
        Shopkeeper shopkeeper = new Shopkeeper(5, 5);
        shopkeeperViewer.draw(shopkeeper, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(shopkeeper.getPosition(), 'U', "#9B7A01");
    }

    @Test
    void drawElementWarriorTest() {
        WarriorViewer warriorViewer = new WarriorViewer();
        Warrior warrior = Warrior.getInstance();
        warriorViewer.draw(warrior, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(warrior.getPosition(), 'W', "#FF0000");
    }

    @Test
    void drawElementMonsterTest() {
        MonsterViewer monsterViewer = new MonsterViewer();
        SimpleMonster simpleMonster = new SimpleMonster(5, 5);
        FireMonster fireMonster = new FireMonster(6, 6);
        MetalMonster metalMonster = new MetalMonster(8,8);
        monsterViewer.draw(simpleMonster, gui);
        monsterViewer.draw(fireMonster, gui);
        monsterViewer.draw(metalMonster,gui);

        Mockito.verify(gui, Mockito.times(1)).drawElement(simpleMonster.getPosition(), 'S', "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawElement(fireMonster.getPosition(), 'F', "#FF0000");
        Mockito.verify(gui, Mockito.times(1)).drawElement(metalMonster.getPosition(), 'M', "#A9A9A9");
    }

    @Test
    void drawWaterMonsterColorTest(){
        WaterMonster waterMonster = new WaterMonster(5, 5);
        MonsterViewer monsterViewer = new MonsterViewer();
        monsterViewer.draw(waterMonster, gui);

        Mockito.verify(gui, Mockito.times(1)).drawElement(waterMonster.getPosition(), 'W', "#0000FF");


        FastFollowMove fastFollowMove = new FastFollowMove();
        waterMonster.setMove(fastFollowMove);
        monsterViewer.draw(waterMonster, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(waterMonster.getPosition(), 'W', "#FF00FF");
    }

    @Test
    void drawEggMonsterColorTest(){
        EggMonster eggMonster = new EggMonster(5,5);
        MonsterViewer monsterViewer = new MonsterViewer();
        monsterViewer.draw(eggMonster,gui);

        Mockito.verify(gui, Mockito.times(1)).drawElement(eggMonster.getPosition(),'E', "#FFFFFF");

        FollowMove followMove = new FollowMove();
        eggMonster.setMove(followMove);
        monsterViewer.draw(eggMonster,gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(eggMonster.getPosition(),'E', "#000000");

    }






    @Test
    void drawElementPortalTest() {
        PortalViewer portalViewer = new PortalViewer();
        Portal portal1 = new Portal(5,5, Portal.Type.SHOP);
        Portal portal2 = new Portal(6,6, Portal.Type.LOBBY);
        Portal portal3 = new Portal(5,5, Portal.Type.FIREDUNGEON);
        Portal portal4 = new Portal(5,5, Portal.Type.METALDUNGEON);
        Portal portal5 = new Portal(5,5, Portal.Type.WATERDUNGEON);
        Portal portal6 = new Portal(5,5, Portal.Type.GRASSDUNGEON);
        Portal portal7 = new Portal(5,5, Portal.Type.NEXTROOM);
        Portal portal8 = new Portal(5,5,Portal.Type.HOME);
        portalViewer.draw(portal1,gui);
        portalViewer.draw(portal2,gui);
        portalViewer.draw(portal3,gui);
        portalViewer.draw(portal4,gui);
        portalViewer.draw(portal5,gui);
        portalViewer.draw(portal6,gui);
        portalViewer.draw(portal7,gui);
        portalViewer.draw(portal8,gui);

        Mockito.verify(gui,Mockito.times(1)).drawElement(portal1.getPosition(), '0', "#FFFF00");
        Mockito.verify(gui,Mockito.times(1)).drawElement(portal2.getPosition(), '0', "#800080");
        Mockito.verify(gui,Mockito.times(1)).drawElement(portal3.getPosition(), '0', "#FF0000");
        Mockito.verify(gui,Mockito.times(1)).drawElement(portal4.getPosition(), '0', "#808080");
        Mockito.verify(gui,Mockito.times(1)).drawElement(portal5.getPosition(), '0', "#0000FF");
        Mockito.verify(gui,Mockito.times(1)).drawElement(portal6.getPosition(), '0', "#00FF00");
        Mockito.verify(gui,Mockito.times(1)).drawElement(portal7.getPosition(), '0', "#8080F0");
        Mockito.verify(gui,Mockito.times(1)).drawElement(portal8.getPosition(), '0', "#8080F0");

    }

    @Test
    void drawElementTrapTest(){
        Trap trap = new Trap(5,5);
        TrapViewer trapViewer = new TrapViewer();
        trapViewer.draw(trap,gui);
        Mockito.verify(gui,Mockito.times(1)).drawElement(trap.getPosition(),'T', "#9B7A01");
    }

    @Test
    void drawElementTrophyTest(){
        Trophy fireTrophy = new Trophy(5,5,Room.Type.FIRE);
        Trophy metalTrophy = new Trophy(5,5,Room.Type.METAL);
        Trophy waterTrophy = new Trophy(5,5,Room.Type.WATER);
        Trophy grassTrophy = new Trophy(5,5,Room.Type.GRASS);
        TrophyViewer trophyViewer = new TrophyViewer();
        trophyViewer.draw(fireTrophy,gui);
        trophyViewer.draw(metalTrophy,gui);
        trophyViewer.draw(waterTrophy,gui);
        trophyViewer.draw(grassTrophy,gui);
        Mockito.verify(gui,Mockito.times(1)).drawElement(fireTrophy.getPosition(), 'F', "#FF0000");
        Mockito.verify(gui,Mockito.times(1)).drawElement(metalTrophy.getPosition(), 'M', "#808080");
        Mockito.verify(gui,Mockito.times(1)).drawElement(waterTrophy.getPosition(), 'W', "#0000FF");
        Mockito.verify(gui,Mockito.times(1)).drawElement(grassTrophy.getPosition(), 'G', "#00FF00");

    }

}

