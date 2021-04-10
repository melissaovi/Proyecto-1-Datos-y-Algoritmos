package Enemies;

import Main.Assets;

import java.awt.*;

public class Enemy {
    private int posX, posY, width, height,speed;
    private boolean hitState = false;
    public Enemy(int posX, int posY, int width, int height, int speed) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.speed=speed;
    }
    public boolean hasBeenHit() {
        return hitState;
    }
    public boolean hitAlien(int x,int y){
        if (hitState) {
            //If it's alreay been shot then return false;
            return false;
        }
        if ((x >= posX) && (x <= (posX+width))) {
            //X is ok, now lets check the Y range
            if ((y >= posY) && (y <= (posY+height))) {
                //We shot an alien!
                hitState = true;
                return true;
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
    public void draw(Graphics g) {
        g.drawImage(Assets.alien,this.getPosX(), this.getPosY(), this.getWidth(), this.getHeight(), null);
    }
    public void updated(double delta) {
    }
}
