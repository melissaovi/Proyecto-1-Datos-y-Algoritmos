package Space_ship;

import Enemies.AlienA;
import Enemies.AliensBasic;

import java.awt.*;
public class Shot implements Runnable {
    //Atributos de la clase de disparo
    private int shotSpeed = 2;
    private int SHOT_WIDTH = 4;
    private int SHOT_HEIGHT = 10;
    public int x = 0;
    AliensBasic ene;
    AlienA ali;
    public static int shotHeight = 0;

    public static boolean shotState = true;

    public Shot(int xVal, int yVal,AliensBasic aa,AlienA bb) {
        x = xVal;//La posicion de la bala
        shotHeight = yVal;
        ene=aa;
        ali=bb;

        Thread thread = new Thread(this);
        thread.start();
    }
    private boolean moveShot(){
        //System.out.println("X altura=" + shotHeight + " "+ getShotState());
        if(ene.checkShot(x,shotHeight)){
            //ene.getEnemies().delete(i);
            System.out.println("We shot an alien!");
            shotHeight = -10;
            setShotState(false);
            return true;
        }
        if(ali.checkShot(x,shotHeight)){
            System.out.println("We shot an alien 2222!");
            setShotState(false);
            shotHeight = -10;

            return true;
        }

        shotHeight = shotHeight - 2;
        //Si la bala sale del limite de la pantalla
        if (shotHeight < 0) {
            setShotState(false);
            return true;
        }
        return false;
    }

    public void drawShot(Graphics g) {
        if (getShotState()) {
            g.setColor(Color.white);
            g.fillRect(x, shotHeight, SHOT_WIDTH, SHOT_HEIGHT);

        } else {
            setShotState(true);

        }

    }

    public static boolean getShotState() {
        return shotState;
    }
    public static void setShotState(boolean shot) { shotState = shot; }

    //El thread que mueve la bala
    public void run() {
        while(true) {
            try {
                Thread.sleep(shotSpeed);
            } catch(InterruptedException ie) {

            }
            if (moveShot()) {
                break;
            }

        }
    }

}
