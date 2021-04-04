package Enemies;

import Menu_and_game_things.Listas.ListasEnlazadas;
import Space_ship.Ship;
import java.awt.*;

public class Alien {

    public int xx = 0, yy = 0;
    public static int ALIEN_HEIGHT = 10;
    public static int ALIEN_WIDTH = 15;
    private int leftPosition = 0;
    private int heightPosition = 0;
    private boolean hitState = false;
    private Image alienImage = null;

    public boolean moveRight = true;
    public boolean moveLeft = false;
    //public boolean moveDown = false;

    int moveDistance = 15;
    int moveDistanceX = 1;

    Window spaceInvaders = null;
    //Alien a=new Alien(spaceInvaders,null);

    private ListasEnlazadas lista = new ListasEnlazadas();

    public Alien(Window si) {
        spaceInvaders = si;
    }

    public void ColocarAliensenListaPrimero(Alien alien) {
        for (int i = 0; i < 10; i++) {
            lista.insertHead(alien);
        }
        System.out.println(lista.gett(4));
        System.out.println(lista.gett(2));
    }

    public boolean hasBeenHit() {
        return hitState;
    }

    public boolean hitAlien(int x, int y) {
        //Is the alien currently alive?
        if (hitState) {
            //If it's alreay been shot then return false;
            return false;
        }
        //First lets check the X range
        if ((x >= leftPosition) && (x <= (leftPosition + ALIEN_WIDTH))) {
            //X is ok, now lets check the Y range
            if ((y >= heightPosition) && (y <= (heightPosition + ALIEN_HEIGHT))) {
                //We shot an alien!
                hitState = true;
                return true;
            }
        }
        return false;
    }

    public void setPosition(int x, int y) {
        leftPosition = x;
        heightPosition = y;
    }

    public int getXPos() {
        return leftPosition;
    }

    public int getYPos() {
        return heightPosition;
    }

    public void drawAlien(Graphics g) {
        if (!hitState) {
            for (int i = 0; i < lista.getSize(); i++) {
                g.setColor(Color.red);
                g.fillRect(leftPosition+50*i, heightPosition, ALIEN_WIDTH, ALIEN_HEIGHT);
            }
        }
    }

    public void moveAlien(){
        for (int i = 0; i < lista.getSize(); i++){
            Alien ali = (Alien) lista.gett(i);
            xx = ali.getXPos();
            yy = ali.getYPos();
            xx++;
            ali.setPosition(xx, yy);
        }
    }

    /*public void moveAlien(){
        if (moveRight) {
            for (int i = lista.getSize(); i >= 0; i--) {
                Alien ali = (Alien) lista.gett(i);
                if (!ali.hasBeenHit()){

                    if (ali.getXPos() > Window.WIDTH-ALIEN_WIDTH-10){
                        moveRight = false;

                        for (int y = 0; y < lista.getSize(); y++){
                            Alien al = (Alien) lista.gett(y);
                            al.setPosition(al.getXPos(), al.getYPos()+moveDistance);
                        }
                        return;
                    }
                }
            }

            for (int i = 0; i < lista.getSize(); i++){
                Alien ali = (Alien) lista.gett(i);
                ali.setPosition(ali.getXPos()+moveDistanceX, ali.getYPos());
            }

        } else {
            for (int i = 0; i < lista.getSize(); i++) {
                Alien ali = (Alien) lista.gett(i);
                if (!ali.hasBeenHit()){

                    if (ali.getXPos() < ALIEN_WIDTH){
                        moveRight = true;

                        for (int y = 0; y < lista.getSize(); y++){
                            Alien al = (Alien) lista.gett(y);
                            al.setPosition(al.getXPos(), al.getYPos()+moveDistance);
                        }
                        return;
                    }
                }
            }

            for (int i = 0; i < lista.getSize(); i++){
                Alien ali = (Alien) lista.gett(i);
                ali.setPosition(ali.getXPos()-moveDistanceX, ali.getYPos());
            }
        }
    }*/

}
