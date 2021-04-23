package Menu_and_game_things;

import java.awt.*;
/**
 * La clase se encarga de sumar un punto cuando se elimina un alien y mostrarlo en pantalla*/
public class Score_Table {
    static int point = 0;

    public static void draw(Graphics g) {
        g.setFont(new Font("Bookman Old Style", Font.TYPE1_FONT, 16));
        g.setColor(Color.WHITE);

        g.drawString("Puntos:", 500, 100);
        g.drawString(""+point, 570, 100);

    }
    public int getpoints() {

        return point;
    }
    public static void setPoint(){

        point++;
    }

}
