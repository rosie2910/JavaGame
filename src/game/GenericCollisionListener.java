package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class GenericCollisionListener implements CollisionListener {
    Player player;
    EnemyProjectile projectile;

    public GenericCollisionListener(Player player, EnemyProjectile projectile){
        this.player = player;
        this.projectile = projectile;

    }

    @Override
    public void collide(CollisionEvent collisionEvent){
        if(collisionEvent.getOtherBody() instanceof EnemyProjectile){
            player.setHp(player.getHp()-5);
            System.out.println(player.getHp());
        }


    }
}