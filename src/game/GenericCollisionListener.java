
package game;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class GenericCollisionListener implements CollisionListener {
    Player player;
    GameLevel world;
    Door door;
    Game game;
    public GenericCollisionListener(Player player, Door door, GameLevel world, Game game){
        this.player = player;
        this.door = door;
        this.world = world;
        this.game = game;
    }


    @Override
    public void collide(CollisionEvent collisionEvent) {
        if(collisionEvent.getOtherBody() instanceof Door && world.isComplete()){
            System.out.println("hi");
            game.goToNextLevel();
            //doorcollision = true;

        }
    }
}
