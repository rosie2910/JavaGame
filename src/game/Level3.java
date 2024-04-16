package game;

import city.cs.engine.DebugViewer;
import org.jbox2d.common.Vec2;

import javax.swing.*;

public class Level3 extends GameLevel{
    Game game;
    Enemy enemy;
    Enemy enemy2;
    Player player;
    Merchant merchant;
    public Level3(Game game){
        super(game);
        player = getPlayer();
        player.setHp(30);
        player.setPosition(new Vec2(0, 10));
        this.enemy = getEnemy();
        this.enemy2 = getEnemy2();
        enemy.setPosition(new Vec2(-6,7));
        enemy2.setPosition(new Vec2(5,-3));
        JFrame debug = new DebugViewer(this, 500, 500);

        EnemyShooting shoot = new EnemyShooting(getEnemy(), player, this);
        EnemyShooting shoot2 = new EnemyShooting(getEnemy2(), player, this);
        merchant = new Merchant(this);
        merchant.setPosition(new Vec2(0,5));
        MerchantCollision mc = new MerchantCollision(player, merchant);
        player.addCollisionListener(mc);

        getEnemy().die(player);
        getEnemy2().die(player);
    }

    public Merchant getMerchant(){
        return merchant;
    }




    @Override
    public boolean isComplete() {
        return false;
    }

}
