package Enemies;

import Menu_and_game_things.Listas.ListasEnlazadas;
import Space_ship.Ship;
import java.awt.*;

public class Alien {
    
    public static int ALIEN_HEIGHT = 10;
    public static int ALIEN_WIDTH = 15;
    private int leftPosition = 0;
    private int heightPosition = 0;
    private boolean hitState = false;
    private Image alienImage = null;

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

}

