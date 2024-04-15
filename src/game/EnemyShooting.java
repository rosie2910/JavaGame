package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;

public class EnemyShooting implements StepListener {
    GameLevel world;
    Player player;
    Enemy enemy;

    int shootCounter;
    int shootFreq;
    public EnemyShooting(Enemy enemy, Player player, GameLevel world){
        this.world = world;
        this.player = player;
        this.enemy = enemy;
        this.shootFreq = 0;
        this.shootCounter = 0;
        world.addStepListener(this);

    }

    @Override
    public void preStep(StepEvent stepEvent) {
        shootCounter++;
    }

    @Override
    public void postStep(StepEvent stepEvent) {
        if((shootCounter % 120) == 0 && enemy.dead == false){
            EnemyProjectile projectile = new EnemyProjectile(world, player, enemy);
            projectile.attack(player, enemy);
        }


    }
}
