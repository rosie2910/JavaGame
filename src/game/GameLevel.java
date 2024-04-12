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

    public GameLevel(Game game){

        player = new Player(this);
        enemy = new Enemy(this);
        enemy2 = new Enemy(this);
        Collectible heart = new Collectible(this, enemy, player);
        CollectibleCollisionListener ccl = new CollectibleCollisionListener(player, heart);
        player.addCollisionListener(ccl);

        Color clear = new Color(0,0,0,0);
        StaticBody wall = new StaticBody(this, new BoxShape(400,10));
        wall.setPosition(new Vec2(17,18));
        wall.setFillColor(clear);
        wall.setLineColor(clear);


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

    public void play(Game game){
        while (enemy.dead == false) {
            //for (int i = 0; i < 7; i++) {
            projectile = new EnemyProjectile(this, player, enemy);
            projectile.attack(player, enemy);

            //gcl = new GenericCollisionListener(player, projectile);
            //player.addCollisionListener(gcl);
            //projectile.addCollisionListener(gcl);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            projectile.destroy();

        }

        while(enemy2.dead == false){
            EnemyProjectile projectile2 = new EnemyProjectile(this, player, enemy2);
            projectile2.attack(player, enemy2);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            projectile2.destroy();
        }
    }




    public abstract boolean isComplete();

}