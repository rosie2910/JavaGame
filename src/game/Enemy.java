package game;

import city.cs.engine.BodyImage;
import city.cs.engine.Walker;
import city.cs.engine.WorldView;
import org.jbox2d.common.Vec2;



public class Enemy extends Walker {

    int enX = 2;
    int enY = 3;

    int speed = 1;
    boolean dead = false;

    private static final BodyImage eye = new BodyImage("data/EyeEnemy.png", 3);

    public Enemy(GameWorld world, WorldView view) {
        super(world);
        this.setGravityScale(0);
        this.addImage(eye);
        this.setPosition(new Vec2(enX, enY));
        this.startWalking(speed);
        System.out.println(this.getPosition().x);

    }

    public void attack(Player player,KeyMover playerMover, EnemyProjectile projectile){
        projectile.setLinearVelocity(new Vec2(player.getCharX(), player.getCharY()));
        projectile.applyForce(new Vec2(player.getCharX(), player.getCharY()));

    }

}
