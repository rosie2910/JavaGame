package game;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.Walker;
import org.jbox2d.common.Vec2;


public class Player extends DynamicBody {

    int charX = 0;
    int charY = 0;
    public BodyImage idle = new BodyImage("data/StandingCat-1.png.png", 3);
    public Player(GameWorld world){
        super(world);
        this.addImage(idle);
        this.setGravityScale(0);
        this.setPosition(new Vec2(0,0));
    }

    public int getCharX(){
        //this.charX = playerMover.x;
        return charX;
    }

    public void setCharX(KeyMover playerMover){
        this.charX = playerMover.x;
    }

    public int getCharY(){
        //this.charY = playerMover.y;
        return charY;
    }

    public void setCharY(KeyMover playerMover){
        this.charY = playerMover.y;
    }

    public BodyImage getIdle(){
        return idle;
    }










}
