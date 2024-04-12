package game;

import java.util.logging.Level;
import city.cs.engine.BoxShape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import city.cs.engine.WorldView;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;


public class Level1 extends GameLevel{

    static Player player;
    JFrame frame;
    BackgroundImage view;
    Enemy enemy;
    Enemy enemy2;
    EnemyProjectile projectile;
    GenericCollisionListener gcl;

    public Level1(Game game){
        super(game);
        this.player = getPlayer();
        this.frame = frame;
        this.enemy = getEnemy();
        this.enemy2 = getEnemy2();
        //player = new Player(this);
        //enemy = new Enemy(this);
        enemy.setPosition(new Vec2(3,4));
        //enemy2 = new Enemy(this);
        enemy2.setPosition(new Vec2(-3,-4));

    }

    @Override
    public boolean isComplete() {
        if(enemy.getEnemyCount() == 0){
            return true;
        }

        return false;
    }







}