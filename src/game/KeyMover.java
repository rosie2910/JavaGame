package game;

import city.cs.engine.DynamicBody;
import city.cs.engine.WorldView;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyMover implements KeyListener {

    private DynamicBody player;
    private WorldView view;
    int x = 0;
    int y = 0;


    public KeyMover(WorldView view, DynamicBody player) {
        this.player = player;
        this.view = view;
        view.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            //System.out.println("button pressed");
            case KeyEvent.VK_UP:
                player.setPosition(new Vec2(x, y + 1));
                y++;
                System.out.println("(" + x + ", " + y + ")");
                //System.out.println("up");
                break;
            case KeyEvent.VK_DOWN:
                player.setPosition(new Vec2(x, y - 1));
                y--;
                System.out.println("(" + x + ", " + y + ")");
                //System.out.println("down");
                break;
            case KeyEvent.VK_RIGHT:
                player.setPosition(new Vec2(x + 1, y));
                x++;
                System.out.println("(" + x + ", " + y + ")");
                //System.out.println("right");
                break;
            case KeyEvent.VK_LEFT:
                player.setPosition(new Vec2(x - 1, y));
                x--;
                System.out.println("(" + x + ", " + y + ")");
                //System.out.println("left");
                break;



        }



    }

    @Override
    public void keyReleased (KeyEvent e){


    }

}
