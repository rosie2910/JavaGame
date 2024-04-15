
package game;

import city.cs.engine.BoxShape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import java.awt.*;

public abstract class GameLevel extends World {
    private Player player;
    private final Enemy enemy;

    private final Enemy enemy2;
    EnemyProjectile projectile;
    Door door;

    public GameLevel(Game game){

        player = new Player(this);
        enemy = new Enemy(this);
        enemy2 = new Enemy(this);
        Collectible heart = new Collectible(this, enemy, player);
        CollectibleCollisionListener ccl = new CollectibleCollisionListener(player, heart);
        player.addCollisionListener(ccl);
        door = new Door(this);
        GenericCollisionListener gcl = new GenericCollisionListener(player, door, this, game);
        player.addCollisionListener(gcl);


        /*
        StaticBody wall = new StaticBody(this, new BoxShape(400,10));
        wall.setPosition(new Vec2(17,18));
        wall.setFillColor(clear);
        wall.setLineColor(clear);

         */


        projectile = new EnemyProjectile(this, player, enemy);
    }


    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy(){
        return enemy;
    }

    public Enemy getEnemy2(){
        return enemy2;
    }

    public Door getDoor(){
        return door;
    }


//public abstract void play();












    public abstract boolean isComplete();

}
