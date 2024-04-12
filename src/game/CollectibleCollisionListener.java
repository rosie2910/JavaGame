package game;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
public class CollectibleCollisionListener implements CollisionListener{
    Player player;
    Collectible collectible;
    public CollectibleCollisionListener(Player player, Collectible collectible){
        this.player = player;
        this.collectible = collectible;
    }

    public void collide(CollisionEvent collisionEvent){
        player.setHp(player.getHp() + 15);
        if(player.getHp() > 100){
            player.setHp(100);
        }
        //System.out.println("collided");
        collectible.destroy();
    }


}
