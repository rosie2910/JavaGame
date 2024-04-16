package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class Player extends DynamicBody {

    int charX = 0;
    int charY = 0;
    int hp = 100;
    static int gemCount = 2;
    boolean dead = false;
    private static final Shape playerShape = new PolygonShape(-0.494f,0.492f, 0.492f,0.496f, 0.474f,-0.468f, -0.482f,-0.466f);
    // private static final Shape playerShape = new BoxShape(1,1);
    public BodyImage idle = new BodyImage("data/StandingCat-1.png.png", 3);
    public Player(GameLevel world){
        super(world, playerShape);
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

    public void setHp(int hp){
        this.hp = hp;
    }

    public int getHp(){
        return hp;
    }

    public int getGemCount(){
        return gemCount;
    }

    public void setGemCount(int gemCount){
        this.gemCount = gemCount;
    }











}
