package com.aor.journey.model.game.elements;

import com.aor.journey.behaviour.collision.SimpleCollision;
import com.aor.journey.behaviour.collision.SmashCollision;
import com.aor.journey.behaviour.collision.WaterCollision;
import com.aor.journey.behaviour.move.*;
import com.aor.journey.model.game.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MonsterTest {
    @Test
    void simpleMonsterTest(){
        SimpleMonster simpleMonster = new SimpleMonster(5,5);
        assertTrue(simpleMonster.getMove() instanceof RandomMove);
        assertTrue(simpleMonster.getCollision() instanceof SimpleCollision);

        simpleMonster.update();

        assertTrue(simpleMonster.getMove() instanceof RandomMove);
        assertTrue(simpleMonster.getCollision() instanceof SimpleCollision);
    }

    @Test
    void fireMonsterTest(){
        FireMonster fireMonster = new FireMonster(5,5);
        assertTrue(fireMonster.getMove() instanceof FastRandomMove);
        assertTrue(fireMonster.getCollision() instanceof WaterCollision);

        fireMonster.update();

        assertTrue(fireMonster.getMove() instanceof FastRandomMove);
        assertTrue(fireMonster.getCollision() instanceof WaterCollision);
    }

    @Test
    void waterMonsterTest(){
        WaterMonster waterMonster = new WaterMonster(5,5);
        for (int i = 0; i < 5;i++) {
            assertTrue(waterMonster.getMove() instanceof RandomMove);
            assertTrue(waterMonster.getCollision() instanceof SimpleCollision);
            waterMonster.update();
        }
        for(int i = 0;i < 10;i++){
            assertTrue(waterMonster.getMove() instanceof FastFollowMove);
            assertTrue(waterMonster.getCollision() instanceof SimpleCollision);
            waterMonster.update();
        }
        assertTrue(waterMonster.getMove() instanceof RandomMove);
        assertTrue(waterMonster.getCollision() instanceof SimpleCollision);
    }

    @Test
    void metalMonsterTest(){
        Warrior.getInstance().setPosition(new Position(10,10));
        MetalMonster metalMonster = new MetalMonster(5,5);
        assertTrue(metalMonster.getMove() instanceof FastRandomMove);
        assertTrue(metalMonster.getCollision() instanceof SimpleCollision);

        //NOT near
        metalMonster.update();
        assertTrue(metalMonster.getMove() instanceof FastRandomMove);
        assertTrue(metalMonster.getCollision() instanceof SimpleCollision);

        //near
        Warrior.getInstance().setPosition(new Position(8,8));
        metalMonster.update();
        assertTrue(metalMonster.getMove() instanceof FollowMove);
        assertTrue(metalMonster.getCollision() instanceof SimpleCollision);
    }

    @Test
    void eggMonsterTest(){
        EggMonster eggMonster = new EggMonster(5,5);
        assertTrue(eggMonster.getMove() instanceof HatchingMove);
        assertTrue(eggMonster.getCollision() instanceof SmashCollision);

        eggMonster.update();

        assertTrue(eggMonster.getMove() instanceof FollowMove);
        assertTrue(eggMonster.getCollision() instanceof SimpleCollision);
    }

}
