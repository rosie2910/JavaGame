package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {
    private ImageIcon background;
    private JFrame backgroundFrame;


    private JLabel backgroundLabel;
    private ImageIcon mainMenu;
    private JLabel menuLabel;

    private Game game;
    private World world;

    boolean start = false;
    boolean help = false;

    public GameView(GameWorld game, int width, int height, boolean start, boolean help) {
        super(game, width, height);

        backgroundFrame = new JFrame("abc");

    }

    public void levelBackground(){
        background = new ImageIcon("data/Level1BG.jpeg");
        backgroundLabel = new JLabel(background);
        backgroundLabel.setSize(800,600);
        backgroundFrame.add(backgroundLabel);
        backgroundFrame.pack();

    }

    public void mainMenu(){
        mainMenu = new ImageIcon("data/MainMenu.png");
        menuLabel = new JLabel(mainMenu);
        menuLabel.setSize(800,600);
        backgroundFrame.add(menuLabel);
        backgroundFrame.pack();


    }
/*
    @Override
    protected void paintBackground(Graphics2D g) {
        //JComponent defines this method
        super.paintBackground(g);
        g.drawImage(background, 0, 0, this);
    }

 */
}
