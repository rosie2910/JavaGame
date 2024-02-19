package game;

import java.lang.String;
import java.util.random.RandomGenerator;

public class Level {
    String levelType;
    private static int levelCount = 0;
    public int enemyNo;


    public static int getLevelCount() {
        return levelCount;
    }

    public static void setLevelCount(int levelCount) {
        Level.levelCount = levelCount;
    }
}
