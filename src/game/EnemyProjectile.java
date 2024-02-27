package game;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import org.jbox2d.common.Vec2;

public class EnemyProjectile extends DynamicBody {

    private static final BodyImage projectile = new BodyImage("data/projectile1.png", 1);

    public EnemyProjectile(GameWorld world, Player player, Enemy enemy){
        super(world);
        this.setGravityScale(0);
        this.addImage(projectile);
        this.setPosition(new Vec2(enemy.getPosition().x, enemy.getPosition().y));

    }


    public void attack(Player player, Enemy enemy){
        this.setLinearVelocity(new Vec2(player.getCharX() - enemy.getPosition().x, player.getCharY() - enemy.getPosition().y));
        this.applyForce(new Vec2(5,5), new Vec2(player.getCharX() - enemy.getPosition().x, player.getCharY() - enemy.getPosition().y));
        //this.isBullet();
        //this.setBullet(true);


    }


}


