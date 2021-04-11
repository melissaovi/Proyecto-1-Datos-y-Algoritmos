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
    public int shotHeight = 0;

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
        if(ene.checkShot(x,shotHeight)){
            //ene.getEnemies().delete(i);
            System.out.println("We shot an alien!");
            shotState = false;
            return true;
        }
        if(ali.checkShot(x,shotHeight)){
            System.out.println("We shot an alien 2222!");
            shotState = false;
            return true;
        }

        shotHeight = shotHeight - 2;
        //Si la bala sale del limite de la pantalla
        if (shotHeight < 0) {
            shotState = false;
            return true;
        }
        return false;
    }

    public void drawShot(Graphics g) {
        if (shotState) {
            g.setColor(Color.white);
        } else {
            g.setColor(Color.black);
        }
        g.fillRect(x, shotHeight, SHOT_WIDTH, SHOT_HEIGHT);
    }

    public boolean getShotState() {
        return shotState;
    }

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
