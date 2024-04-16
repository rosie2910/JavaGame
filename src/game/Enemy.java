package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;





public class Enemy extends Walker implements StepListener {

    private static final Shape enemyShape = new CircleShape(1);

    int enX = 2;
    int enY = 3;

    int speed = 1;
    private int hp = 50;
    boolean dead = false;
    private float left, right;
    private final int range = 13;
    GameLevel world; // private this

    private static int enemyCount = 0;


    private static final BodyImage eye = new BodyImage("data/EyeEnemy.png", 3);

    public Enemy(GameLevel world) {
        super(world, enemyShape);
        this.setGravityScale(0);
        this.addImage(eye);
        world.addStepListener(this);
        //this.setPosition(new Vec2(enX, enY));
        this.startWalking(speed);
        System.out.println(this.getPosition().x);
        this.world = world;
        enemyCount++;


    }

    public void attack(Player player,KeyMover playerMover, EnemyProjectile projectile){
        projectile.setLinearVelocity(new Vec2(player.getCharX(), player.getCharY()));
        projectile.applyForce(new Vec2(player.getCharX(), player.getCharY()));


    }

    public void die(Player player){
        this.destroy();
        this.dead = true;
        Collectible collectible = new Collectible(world, this, player);
        CollectibleCollisionListener ccl = new CollectibleCollisionListener(player, collectible);
        player.addCollisionListener(ccl);
        enemyCount--;
        System.out.println("Enemy Count: " + enemyCount);
        //generateRandom();
        //this.setHp(50);

    }



    @Override
    public void setPosition(Vec2 position){
        super.setPosition(position);
        left = position.x - range;
        right = position.x + range;
    }

    public void setHp(int hp){

        this.hp = hp;
    }

    public int getHp(){

        return this.hp;
    }

    public int getEnemyCount(){
        return enemyCount;
    }


    @Override
    public void preStep(StepEvent stepEvent) {
        if(getPosition().x > right){
            startWalking(-speed);
        }
        if(getPosition().x < left){
            startWalking(speed);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
