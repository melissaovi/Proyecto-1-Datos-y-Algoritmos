package Space_ship;
import Main.Assets;
import Main.Window;
import java.awt.event.*;
import java.awt.*;
public class Ship implements MouseListener, MouseMotionListener {

    private int x_position = 0;
    Window window;
    private int heightPosition = 0;//La posicion de la nave respecto al tamaño de la ventana
    Shot shot = null;//Estaod de disparo
    //Constructor de la clase ship
    public Ship(Window si) {
        window = si;
        x_position = (int) ((Window.WIDTH / 2) + (50 / 2));
        heightPosition = Window.HEIGHT - 38-75;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int newX = e.getX();//Get the mouse coordinates
        if (newX > (Window.WIDTH - 65)) {
            x_position = Window.WIDTH - 65;
        } else {
            x_position = newX;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        shot = new Shot(x_position + (int) (50 / 2), heightPosition);
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
        g.drawImage(Assets.player, x_position, 600, null);
        if ((shot != null) && (shot.getShotState())) {
            shot.drawShot(g);
        }

    }
}
