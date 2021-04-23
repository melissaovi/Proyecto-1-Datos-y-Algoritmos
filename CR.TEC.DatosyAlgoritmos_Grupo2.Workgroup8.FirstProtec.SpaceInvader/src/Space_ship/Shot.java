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
    AliensBasic ene;
    AlienA ali;
    AliensB aliensB;
    AlienC alienC;
    public static int shotHeight = 0;
    public static boolean shotState = true;
    public Shot(int xVal, int yVal,AliensBasic aa,AlienA bb,AliensB aliensB1,AlienC alienC1) {
        x = xVal;//La posicion de la bala
        shotHeight = yVal;
        ene=aa;
        ali=bb;
        aliensB=aliensB1;
        alienC=alienC1;
        Thread thread = new Thread(this);
        thread.start();
    }
    /**Elimina la bala si se golpea un enemigo
     */
     private boolean moveShot(){
        if(ene.checkShot(x,shotHeight)){
            shotHeight=-10;
            setShotState(false);
            return true;
        }
        if(ali.checkShot(x,shotHeight)){
            setShotState(false);
            shotHeight=-10;
            return true;
        }
        if(aliensB.checkShot(x,shotHeight)){
            setShotState(false);
            shotHeight=-10;
            return true;
        }
        if(alienC.checkShot(x,shotHeight)){
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
            g.fillRect(x, shotHeight, SHOT_WIDTH, SHOT_HEIGHT);

        } else {
            setShotState(true);

        }

    }

    public static boolean getShotState() {
        return shotState;
    }
    public static void setShotState(boolean shot) { shotState = shot; }

    /**
     * Mantiene le movimiento de la bala siempre que esta exista
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
