package game;

import city.cs.engine.World;
import city.cs.engine.WorldView;

import javax.swing.*;

public class GameWorld extends World {
    JFrame frame;
    WorldView view;
    Player player;
    Enemy enemy;
    EnemyProjectile projectile;
    GenericCollisionListener gcl;

    public GameWorld(JFrame frame, WorldView view){
        this.frame = frame;

        player = new Player(this);
        enemy = new Enemy(this, view);


    }

    public void play(Game game){
        for(int i = 0; i < 7; i++){
            projectile = new EnemyProjectile(this, player, enemy);
            projectile.attack(player, enemy);
            gcl = new GenericCollisionListener(player, projectile);
            player.addCollisionListener(gcl);
            //projectile.addCollisionListener(gcl);
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            projectile.destroy();
        }

    }

    public void setPlayer(){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

    public void setEnemy(){
        this.enemy = enemy;
    }

    public Enemy getEnemy(){
        return enemy;
    }


}