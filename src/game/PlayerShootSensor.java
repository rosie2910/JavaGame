
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
            if(e.enemyNum == 1 && projectile.projectileType.equals("Water")){
                projectile.destroy();
                System.out.println("Not effective");
            }
            else if(e.enemyNum == 1 && projectile.projectileType.equals("Magic")){
                e.setHp(e.getHp() - 10);
                System.out.println("effective");
                projectile.destroy();

            }
            else if(e.enemyNum == 2 && projectile.projectileType.equals("Water")){
                e.setHp(e.getHp() - 10);
                System.out.println("effective");
                projectile.destroy();
            }
            else if(e.enemyNum == 2 && projectile.projectileType.equals("Magic")){
                projectile.destroy();
                System.out.println("Not effective");
            }
            //System.out.println("Enemy: " + e.getHp());

            if(e.getHp() <= 0){
                e.die(player);
            }



        }

    }

    @Override
    public void endContact(SensorEvent sensorEvent) {


    }
}