package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.StaticBody;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Merchant extends StaticBody {
    public BodyImage merchantImage = new BodyImage("data/Merchant.gif", 5);
    private static final BoxShape merchantShape = new BoxShape(1,1);


    public Merchant(GameLevel world){
        super(world, merchantShape);
        this.addImage(merchantImage);

    }

}
