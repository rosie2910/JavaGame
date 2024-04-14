package game;

import city.cs.engine.BodyImage;
import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackgroundImage extends UserView {

    Image background;
    Image healthBar;
    Player player;
    private int health;

    GameLevel world;

    Image level2BG = new ImageIcon("data/Level2BG.png").getImage();
    public BackgroundImage(GameLevel world, int width, int height, Player player){
        super(world, width, height);
        this.world = world;
        background = new ImageIcon("data/Level1BG.jpeg").getImage();
        healthBar = new ImageIcon("data/FullHearts-1.png.png").getImage();
        this.player = player;
    }

    public void reduceHealthBar(int health){
        if(health == 100){
            healthBar = new ImageIcon("data/FullHearts-1.png.png").getImage();
        }
        else if(health < 100 && health >= 87 ){
            healthBar = new ImageIcon("data/7_8Hearts-1.png.png").getImage();
        }
        else if(health < 87 && health >= 74){
            healthBar = new ImageIcon("data/6_8Hearts-1.png.png").getImage();
        }
        else if(health < 74 && health >= 61 ){
            healthBar = new ImageIcon("data/5_8Hearts-1.png.png").getImage();
        }
        else if(health < 61 && health >= 48){
            healthBar = new ImageIcon("data/HalfHearts-1.png.png").getImage();
        }
        else if(health < 48 && health >= 35){
            healthBar = new ImageIcon("data/3_8Hearts-1.png (1).png").getImage();
        }
        else if(health < 35 && health >= 22){
            healthBar = new ImageIcon("data/2_8Hearts-1.png.png").getImage();
        }
        else if(health < 22 && health >= 9){
            healthBar = new ImageIcon("data/1_8Hearts-1.png.png").getImage();
        }
        else{
            healthBar = new ImageIcon("data/NoHearts-1.png.png").getImage();
         /*
         if(player.dead == true){
             background = new ImageIcon("data/GameOver.png").getImage();
         }

          */
        }
    }

    @Override
    protected void paintBackground(Graphics2D g){

        if(world instanceof Level1) {
            g.drawImage(background, 0, 0, this);
        }

        else if(world instanceof Level2){
            g.drawImage(level2BG, 0, 0, this);
        }

    }


    @Override
    protected void paintForeground(Graphics2D g){
        //g.drawImage(healthBar, -5, 10, this);
        super.paintForeground(g);


        health = player.getHp();
        //System.out.println(health);





        reduceHealthBar(health);
        g.drawImage(healthBar,-5, 10, this);


    }

    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health = player.getHp();
    }

    @Override
    public void setWorld(World level){
        super.setWorld(level);
        world = ((GameLevel) level);
    }
}

