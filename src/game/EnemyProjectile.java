package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class EnemyProjectile extends DynamicBody {

    private static final BodyImage waterProjectile = new BodyImage("data/projectile1.png", 1);
    private static final BodyImage magicProjectile = new BodyImage("data/MagicProj.png", 1);
    private static final Shape projShape = new CircleShape(0.1f);
    String projType;

    public EnemyProjectile(GameLevel world, Player player, Enemy enemy) {
        super(world);
        GhostlyFixture gf = new GhostlyFixture(this, projShape);
        ShootSensor shootSensor = new ShootSensor(player, this);
        Sensor sensor = new Sensor(this, projShape);
        sensor.addSensorListener(shootSensor);

        this.setGravityScale(0);
        if(enemy.enemyNum == 1){
            projType = "Water";
            this.addImage(waterProjectile);
        }
        else{
            projType = "Magic";
            this.addImage(magicProjectile);
        }

        this.setPosition(new Vec2(enemy.getPosition().x, enemy.getPosition().y));


    }


    public void attack(Player player, Enemy enemy) {
        this.setLinearVelocity(new Vec2(player.getCharX() - enemy.getPosition().x, player.getCharY() - enemy.getPosition().y));
        this.applyForce(new Vec2(5, 5), new Vec2(player.getCharX() - enemy.getPosition().x, player.getCharY() - enemy.getPosition().y));

    }
}

