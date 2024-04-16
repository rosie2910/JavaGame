
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class PlayerProjectile extends DynamicBody {
    private static final BodyImage waterProjectile = new BodyImage("data/projectile1.png", 1);
    private static final BodyImage magicProjectile = new BodyImage("data/MagicProj.png", 1);
    private static final Shape playerProjShape = new CircleShape(0.1f);
    Player player;
    Enemy enemy;
    public PlayerProjectile(GameLevel world, Player player, Enemy enemy, Enemy enemy2, KeyMover playerMover){
        super(world);
        Sensor gf = new Sensor(this, playerProjShape);
        PlayerShootSensor playerShootSensor = new PlayerShootSensor(this, player);
        //Sensor sensor = new Sensor(this, playerProjShape);
        gf.addSensorListener(playerShootSensor);

        this.setGravityScale(0);
        if(playerMover.projType.equals("Water")) {
            this.addImage(waterProjectile);
        }
        if(playerMover.projType.equals("Magic")){
            this.addImage(magicProjectile);
        }
        this.setPosition(new Vec2(player.getPosition().x, player.getPosition().y));
    }

    public void shoot(KeyMover playerMover){
        switch(playerMover.getKey()){
            case "UP":
                this.setLinearVelocity(new Vec2(0,1));
                this.applyForce(new Vec2(0,3));
                break;
            case "DOWN":
                this.setLinearVelocity(new Vec2(0,-1));
                this.applyForce(new Vec2(0,-3));
                break;
            case "RIGHT":
                this.setLinearVelocity(new Vec2(1,0));
                this.applyForce(new Vec2(3,0));
                break;
            case "LEFT":
                this.setLinearVelocity(new Vec2(-1,0));
                this.applyForce(new Vec2(-3,0));
                break;

        }

    }
}
