
package game;

import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;

public class PlayerShootSensor implements SensorListener {

    Enemy enemy;
    PlayerProjectile projectile;
    public PlayerShootSensor(Enemy enemy, PlayerProjectile projectile){
        this.enemy = enemy;
        this.projectile = projectile;


    }

    @Override
    public void beginContact(SensorEvent sensorEvent) {
        if(sensorEvent.getContactBody() instanceof Enemy) {
            enemy.setHp(enemy.getHp() - 10);
            System.out.println("Enemy: " + enemy.getHp());
            projectile.destroy();
        }

    }

    @Override
    public void endContact(SensorEvent sensorEvent) {


    }
}