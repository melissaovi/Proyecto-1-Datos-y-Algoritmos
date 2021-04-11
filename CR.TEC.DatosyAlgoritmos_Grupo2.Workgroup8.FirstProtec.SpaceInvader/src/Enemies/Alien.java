/*
package Enemies;

import Main.Assets;
import Menu_and_game_things.Listas.ListasEnlazadas;
import Space_ship.Ship;

import java.awt.*;

public class Alien {
    public int xx = 0, yy = 0,cc=145;
    public static int ALIEN_HEIGHT = 64;
    public static int ALIEN_WIDTH = 64;
    private int leftPosition = 0;
    private int heightPosition = 0;
    private boolean hitState = false;
    private Image alienImage = null;
    boolean movingRight =true;
    int bajar=0;
    int cont=0;
    private Ship ship;

    public Window window;
    //Alien a=new Alien(spaceInvaders,null);

    public ListasEnlazadas lista = new ListasEnlazadas();


    public Alien(Window si,Ship s) {
        window = si;
        ship=s;
    }

public void ColocarAliensenListaPrimero(Alien alien) {
        for (int i = 0; i <9; i++) {
            lista.insertHead(alien);
            System.out.println(alien);
        }

    }


    public boolean hasBeenHit() {
        return hitState;
    }

    public boolean  hitAlien(int x, int y) {
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

    public void DrawAlien(Graphics g){
        g.drawImage(Assets.alien,leftPosition,heightPosition,null);
    }

public void drawAlien(Graphics g) {
        if (!hitState) {
            for (int i = 0; i < lista.getSize(); i++) {
                //g.setColor(Color.red);
                //g.fillRect(leftPosition+50*i, heightPosition, ALIEN_WIDTH, ALIEN_HEIGHT);
                g.drawImage(Assets.alien,leftPosition+50*i,heightPosition,null);
            }
        }
    }

    public void moveAlien(){
        aa:
        for (int i = 0; i < lista.getSize(); i++) {
            Alien ali = (Alien) lista.gett(i);
            if (xx<145) {
                ali.setPosition(ali.getXPos()+1, ali.getYPos());
                xx++;
            }else{
                xx=146;
                ali.setPosition(ali.getXPos(),ali.getYPos()+2);
                moveLeft();
                break aa;
            }
        }//
    }
    public void moveLeft(){
        bb:
        for (int i = 0; i < lista.getSize(); i++) {
            Alien ali = (Alien) lista.gett(i);
            if (cc>0){
                ali.setPosition(ali.getXPos()-1, ali.getYPos());
                cc--;
            }else{
                xx=0;
                cc=145;
                ali.setPosition(ali.getXPos(),ali.getYPos()+2);
                moveAlien();
                break bb;
            }
        }
    }
    public boolean checkShot(int x, int y) {
        for (int i = 0; i <lista.getSize(); i++){
            Alien ali=(Alien) lista.gett(i);
            if (ali.hitAlien(x, y)){
                System.out.println("Detecto colision");
                return true;
            }
        }
        return false;
    }
}

*/
