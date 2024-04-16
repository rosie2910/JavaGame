package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {
    BackgroundImage view;
    JFrame frame;
    JButton start;
    JButton htp;
    GameLevel world;
    boolean pressedHTP;

    Image mm;
    Image howToPlay;
    JButton volUp;
    JButton volDown;
    JButton mute;
    double volume = 0.5;
    static boolean startGame;

    public MainMenu(JFrame frame, BackgroundImage view, Game game, GameLevel world) {
        mm = new ImageIcon("data/MainMenu.png").getImage();
        //howToPlay = new ImageIcon("data/HTP.png").getImage();
        startGame = false;
        pressedHTP = false;
        this.frame = frame;
        this.view = view;
        start = new JButton("Start Game");
        htp = new JButton("How to Play");
        volUp = new JButton("Volume Up");
        volDown = new JButton("Volume Down");
        mute = new JButton("Mute");

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(view);
                frame.revalidate();
                frame.repaint();
                startGame = true;
                if (startGame == true) {
                    System.out.println("start game");
                    //world.play(game);

                }

            }
        });

        volDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(volume >= 0.2) {
                    volume = volume - 0.2;
                    game.getGameMusic().setVolume(volume);
                }
            }
        });
        volUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(volume <= 0.8) {
                    volume = volume + 0.2;
                    game.getGameMusic().setVolume(volume);
                }
            }
        });
        mute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volume = (volume - volume) + 0.001;
                game.getGameMusic().setVolume(volume);
            }
        });

        htp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                howToPlay = new ImageIcon("data/HTP.png").getImage();
                pressedHTP = true;
            }
        });
        this.setLayout(null);
        start.setBounds(350, 300, 100, 25);
        htp.setBounds(350, 400, 100, 25);
        volDown.setBounds(200, 500, 100, 25);
        mute.setBounds(350, 500, 100, 25 );
        volUp.setBounds(500, 500, 100, 25);
        add(start);
        add(htp);
        add(volDown);
        add(volUp);
        add(mute);

    }

    @Override
    protected void paintComponent(Graphics g) {
        if (pressedHTP == true){
            g.drawImage(howToPlay, 0, 0, this);
            System.out.println("pressed");

        }
        else{
            g.drawImage(mm, 0, 0, this);
            System.out.println("not pressed");
        }


    }
}