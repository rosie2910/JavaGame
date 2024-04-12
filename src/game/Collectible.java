package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.random.RandomGenerator;

public class Collectible extends StaticBody {

    private static final Shape heartShape = new BoxShape(0.5f,0.5f);

    private final BodyImage heart = new BodyImage("data/HeartCollectible.gif", 2);
    Player player;


    public Collectible(GameLevel world, Enemy enemy, Player player) {
        super(world, heartShape);
        this.player = player;
        this.addImage(heart);
        this.setPosition(new Vec2(enemy.getPosition().x, enemy.getPosition().y));

    }
}