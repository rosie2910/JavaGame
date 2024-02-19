package game;

import city.cs.engine.UserView;
import city.cs.engine.Body;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class GameView extends UserView {
    private Image background;
    private Game game;
    private World world;

    public GameView(GameWorld game, int width, int height){
        super(game, width, height);

        background = new ImageIcon("data/Level1BG.jpeg").getImage();

    }

    @Override
    protected void paintBackground(Graphics2D g){
        //JComponent defines this method
        g.drawImage(background, 0,0,this);
    }





}

