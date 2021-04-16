package Enemies;

import Main.Load;
import Menu_and_game_things.Listas.ListasEnlazadas;

import java.awt.*;
import java.util.Random;

public class AlienA extends Aliens1{

    private boolean movingRight = true;
    private int downDistance=50;
    public boolean onlyOnce = true;
    Random rand = new Random();
    int random_boss = rand.nextInt(4);
    public boolean hasboss;

    public AlienA(int posX, int posY, int speed, int size, int lvl) {
        super(posX, posY, speed, size, lvl);
        int counter = 0;
        this.setEnemies(new ListasEnlazadas<>());
        while (counter < size){
            Enemy enemy = new Enemy(posX+counter*50, posY, 30, 50, lvl,0, Load.imageLoad("/alien (2).png"));
            //System.out.println(enemy);
            this.getEnemies().insertHead(enemy);
            counter++;
        }
        this.getEnemies().gett(random_boss).Boss();
        this.setHaveBoss(true);
        hasboss =this.getEnemies().gett(random_boss).getBoss();
    }

    public void draw(Graphics g) {
        for(int c = 0; c < this.getEnemies().getSize(); c++) {
            this.getEnemies().gett(c).draw(g);
        }
    }

    public void moveArmy(){
        if(movingRight){
            for (int i = this.getEnemies().getSize()-1; i >= 0; i--){
                if (!this.getEnemies().gett(i).hasBeenHit()) {
                    if (this.getEnemies().gett(i).getPosX() > 556) {
                        movingRight = false;
                        for (int y = 0; y < this.getEnemies().getSize(); y++) {
                            this.getEnemies().gett(y).setPosY(this.getEnemies().gett(y).getPosY() + downDistance);
                        }
                        return;
                    }

                } else if (this.getEnemies().gett(random_boss).hasBeenHit() && onlyOnce){
                    System.out.println("sí");
                    onlyOnce = false;
                    checkShot( 0, 0 );
                    this.delEnemyNum(i);
                    //this.getEnemies().gett(i).hitAlien(0, 0, !onlyOnce);
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

                else if (this.getEnemies().gett(random_boss).hasBeenHit() && onlyOnce){
                    System.out.println("sí");
                    onlyOnce = false;
                    checkShot( 0, 0 );
                    this.delEnemyNum(i);
                    //this.getEnemies().gett(i).hitAlien(0, 0, !onlyOnce);
        }
            }
            for (int i = 0; i <this.getEnemies().getSize(); i++){
                this.getEnemies().gett(i).setPosX(this.getEnemies().gett(i).getPosX()-this.getSpeed());
            }
        }
    }

    public boolean checkShot(int x, int y )  {

        for (int i = 0;i<this.getEnemies().getSize();i++){
            //System.out.println("si: "+this.getEnemies().gett(i).getBoss());
            if (this.getEnemies().gett(i).hitAlien(x, y, !onlyOnce)) {
                return true;
            }
        }
        return false;
    }
}
