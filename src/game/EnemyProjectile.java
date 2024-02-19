package game;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;


import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

    public class EnemyProjectile extends DynamicBody {
        private static final BodyImage projectile = new BodyImage("data/projectile1.png", 1);

        public EnemyProjectile(World room, Player player, Enemy enemy) {
            super(room);
            this.setGravityScale(0);
            this.addImage(projectile);
            this.setPosition(new Vec2(enemy.getEnX(), enemy.getEnY()));

        }

        public void attack(Player player, KeyMover playerMover) {
            //this.setLinearVelocity(new Vec2(3,3));
            this.setLinearVelocity(new Vec2(player.getCharX(playerMover), player.getCharY(playerMover)));
            this.applyForce(new Vec2(player.getCharX(playerMover), player.getCharY(playerMover)));
            System.out.println("shoot at " + player.getCharX(playerMover) + ", " + player.getCharY(playerMover));
        }

    }


