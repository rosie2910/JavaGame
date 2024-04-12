package game;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.Walker;
import city.cs.engine.WorldView;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyMover implements KeyListener {

    private Player player;
    private WorldView view;
    int x = 0;
    int y = 0;
    int charX;
    int charY;
    Enemy enemy;
    GameLevel world;
    private String key;
    BodyImage catWalkR;
    BodyImage catWalkL;

    Enemy enemy2;

    BodyImage idleState = new BodyImage("data/StandingCat-1.png.png", 3);


    // KEYMOVER CONSTRUCTOR -- SETS KEYLISTENER TO VIEW //
    public KeyMover(WorldView view, Player player, Enemy enemy, GameLevel world, Enemy enemy2) {
        this.player = player;
        this.view = view;
        this.enemy = enemy;
        this.world = world;
        this.enemy2 = enemy2;
        //view.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    // ALLOWS PLAYER MOVEMENT //
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            //System.out.println("button pressed");
            case KeyEvent.VK_W:
                key = "UP";
                player.setPosition(new Vec2(x, y + 0.5f));
                y++;
                player.setCharY(this);
                break;
            case KeyEvent.VK_S:
                key = "DOWN";
                player.setPosition(new Vec2(x, y - 0.5f));
                y--;
                player.setCharY(this);
                break;
            case KeyEvent.VK_D:
                key = "RIGHT";
                player.removeAllImages();
                catWalkR = new BodyImage("data/NewStandingCat.gif",3);
                player.addImage(catWalkR);
                player.setPosition(new Vec2(x + 0.5f, y));
                x++;
                player.setCharX(this);
                break;
            case KeyEvent.VK_A:
                key = "LEFT";
                player.removeAllImages();
                catWalkL = new BodyImage("data/New Piskel.gif",3);
                player.addImage(catWalkL);
                player.setPosition(new Vec2(x - 0.5f, y));
                x--;
                player.setCharX(this);
                break;
            case KeyEvent.VK_ENTER:
                PlayerProjectile playerProjectile = new PlayerProjectile(world, player, enemy, enemy2);
                playerProjectile.shoot(this);
                break;



        }



    }

    @Override
    public void keyReleased (KeyEvent e){

        player.removeAllImages();
        player.addImage(idleState);


    }

    public void setKey(String key){
        this.key = key;
    }

    public String getKey(){
        return key;
    }







}