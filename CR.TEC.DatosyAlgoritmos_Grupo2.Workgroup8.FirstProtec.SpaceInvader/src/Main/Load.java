package Main;

// Clase encrgada de cargar los recursos

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Load {

    public static BufferedImage imageLoad(String path){
        try {
            return ImageIO.read(Load.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // si ocurre un error al cargar la imagen retorn null
    }
}
