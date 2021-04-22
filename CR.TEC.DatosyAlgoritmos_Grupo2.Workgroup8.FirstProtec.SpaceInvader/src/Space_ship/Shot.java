package Space_ship;

import Enemies.AlienA;
import Enemies.AlienC;
import Enemies.AliensB;
import Enemies.AliensBasic;

import java.awt.*;
public class Shot implements Runnable {
    //Atributos de la clase de disparo
    private int shotSpeed = 2;
    private int SHOT_WIDTH = 4;
    private int SHOT_HEIGHT = 10;
    public int x = 0;
    AliensBasic aliBasic;
    AlienA aliA;
    AliensB aliB;
    AlienC aliC;
    public static int shotHeight = 0;
    public static boolean shotState = true;

    /**
     * Constructor de la clase de la bala
     * */
    public Shot(int xVal, int yVal,AliensBasic aliBasic,AlienA aliA,AliensB aliB,AlienC aliC) {

        x = xVal;//La posicion de la bala
        shotHeight = yVal;

        this.aliBasic = aliBasic;
        this.aliA = aliA;
        this.aliB = aliB;
        this.aliC = aliC;

        Thread thread = new Thread(this);
        thread.start();
    }

    /**
    * Elimina la bala si se golpea un enemigo
    * */
     private boolean moveShot(){
        if(aliBasic.checkShot(x,shotHeight)){
            shotHeight=-10;
            setShotState(false);
            return true;
        }
        if(aliA.checkShot(x,shotHeight)){
            setShotState(false);
            shotHeight=-10;
            return true;
        }
        if(aliB.checkShot(x,shotHeight)){
            setShotState(false);
            shotHeight=-10;
            return true;
        }
        if(aliC.checkShot(x,shotHeight)){
            setShotState(false);
            shotHeight=-10;
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

    /**
     * Dibuja la bala
     * @param g
     */
    public void drawShot(Graphics g) {
        if (getShotState()) {
            g.setColor(Color.white);

        } else {
            g.setColor(Color.red);
            shotHeight = 0;

        }
        g.fillRect(x, shotHeight, SHOT_WIDTH, SHOT_HEIGHT);
    }

    public static boolean getShotState() {
        return shotState;
    }

    public static void setShotState(boolean shot) {
        shotState = shot;
    }

    /**
     * Mantiene el movimiento de la bala siempre que esta exista
     */
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
