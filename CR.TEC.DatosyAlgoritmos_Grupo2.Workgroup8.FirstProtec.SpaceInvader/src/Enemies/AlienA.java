package Enemies;

import Main.Load;
import Menu_and_game_things.Listas.ListasEnlazadas;

import java.awt.*;
import java.util.Random;

public class AlienA extends Aliens1{
    private boolean movingRight = true;
    private int downDistance=50;
    Random rand = new Random();
    int a = rand.nextInt(4);
    public AlienA(int posX, int posY, int speed, int size, int lvl) {
        super(posX, posY, speed, size, lvl);
        int counter = 0;
        this.setEnemies(new ListasEnlazadas<>());
        while (counter < size){
            Enemy enemy = new Enemy(posX+counter*50, posY, 30, 50, lvl,0, Load.imageLoad("/alien (2).png"));
            System.out.println(enemy);
            this.getEnemies().insertHead(enemy);
            counter++;
        }
        this.getEnemies().gett(a).Boss();
        this.setHaveBoss(true);
    }
    public void draw(Graphics g) {
        for(int c = 0; c < this.getEnemies().getSize(); c++) {
            this.getEnemies().gett(c).draw(g);
        }
    }
    public void moveArmy(){
        if(movingRight){
            for (int i = this.getEnemies().getSize()-1; i >= 0; i--){
                if (!this.getEnemies().gett(i).hasBeenHit()){
                    if (this.getEnemies().gett(i).getPosX()>556){
                        movingRight=false;
                        for (int y=0;y<this.getEnemies().getSize();y++){
                            this.getEnemies().gett(y).setPosY(this.getEnemies().gett(y).getPosY()+downDistance);
                        }
                        return;
                    }
                }
            }
            for (int i=0;i<this.getEnemies().getSize();i++){
                this.getEnemies().gett(i).setPosX(this.getEnemies().gett(i).getPosX()+this.getSpeed());
            }
        }else {
            for (int i = 0; i <this.getEnemies().getSize(); i++){
                if (!this.getEnemies().gett(i).hasBeenHit()){
                    if(this.getEnemies().gett(i).getPosX()<0){
                        movingRight=true;
                        for (int y=0;y<this.getEnemies().getSize();y++){
                            this.getEnemies().gett(y).setPosY(this.getEnemies().gett(y).getPosY()+downDistance);
                        }
                        return;
                    }
                }
            }
            for (int i = 0; i <this.getEnemies().getSize(); i++){
                this.getEnemies().gett(i).setPosX(this.getEnemies().gett(i).getPosX()-this.getSpeed());
            }
        }
    }
    public boolean checkShot(int x, int y) {
        for (int i = 0;i<this.getEnemies().getSize();i++){
            if (this.getEnemies().gett(i).hitAlien(x, y)) {
                return true;
            }
        }
        return false;
    }
}
