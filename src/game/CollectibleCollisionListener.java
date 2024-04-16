package game;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
public class CollectibleCollisionListener implements CollisionListener {
    Player player;
    Collectible collectible;

    public CollectibleCollisionListener(Player player, Collectible collectible) {
        this.player = player;
        this.collectible = collectible;
    }

    public void collide(CollisionEvent collisionEvent) {
        if (collectible.collectibleType.equals("heart")) {
            player.setHp(player.getHp() + 15);
            if (player.getHp() >= 100) {
                player.setHp(100);
            }
            //System.out.println("collided");
            collectible.getCollectible().destroy();
        } else if (collectible.collectibleType.equals("gem")) {
            player.setGemCount(player.getGemCount() + 1);
            System.out.println("increase gem count");
            collectible.getCollectible().destroy();
        } else {
            collectible.getCollectible().destroy();
        }

    }
}