package game;

public class Level3 extends GameLevel{
    Game game;
    public Level3(Game game){
        super(game);
    }

    @Override
    public boolean isComplete() {
        return false;
    }

}