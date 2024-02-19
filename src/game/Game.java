package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

// Makes a new game
public class Game{



    //Initialises a new game
    public Game() {


        World room = new World();



        //make a window
        UserView view = new UserView(room, 800, 600);

/*
        // makes the background image
        ImageIcon image = new ImageIcon("data/Level1BG.jpeg");
        JPanel panel = new JPanel(new BorderLayout());
        JLabel table = new JLabel(image, JLabel.CENTER);
        panel.add(table);
        view.add(panel);
        view.setVisible(true);

 */





        /*
        Walker enemy = new Walker(room, new CircleShape(1));
        enemy.setGravityScale(0);
        enemy.addImage(new BodyImage("data/EyeEnemy.png", 2));
        enemy.startWalking(2);

         */


        view.setGridResolution(1);

        view.addMouseListener(new GiveFocus(view));




        Thread gameThread = new Thread();
        gameThread.start();



        //eyeball.setGravityScale(0);
        //eyeball.attack(false, room, player);
        //eyeball.enemyWalk(player, room, playerMover);



        // makes a title for the window
        final JFrame frame = new JFrame("Cat Quest");
        frame.add(view);

        JFrame debugView = new DebugViewer(room, 800, 600);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible

        frame.setVisible(true);


        //optional: uncomment this to make a debugging view
        //  JFrame debugView = new DebugViewer(world, 500, 500);

        // start our game world simulation!
        room.start();
        GameWorld world = new GameWorld();
        world.play(room, view);

        //GameView background = new GameView(room, this, 800, 600);

/*
        for(int i = 0; i < 6; i++) {
            EnemyProjectile projectile = new EnemyProjectile(room, player, eyeball);
            projectile.attack(player, playerMover);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            projectile.destroy();
        }
/*
        GameView background = new GameView(room, this, 800, 600);
        background.paintBackground();

 */

/*
        Shape backgroundShape = new BoxShape(0,0);
        StaticBody background = new StaticBody(room, backgroundShape);
        background.setPosition(new Vec2(0,0));
        background.addImage(new BodyImage("data/Level1BG.jpeg", 30));
        background.removeAllCollisionListeners();

 */




        //background.setAlwaysOutline(true);










    }

    /** Run the game. */
    public static void main(String[] args) {



        new Game();
    }
}

