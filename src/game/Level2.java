package game;


import city.cs.engine.DebugViewer;
import org.jbox2d.common.Vec2;

import javax.swing.*;

public class Level2 extends GameLevel{


    Player player;

    public Level2(Game game){
        super(game);
        this.player = getPlayer();
        System.out.println(player.getHp());
        player.setPosition(new Vec2(-9, 10));

        getEnemy().setPosition(new Vec2(4,0));
        getEnemy2().setPosition(new Vec2(5, 5));
        getDoor().setPosition(new Vec2(0,10));
        JFrame debug = new DebugViewer(this, 500, 500);

        EnemyShooting shoot = new EnemyShooting(getEnemy(), player, this);
        EnemyShooting shoot2 = new EnemyShooting(getEnemy2(), player, this);

    }




    @Override
    public boolean isComplete() {
        if(getEnemy().getEnemyCount() == 0){
            return true;
        }

        return false;
    }



}