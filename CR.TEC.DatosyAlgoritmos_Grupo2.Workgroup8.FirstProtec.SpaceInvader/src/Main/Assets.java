package Main;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage player;

    public static void init(){
        player = Load.imageLoad("/player.png");
    }
}
