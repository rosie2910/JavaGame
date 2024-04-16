package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

import javax.swing.*;

public class MerchantCollision implements CollisionListener {
    Player player;
    Merchant merchant;
    public MerchantCollision(Player player, Merchant merchant){
        this.player = player;
        this.merchant = merchant;
    }


    @Override
    public void collide(CollisionEvent collisionEvent) {
        if(collisionEvent.getOtherBody() instanceof Merchant){
            System.out.println("Menu");
            JFrame merchantFrame = new JFrame("Merchant Menu");
            MerchantMenu merchantMenu = new MerchantMenu(player);
            merchantFrame.add(merchantMenu);
            merchantFrame.setSize(400,300);
            merchantFrame.setLocationByPlatform(true);
            merchantFrame.setResizable(false);
            merchantFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            merchantFrame.pack();
            merchantFrame.setVisible(true);

        }
    }
}