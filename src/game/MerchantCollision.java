package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

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
        }
    }
}
