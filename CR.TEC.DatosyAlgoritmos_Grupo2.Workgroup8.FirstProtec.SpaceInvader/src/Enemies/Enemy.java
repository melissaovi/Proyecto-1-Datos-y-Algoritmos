package Enemies;
import Main.Load;
import Space_ship.Shot;
import java.awt.*;
import java.awt.image.BufferedImage;

import static Space_ship.Shot.shotState;

/**
 * Clase que contiene los atributos de los enemigos
 */
public class Enemy {
    public boolean O = true;
    private BufferedImage sprite;
    private int posX, posY, width, height,speed,life;
    private boolean hitState = false;
    private boolean boss;

    /**
     * @param posX Posicion x de los aliens
     * @param posY Posicion y de los aliens
     * @param width Ancho de los aliens
     * @param height Altura  de los aliens
     * @param speed Velocidad de los aliens
     * @param life  Vida de los aliens
     * @param sprite Imagen que contienen los aliens
     */
    public Enemy(int posX, int posY, int width, int height, int speed,int life,BufferedImage sprite) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.speed=speed;
        this.life=life;
        this.sprite=sprite;
        this.boss=false;
    }

    /**
     * Si el valor es verdadero no dibuja a el alien, de ser falso lo sigue dibujando
     * @return Boolean
     */
    public boolean hasBeenHit() {
        return hitState;
    }

    /**
     * Elimina la vida del alien, de ser 0 retorna el valor de hitState
     * para dejar de dibujar al alien en específico
     * @param x
     * @param y
     * @param without_boss
     * @return
     */
    public boolean hitAlien(int x,int y, boolean without_boss){
        if (without_boss){
            this.life-=1;
            hitState = true;
        }
        if (hitState) {
            shotState = true;
            return false;
        }
        if ((x >= posX) && (x <= (posX+width))) {
            //X is ok, now lets check the Y range
            if ((y >= posY) && (y <= (posY+height))) {
                //System.out.println("works 2 "+ Shot.getShotState());
                if(getLife()>0  && Shot.getShotState()){
                    //Shot.setShotState(false);
                    //System.out.println("works 2 "+ this.boss);
                    this.life-=1;
                    if (this.boss){
                        return true;
                    }
                    boss=false;
                    hitState = false;
                    return false;
                }else{
                    hitState = true;
                    return true;
                }
            }
        }
        return false;
    }
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public int getSpeed(int speed){return speed;}
    public BufferedImage getSprite() {
        return sprite;
    }

    /**
     * Método para crear los jefe
     */
    public void Boss() {
        this.boss =true;
        this.life =1;
        this.setWidth(30);
        this.setHeight(50);
        this.sprite= Load.imageLoad("/Alien_boss.png");
    }

    /**
     * Cambiar de jefe
     */
    public void ChangeBoss() {
        this.boss =false;
        this.life =0;
        this.setWidth(30);
        this.setHeight(50);
        this.sprite= Load.imageLoad("/alien (2).png");
    }

    /**
     * @return boss
     */
    public boolean getBoss() {
        return boss;
    }

    /**
     * @return life
     */
    public int getLife(){
        return life;
    }

    /**
     * Dibujar a los aliens individualmente
     * @param g
     */
    public void draw(Graphics g) {
        if(!hitState){
            g.drawImage(this.getSprite(),this.getPosX(), this.getPosY(), this.getWidth(), this.getHeight(), null);
        }
    }
}
