package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class Player extends DynamicBody {
    private int charX = 0;
    private int charY = 0;
    private int hp = 100;
    private int speed = 1;
    private int damage = 5;

    public boolean charDead = false;

    private static final BodyImage playerImage = new BodyImage("data/CatStand.png", 2);

    public Player(World room, int hp, int speed, int damage){
        super(room);
        this.hp = hp;
        this.speed = speed;
        this.damage = damage;
        //DynamicBody player = new DynamicBody(room, new BoxShape(1,1));
        this.setGravityScale(0);
        this.addImage(playerImage);
        this.setPosition(new Vec2(0,0));

    }


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getCharX(KeyMover playerMover) {
        this.charX = playerMover.x;
        return charX;
    }

    public void setCharX(KeyMover playerMover) {
        this.charX = playerMover.x;
    }

    public int getCharY(KeyMover playerMover) {
        this.charY = playerMover.y;
        return charY;
    }

    public void setCharY(KeyMover playerMover) {
        this.charY = playerMover.y;
    }
}
