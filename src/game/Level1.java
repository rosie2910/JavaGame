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

    EnemyProjectile projectile;
    GenericCollisionListener gcl;
    //Door door;

    public Level1(Game game){
        super(game);
        this.player = getPlayer();
        this.frame = frame;

        //player = new Player(this);
        //enemy = new Enemy(this);
        getEnemy().setPosition(new Vec2(3,4));
        //enemy2 = new Enemy(this);
        getEnemy2().setPosition(new Vec2(-3,-4));

        getDoor().setPosition(new Vec2(-9, 10));

        EnemyShooting shoot = new EnemyShooting(getEnemy(), player, this);
        EnemyShooting shoot2 = new EnemyShooting(getEnemy2(), player, this);

        //getEnemy().die(player);
        //getEnemy2().die(player);

    }



    public Door getDoor(){
        return door;
    }









    @Override
    public boolean isComplete() {
        if(getEnemy().getEnemyCount() == 0){
            return true;
        }

        return false;
    }







}




