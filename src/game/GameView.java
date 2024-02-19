package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;

public class GameView extends UserView {
    private ImageIcon background;
    private JFrame backgroundFrame;
    int gameState;
    int titleState = 0;
    int playState = 1;


    private JLabel backgroundLabel;
    private ImageIcon mainMenu;
    private JLabel menuLabel;

    private Game game;
    private World world;


    boolean start = false;
    boolean help = false;

    public GameView(GameWorld game, int width, int height, boolean start, boolean help, UserView view) {
        super(game, width, height);
        gameState = playState;
        /*
        background = new ImageIcon("data/Level1BG.jpeg");
        backgroundLabel = new JLabel(background);
        backgroundLabel.setSize(800,600);
        backgroundFrame = new JFrame("Cat Quest");
        backgroundFrame.add(backgroundLabel);
        backgroundFrame.set

         */
        backgroundFrame = new JFrame("Cat Quest");
        //backgroundFrame.add(view);

        if(gameState == titleState){
            mainMenu();
            backgroundFrame.pack();
            backgroundFrame.setVisible(true);
        }
        else{
            levelBackground();
            backgroundFrame.pack();
            backgroundFrame.setVisible(true);
        }






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

    public JFrame getBackgroundFrame(){
        return backgroundFrame;
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
