
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class PlayerProjectile extends DynamicBody {
    private static final BodyImage projectile = new BodyImage("data/projectile1.png", 1);
    private static final Shape playerProjShape = new CircleShape(0.1f);
    Player player;
    Enemy enemy;
    public PlayerProjectile(GameWorld world, Player player, Enemy enemy){
        super(world);
        Sensor gf = new Sensor(this, playerProjShape);
        PlayerShootSensor playerShootSensor = new PlayerShootSensor(enemy, this);
        //Sensor sensor = new Sensor(this, playerProjShape);
        gf.addSensorListener(playerShootSensor);

        this.setGravityScale(0);
        this.addImage(projectile);
        this.setPosition(new Vec2(player.getPosition().x, player.getPosition().y));
    }

    public void shoot(KeyMover playerMover){
        System.out.println("hello");
        switch(playerMover.getKey()){
            case "UP":
                System.out.println(playerMover.getKey());
                this.setLinearVelocity(new Vec2(0,1));
                this.applyForce(new Vec2(0,3));
                break;
            case "DOWN":
                System.out.println(playerMover.getKey());
                this.setLinearVelocity(new Vec2(0,-1));
                this.applyForce(new Vec2(0,-3));
                break;
            case "RIGHT":
                System.out.println(playerMover.getKey());
                this.setLinearVelocity(new Vec2(1,0));
                this.applyForce(new Vec2(3,0));
                break;
            case "LEFT":
                System.out.println(playerMover.getKey());
                this.setLinearVelocity(new Vec2(-1,0));
                this.applyForce(new Vec2(-3,0));
                break;

        }

    }
}