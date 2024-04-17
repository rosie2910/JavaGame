package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import com.sun.tools.javac.Main;
import org.jbox2d.common.Vec2;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Game {
    JFrame frame;
    GameLevel world;
    //WorldView view;
    BackgroundImage view;

    KeyMover playerMover;

    private SoundClip gameMusic;
    private SoundClip merchantMusic;


    public Game(){



        world = new Level1(this);
        view = new BackgroundImage(world, 800, 600, world.getPlayer());
        // JFrame debugViewer = new DebugViewer(world, 800,600);
        frame = new JFrame("Cat Quest");
        //JFrame menuFrame = new JFrame("Cat Quest");
        //menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension size = new Dimension(800, 600);
        //menuFrame.setPreferredSize(size);

        MainMenu mainMenu = new MainMenu(frame, view, this, world);
        //menuFrame.add(mainMenu);
        frame.add(mainMenu);

        //menuFrame.setVisible(true);
        frame.setResizable(false);
        //menuFrame.pack();

        // world = new GameWorld(frame, view);




        //view = new UserView(world, 800,600);

        //HealthBar healthBar = new HealthBar(world.getPlayer(), world);
        //healthBar.setSize(100,50);
        //frame.add(view);
        //frame.add(healthBar);


        //frame.add(backgroundImage);





      /*
      if(world.getPlayer().dead == true){
          world.stop();
      }
      */




        playerMover = new KeyMover(view, world.getPlayer(), world.getEnemy(), world, world.getEnemy2());
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
        //Dimension size = new Dimension(800,600);
        frame.setPreferredSize(size);
        frame.pack();
        frame.setVisible(true);

        try{
            gameMusic = new SoundClip("data/alexander-nakarada-metal-interlude.wav");
            gameMusic.loop();
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JFrame debug = new DebugViewer(world, 500, 500);
        world.start();
        //world.play();



    }

    public SoundClip getGameMusic(){
        return gameMusic;
    }



    public void goToNextLevel(){
        if(world instanceof Level1){
            Player player = world.getPlayer();
            System.out.println(player.getHp());
            world.stop();
            world = new Level2(this);

            world.getPlayer().setHp(player.getHp());
            System.out.println(world.getPlayer().getHp());

            view.setWorld(world);

            playerMover.setPlayer(world.getPlayer());
            playerMover.setLevel(world);
            world.start();
            //world.play();
        }
        else if(world instanceof Level2){
            world.stop();
            gameMusic.stop();

            try{
                merchantMusic = new SoundClip("data/arthur-vyncke-uncertainty.wav");
                merchantMusic.loop();
            } catch (UnsupportedAudioFileException e) {
                throw new RuntimeException(e);
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            world = new Level3(this);

            view.setWorld(world);

            playerMover.setPlayer(world.getPlayer());
            playerMover.setLevel(world);
            world.start();
            //world.play();
        }
    }


    public static void main(String[] args){
        new Game();
    }

}




