package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel{
    BackgroundImage view;
    JFrame frame;
    JButton start;
    JButton htp;
    GameLevel world;

    Image mm;
    static boolean startGame;

    public MainMenu(JFrame frame, BackgroundImage view, Game game, GameLevel world){
        mm = new ImageIcon("data/MainMenu.png").getImage();
        startGame = false;
        this.frame = frame;
        this.view = view;
        start = new JButton("Start Game");

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(view);
                frame.revalidate();
                frame.repaint();
                startGame = true;
                if(startGame == true){
                    System.out.println("start game");
                    //world.play(game);

                }



            }
        });

        add(start);

    }

    @Override
    protected void paintComponent(Graphics g){
        g.drawImage(mm, 0, 0, this);
    }
}