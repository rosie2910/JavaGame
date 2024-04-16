package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MerchantMenu extends JPanel {
    Player player;

    Image menuBackground = new ImageIcon("data/MerchantMenu.png").getImage();
    boolean buy = true;
    public MerchantMenu(Player player){
        this.player = player;
        //JTextArea hearts = new JTextArea("Heart");
        JButton heartBuy = new JButton("Buy");
        JButton heartSell = new JButton("Sell");
        heartBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buyHeart();
            }
        });
        heartSell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sellHeart();
            }
        });
        this.setLayout(null);
        heartBuy.setBounds(150, 55, 50, 20);
        heartSell.setBounds(230, 55, 50, 20);
        this.add(heartBuy);
        this.add(heartSell);
        Dimension size = new Dimension(400, 300);
        this.setPreferredSize(size);

    }

    public void buyHeart(){
        int reqGems = 2;
        if(player.getGemCount() < reqGems){
            System.out.println("Insufficient Funds!");
        }
        else if(player.getHp() >= 100){
            System.out.println("You don't need hearts!");
        }
        else{
            player.setHp(player.getHp() + 10);
            //System.out.println(player.getHp());
            player.setGemCount(player.getGemCount() - reqGems);
            this.repaint();
        }
    }

    public void sellHeart(){
        int gemsGiven = 1;
        if(player.getHp() <= 20){
            System.out.println("You don't have enough HP!");
        }
        else{
            player.setHp(player.getHp() - 15);
            player.setGemCount(player.getGemCount() + gemsGiven);
            this.repaint();
        }
    }


    @Override
    protected void paintComponent(Graphics g){
        g.drawImage(menuBackground, 0, 0, this);
        g.drawString("Heart: 2 Gems", 50, 70);
        g.drawString("for: 1 Gem", 285, 70);
        g.drawString("Your Funds: " + player.getGemCount() + " gems", 260, 280);

    }

}