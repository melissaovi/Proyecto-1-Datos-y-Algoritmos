package Enemies;

import Menu_and_game_things.Listas.ListasEnlazadas;
import Menu_and_game_things.Listas.Nodo;
import Space_ship.Shot;
import com.sun.nio.sctp.IllegalReceiveException;

import java.awt.*;
import java.util.concurrent.TimeoutException;

public class Alien {
    public int xx = 0, yy = 0, cc = 0;
    public static int ALIEN_HEIGHT = 10;
    public static int ALIEN_WIDTH = 15;
    private int leftPosition = 0;
    private int heightPosition = 0;
    private boolean hitState = false;
    private Image alienImage;
    boolean movingRight = true;
    int bajar = 0;
    int cont = 0;
    int bullet_pX;
    int p;

    Window spaceInvaders = null;
    //Alien a=new Alien(spaceInvaders,null);
    private ListasEnlazadas lista = new ListasEnlazadas();


    //private Space_ship.Shot bullet = new Shot(0,0);


    public Alien(Window si) {
        spaceInvaders = si;
    }

    public void ColocarAliensenListaPrimero(Alien alien) {
        for (int i = 0; i < 10; i++) {
            lista.insertHead(alien);
            alien = new Alien(spaceInvaders);
        }
        Alien alie = (Alien) lista.gett(0);
        p = alie.getYPos();
        System.out.println(lista.gett(4));
        System.out.println(lista.gett(2));
    }

    public boolean hasBeenHit() {
        return hitState;
    }

    public boolean hitAlien(int AlienXPos, int AlienYPos) {
        int i = 0;

        //while (i < lista.getSize()){
        //Nodo alien_alive = lista.gettt(i);
        //Alien ali = (Alien) lista.gett(i);


        int BulletXPos = Space_ship.Shot.getXPos_ofBullet();
        int BulletYPos = Space_ship.Shot.getYPos_ofBullet();
        //System.out.println(AlienXPos +" y "+ AlienYPos);
        //System.out.println(BulletXPos + " " +BulletYPos);

        if (BulletYPos <= AlienYPos && AlienXPos <= BulletXPos && BulletXPos < (AlienXPos + 15)
                && BulletXPos != 0) {
            lista.delete(i);


        }

        /*/Is the alien currently alive?
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
        }/*/
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

    public void drawAlien(Graphics g, boolean yes) {

        if (!hitState && yes) {
            for (int i = 0; i < lista.getSize(); i++) {
                g.setColor(Color.red);
                g.fillRect(leftPosition + 50 * i, heightPosition, ALIEN_WIDTH, ALIEN_HEIGHT);
                Alien ali = (Alien) lista.gett(i);
                ali.setPosition(leftPosition + 50 * i, heightPosition);
                System.out.println(ali.getXPos());
            }
        } else if (!hitState) {

            for (int i = 0; i < lista.getSize(); i++) {
                System.out.println("index "+i);
                moveAlien(i);
                g.setColor(Color.red);
                g.fillRect(leftPosition, heightPosition, ALIEN_WIDTH, ALIEN_HEIGHT);
            }

        } else {

            for (int i = 0; i < lista.getSize(); i++) {
                g.setColor(Color.red);
                g.fillRect(leftPosition + 50 * i, heightPosition, ALIEN_WIDTH, ALIEN_HEIGHT);
            }
        }

    }

    public void moveAlien(int index) {
        Alien ali = (Alien) lista.gett(index);
        System.out.println("ali:"+ali);
        if (xx < 1) {
            System.out.println("algsgsgs;");
            ali.setPosition(ali.getXPos() + 3, p);
            //hitAlien(ali.getXPos(), p);
            System.out.print(index +" "+ali  +" "+ ali.getXPos());
            //System.out.println(i +" "+ ali +" "+ ali.getXPos()+" "+p );
            //System.out.println("xx: " + xx);
            xx = xx + 1;
        } else if (xx == 1 && cc < 1) {

            ali.setPosition(ali.getXPos() - 3, p);
            //hitAlien(ali.getXPos(), p);
            //System.out.println("cc: " + cc);
            if (cc == 0) {
                p=p+20;
                for (int i = 0; i < lista.getSize(); i++) {
                    Alien all_aliens = (Alien) lista.gett(i);

                    System.out.println(all_aliens.getXPos() + " yes" + p);
                    ali.setPosition(all_aliens.getXPos(), p);
                }
            }
            cc++;

        } else {
            //p= ali.getYPos();
            p = p + 20;
            for (int i = 0; i < lista.getSize(); i++) {
                Alien all_aliens = (Alien) lista.gett(i);
                System.out.println(ali.getXPos() + "  " + p);
                ali.setPosition(ali.getXPos(), p);

                xx = 0;
                cc = 0;

            }
        }
    }
}
    /*/public void moveAlien() {

        for (int i = 0; i < lista.getSize(); i++) {
            Alien ali = (Alien) lista.gett(i);
            if (xx < 400) {
                ali.setPosition(ali.getXPos() + 3, p);
                hitAlien(ali.getXPos(), p);
                System.out.println(i +" "+ ali +" "+ ali.getXPos()+" "+p );
                //System.out.println("xx: " + xx);
                xx = xx + 1;
                //}else if(cc== 540){
            }else if (xx==400 && cc<400){

                ali.setPosition(ali.getXPos() - 3, p);
                hitAlien(ali.getXPos(), p);
                //System.out.println("cc: " + cc);
                if (cc==0){
                    p= p+20;
                    System.out.println(ali.getXPos() +" yes"+ p  );
                    ali.setPosition(ali.getXPos(), p);
                }
                cc++;
            }
            else{
                //p= ali.getYPos();
                p= p+20;
                System.out.println(ali.getXPos() +"  "+ p  );
                ali.setPosition(ali.getXPos(), p);

                xx=0;
                cc=0;
            }
            //} else {
                //throw new IllegalReceiveException("El limite de los números se ha superado");
              //  xx = 0;
                //ali.setPosition(ali.getXPos(), ali.getYPos() + 10);

               // break aa;



            }
            /*if (xx==540){
                xx=0;
                moveLeft();
                break aa;
            }
            //hitAlien(ali.getXPos(), ali.getYPos());
        }/*/

    /*/public void moveLeft() {
        //bb:
        for (int i = 0; i < lista.getSize(); i++) {
            Alien ali = (Alien) lista.gett(i);
            if (cc < 540) {
                ali.setPosition(ali.getXPos() - 2, ali.getYPos());
                System.out.println("cc: " + cc);
                cc = cc + 1;
                //}else if(cc== 540){

            //} else {
                //throw new IllegalReceiveException("El limite de los números se ha superado");
              //  cc = 0;
                //ali.setPosition(ali.getXPos(), ali.getYPos() + 10);

                //break bb;

            }
            if (cc==540){
                cc=0;
                moveAlien();
            }

        }

    }/*/



    /*public void move2(){
        for (int i = 0; i < lista.getSize(); i++) {
            Alien ali = (Alien) lista.gett(i);
            if (xx<600) {
                ali.setPosition(ali.getXPos()+1, ali.getYPos());
                xx++;
            }else{
                cont+=1;
                bajar=10*cont;
                ali.setPosition(0, ali.getYPos()+5);
                xx=0;
            }
        }
    }
*/










