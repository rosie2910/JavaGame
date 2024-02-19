package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

public class GameWorld extends World{
    World room;
    Game frame;
    public void play(World room, UserView view){
// GameView background = new GameView(this, 800, 600, false, false);
        //background.paintBackground();
        //background.mainMenu();


        Enemy eyeball = new Enemy(room);
        Player player = new Player(room, 100, 1, 5);
        KeyMover playerMover = new KeyMover(view, player);

        for(int i = 0; i < 10; i++) {
            eyeball.walk(eyeball.getEnX(), eyeball.getEnY(), player);
            try{
                Thread.sleep(500);
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            EnemyProjectile projectile = new EnemyProjectile(room, player, eyeball);
            projectile.attack(player, playerMover);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            projectile.destroy();



        }



    }
}