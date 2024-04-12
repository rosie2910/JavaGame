package game;

import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;

public class ShootSensor implements SensorListener {
    Player player;
    EnemyProjectile projectile;
    BackgroundImage view;

    public ShootSensor(Player player, EnemyProjectile projectile){
        this.player = player;
        this.projectile = projectile;
        this.view = view;
    }

    @Override
    public void beginContact(SensorEvent sensorEvent) {
        if(sensorEvent.getContactBody() instanceof  Player) {
            player.setHp(player.getHp() - 15);
            System.out.println("Player HP: " + player.getHp());
            if(player.getHp() <= 0){
                System.out.println("Game Over");
                player.dead = true;
            }
            projectile.destroy();
        }

    }

    @Override
    public void endContact(SensorEvent sensorEvent) {


    }


}