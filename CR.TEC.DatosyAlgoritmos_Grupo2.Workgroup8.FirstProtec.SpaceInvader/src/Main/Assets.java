package Main;

import java.awt.image.BufferedImage;

public class Assets{

    public static BufferedImage player;
    public static BufferedImage alien;

    public static void init(){
        player = Load.imageLoad("/player.png");
        alien=Load.imageLoad("/alien (2).png");
    }
}
