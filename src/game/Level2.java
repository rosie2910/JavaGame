package game;


import city.cs.engine.DebugViewer;
import org.jbox2d.common.Vec2;

import javax.swing.*;

public class Level2 extends GameLevel{

    Enemy enemy;

    Enemy enemy2;

    public Level2(Game game) {
        super(game);
        this.enemy = getEnemy();
        this.enemy2 = getEnemy2();
        enemy.setPosition(new Vec2(4, 0));
        enemy2.setPosition(new Vec2(5, 5));
        getDoor().setPosition(new Vec2(0, 10));
        JFrame debug = new DebugViewer(this, 500, 500);

    }


    @Override
    public boolean isComplete() {
        if(enemy.getEnemyCount() == 0){
            return true;
        }

        return false;
    }
    }