package game;

import city.cs.engine.BoxShape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class Door extends StaticBody {

    private static final BoxShape doorShape = new BoxShape(1,1);
    public Door(GameLevel world){
        super(world, doorShape);
        Color clear = new Color(0,0,0,0);
        //StaticBody door1 = new StaticBody(world, new BoxShape(1,1));
        //door1.setPosition(new Vec2(-9,10));
        this.setFillColor(clear);
        this.setLineColor(clear);
    }

}