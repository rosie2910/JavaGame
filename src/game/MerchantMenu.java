package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MerchantMenu extends JPanel {
    Player player;
    int reqGems;

    Image menuBackground = new ImageIcon("data/MerchantMenu.png").getImage();
    boolean buy = true;
    public MerchantMenu(Player player){
        this.player = player;
        //JTextArea hearts = new JTextArea("Heart");
        JButton heartBuy = new JButton("Buy");
        JButton heartSell = new JButton("Sell");
        JButton replenishHP = new JButton("Buy");
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
        replenishHP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replenishHP();
            }
        });
        this.setLayout(null);
        heartBuy.setBounds(150, 55, 50, 20);
        heartSell.setBounds(230, 55, 50, 20);
        this.add(heartBuy);
        this.add(heartSell);
        Dimension size = new Dimension(400, 300);
        this.setPreferredSize(size);
        this.add(replenishHP);
        replenishHP.setBounds(250, 100, 50, 20);

    }

    public void buyHeart(){
        reqGems = 2;
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

    public void replenishHP(){
        if(player.getHp() >= 100){
            System.out.println("You don't need this");
        }
        else if(player.getHp() >= 85 && player.getHp() < 100){
            this.setReqGems(2);
            System.out.println(getReqGems());
            player.setHp(100);
            player.setGemCount(player.getGemCount() - reqGems);
        }
        else if(player.getHp() < 85 && player.getHp() >= 70){
            this.setReqGems(3);
            System.out.println(getReqGems());
            player.setHp(100);
            player.setGemCount(player.getGemCount() - reqGems);
        }
        else if(player.getHp() < 70 && player.getHp() >= 55){
            this.setReqGems(6);
            System.out.println(getReqGems());
            player.setHp(100);
            player.setGemCount(player.getGemCount() - reqGems);
        }
        else if(player.getHp() < 55 && player.getHp() >= 40){
            this.setReqGems(8);
            System.out.println(getReqGems());
            player.setHp(100);
            player.setGemCount(player.getGemCount() - reqGems);
        }
        else if(player.getHp() < 40 && player.getHp() >= 25){
            this.setReqGems(10);
            System.out.println(getReqGems());
            player.setHp(100);
            player.setGemCount(player.getGemCount() - reqGems);
        }
        else{
            this.setReqGems(12);
            System.out.println(getReqGems());
            player.setHp(100);
            player.setGemCount(player.getGemCount() - reqGems);
        }
        this.repaint();
    }


    @Override
    protected void paintComponent(Graphics g){
        g.drawImage(menuBackground, 0, 0, this);
        g.drawString("Heart: 2 Gems", 50, 70);
        g.drawString("for: 1 Gem", 285, 70);
        g.drawString("Your Funds: " + player.getGemCount() + " gems", 260, 280);
        g.drawString("Replenish HP: " + this.getReqGems() + " gems", 50, 100);

    }

    public int getReqGems(){
        return reqGems;
    }

    public void setReqGems(int reqGems){
        this.reqGems = reqGems;
    }


}