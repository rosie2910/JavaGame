
package game;

import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;

public class PlayerShootSensor implements SensorListener {


    Player player;

    PlayerProjectile projectile;
    public PlayerShootSensor(PlayerProjectile projectile, Player player){

        this.projectile = projectile;
        this.player = player;



    }

    @Override
    public void beginContact(SensorEvent sensorEvent) {
        if(sensorEvent.getContactBody() instanceof Enemy) {
            Enemy e = (Enemy)sensorEvent.getContactBody();
            e.setHp(e.getHp() - 10);
            //System.out.println("Enemy: " + e.getHp());
            projectile.destroy();
            if(e.getHp() <= 0){
                e.die(player);
            }



        }

    }

    @Override
    public void endContact(SensorEvent sensorEvent) {


    }
}