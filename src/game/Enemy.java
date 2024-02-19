package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import java.util.concurrent.TimeUnit;


public class Enemy extends DynamicBody {
    int hp = 25;
    int damage = 5;
    boolean dead = false;
    private int enX = -5;
    private int enY = 3;
    int ballCount = 0;
    int speed = 2;

    // private static final Shape enemyShape = new BoxShape(1,1, new Vec2(-10,0));


    private static final BodyImage image = new BodyImage("data/EyeEnemy.png", 3);

    public Enemy(World room) {
        super(room);
        //DynamicBody Enemy = new DynamicBody(room, new CircleShape(0.2F));
        this.setGravityScale(0);
        this.addImage(image);
        this.setPosition(new Vec2(this.getEnX(), this.getEnY()));
        //this.startWalking(2);
    }

    public void walk(int enX, int enY, Player player){
        this.setPosition(new Vec2(enX, enY));
        enX++;
        setEnX(enX);
    }

    public int getEnY() {
        return enY;
    }

    public void setEnY(int enY) {
        this.enY = enY;
    }

    public int getEnX() {
        return enX;
    }

    public void setEnX(int enX) {
        this.enX = enX;
    }
}
