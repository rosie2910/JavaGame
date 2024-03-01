package game;

import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;

public class ShootSensor implements SensorListener {
    Player player;
    EnemyProjectile projectile;

    public ShootSensor(Player player, EnemyProjectile projectile){
        this.player = player;
        this.projectile = projectile;
    }

    @Override
    public void beginContact(SensorEvent sensorEvent) {
        player.setHp(player.getHp() - 15);
        System.out.println(player.getHp());

    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

        projectile.destroy();
    }


}