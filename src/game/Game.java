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

public class Game {
    JFrame frame;
    GameLevel world;
    WorldView view;


    public Game(){




        // JFrame debugViewer = new DebugViewer(world, 800,600);
        frame = new JFrame("Cat Quest");


        // world = new GameWorld(frame, view);
        world = new Level1(this);



        //view = new UserView(world, 800,600);

        BackgroundImage view = new BackgroundImage(world, 800, 600, world.getPlayer());
        //HealthBar healthBar = new HealthBar(world.getPlayer(), world);
        //healthBar.setSize(100,50);
        frame.add(view);
        //frame.add(healthBar);


        //frame.add(backgroundImage);

        KeyMover playerMover = new KeyMover(view, world.getPlayer(), world.getEnemy(), world, world.getEnemy2());
        //view.requestFocus();
        view.addKeyListener(playerMover);

        view.addMouseListener(new GiveFocus(view));

        //KeyMover playerMovement = new KeyMover(view, world.getPlayer());
        //view.addKeyListener(playerMovement);

        view.setGridResolution(1);
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        Dimension size = new Dimension(800,600);
        frame.setPreferredSize(size);
        frame.pack();
        frame.setVisible(true);

        JFrame debug = new DebugViewer(world, 500, 500);
        world.start();
        world.play(this);

      /*
      if(world.getPlayer().dead == true){
          world.stop();
      }

       */







    }


    public static void main(String[] args){
        new Game();
    }

}
