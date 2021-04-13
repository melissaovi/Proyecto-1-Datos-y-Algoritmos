package Enemies;

import Main.Load;
import Space_ship.Shot;
import java.awt.*;
import java.awt.image.BufferedImage;

import static Space_ship.Shot.shotState;

public class Enemy {
    public boolean O = true;
    private BufferedImage sprite;
    private int posX, posY, width, height,speed,life;
    private boolean hitState = false;
    private boolean boss;
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
    public boolean hasBeenHit() {
        return hitState;
    }
    public boolean hitAlien(int x,int y, boolean without_boss){
        if (without_boss && O){
            this.life-=1;
            hitState = true;
            //Shot.shotHeight = -1;

        }
        if (hitState) {
            //If it's alreay been shot then return false;
            shotState = true;
            return false;
        }
        if ((x >= posX) && (x <= (posX+width))) {
            //X is ok, now lets check the Y range
            if ((y >= posY) && (y <= (posY+height))) {
                if(getLife()>0  && Shot.getShotState()){

                    this.life-=1;
                    if (this.boss){
                        System.out.println("works 2 "+ this.life);

                        return true;
                    }
                    System.out.println("works 2 "+ this.life);

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
    public void Boss() {
        this.boss =true;
        this.life =1;
        this.setWidth(30);
        this.setHeight(50);
        this.sprite= Load.imageLoad("/Alien_boss.png");
    }
    public boolean getBoss() {
        return boss;
    }
    public int getLife(){
        return life;
    }
    public void draw(Graphics g) {
        if(!hitState){
            g.drawImage(this.getSprite(),this.getPosX(), this.getPosY(), this.getWidth(), this.getHeight(), null);
        }
    }
    public void updated(double delta) {
    }
}
