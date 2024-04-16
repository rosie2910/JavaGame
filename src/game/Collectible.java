package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.random.RandomGenerator;

public class Collectible extends StaticBody {

    private static final Shape collectibleShape = new BoxShape(0.5f,0.5f);
    //private static final Shape gemShape = new BoxShape(0.5f, 0.5f);

    private final BodyImage heart = new BodyImage("data/HeartCollectible.gif", 2);
    private final BodyImage gem = new BodyImage("data/Gem-1.png.png", 2);
    Player player;
    String collectibleType;


    public Collectible(GameLevel world, Enemy enemy, Player player) {
        super(world, collectibleShape);
        this.player = player;
        int num = generateRandom();
        if(num == 1){
            collectibleType = "nothing";
            this.destroy();

        }
        if(num == 2){
            this.addImage(heart);
            this.setPosition(new Vec2(enemy.getPosition().x, enemy.getPosition().y));
            collectibleType = "heart";
        }
        else{
            this.addImage(gem);
            this.setPosition(new Vec2(enemy.getPosition().x, enemy.getPosition().y));
            collectibleType = "gem";
        }


    }

    public int generateRandom(){
        int min = 0;
        int max = 3;

        int randomInt = (int)Math.floor(Math.random() * (max - min + 1) + min);
        System.out.println("random number in enemy: " + randomInt);

        return randomInt;
    }

    public Collectible getCollectible(){
        return this;
    }
}
