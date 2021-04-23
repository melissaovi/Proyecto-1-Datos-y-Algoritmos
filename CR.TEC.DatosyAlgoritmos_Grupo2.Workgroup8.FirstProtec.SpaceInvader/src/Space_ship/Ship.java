package Space_ship;
import Enemies.AlienA;
import Enemies.AlienC;
import Enemies.AliensB;
import Enemies.AliensBasic;
import Main.Assets;
import Main.Window;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
public class Ship implements MouseListener, MouseMotionListener {

    public int x = 0;
    Window window=null;
    public int heightPosition = 0;//La posicion de la nave respecto al tamaño de la ventana
    Shot shot = null;//Estado de disparo

    boolean hitState=false;

    public static int SHIP_HEIGHT = 38;
    public static int SHIP_WIDTH = 50;



    //Constructor de la clase ship
    public Ship(Window si) {
        window = si;
        x = (int) ((Window.WIDTH / 2) + (50 / 2));
        heightPosition = Window.HEIGHT - 38-75;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int newX = e.getX();//Get the mouse coordinates
        if (newX > (Window.WIDTH - 250)) {
            x = Window.WIDTH - 250;
        } else {
            x = newX;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        AliensBasic ene=window.getAlienArmy();
        AlienA ali= window.getAli();
        AliensB aliensB=window.getAliensB();
        AlienC alienC=window.getAlienC();
        //Alien army = window.getAlienArmy();
        shot = new Shot(x +(50 / 2), heightPosition,ene,ali,aliensB,alienC);
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }
    //Dibujar la nave
    public void drawShip(Graphics g) {
        g.drawImage(Assets.player, x, 600, null);

        if ((shot != null)){// && (shot.getShotState())) {

            shot.drawShot(g);
        }
    }
}
