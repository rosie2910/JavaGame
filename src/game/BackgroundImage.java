
package game;

import city.cs.engine.UserView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class BackgroundImage extends UserView {

        Image background;

        public BackgroundImage(GameWorld world, int width, int height){
            super(world, width, height);
            background = new ImageIcon("data/Level1BG.jpeg").getImage();
        }

        @Override
        protected void paintBackground(Graphics2D g){
            g.drawImage(background, 0, 0, this);
        }


    }

