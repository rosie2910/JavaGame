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
    BodyImage catWalkR;

    BodyImage idleState = new BodyImage("data/StandingCat-1.png.png", 3);


    // KEYMOVER CONSTRUCTOR -- SETS KEYLISTENER TO VIEW //
    public KeyMover(WorldView view, Player player) {
        this.player = player;
        this.view = view;
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
            case KeyEvent.VK_UP:
                player.setPosition(new Vec2(x, y + 1));
                y++;
                player.setCharY(this);
                System.out.println(player.getCharY());
                System.out.println("(" + x + ", " + y + ")");
                //System.out.println("up");
                break;
            case KeyEvent.VK_DOWN:
                player.setPosition(new Vec2(x, y - 1));
                y--;
                System.out.println("(" + x + ", " + y + ")");
                player.setCharY(this);
                System.out.println(player.getCharX());
                //System.out.println("down");
                break;
            case KeyEvent.VK_RIGHT:
                player.removeAllImages();
                catWalkR = new BodyImage("data/StandingCat.gif",3);
                player.addImage(catWalkR);
                player.setPosition(new Vec2(x + 1, y));
                x++;
                player.setCharX(this);
                System.out.println(player.getCharX());
                System.out.println("(" + x + ", " + y + ")");
                //System.out.println("right");
                break;
            case KeyEvent.VK_LEFT:
                player.setPosition(new Vec2(x - 1, y));
                x--;
                player.setCharX(this);
                System.out.println(player.getCharX());
                System.out.println("(" + x + ", " + y + ")");
                //System.out.println("left");
                break;



        }



    }

    @Override
    public void keyReleased (KeyEvent e){

        player.removeAllImages();
        player.addImage(idleState);


    }





}
