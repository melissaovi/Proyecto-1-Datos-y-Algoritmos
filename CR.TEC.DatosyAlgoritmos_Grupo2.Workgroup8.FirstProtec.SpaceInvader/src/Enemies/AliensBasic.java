package Enemies;

import Main.Load;
import Menu_and_game_things.Listas.ListasEnlazadas;

import java.awt.*;

public class AliensBasic extends Aliens1{
    private boolean movingRight = true;
    private int downDistance=50;
    public AliensBasic(int posX, int posY, int speed, int size, int lvl) {
        super(posX, posY, speed, size, lvl);
        int counter = 0;
        this.setEnemies(new ListasEnlazadas<>());
        while (counter < size){
            Enemy enemy = new Enemy(posX+counter*50, posY, 30, 50, lvl,0, Load.imageLoad("/alien (2).png"));
            System.out.println(enemy);
            this.getEnemies().insertHead(enemy);
            counter++;
        }
    }
    public void draw(Graphics g) {
        for(int c = 0; c < this.getEnemies().getSize(); c++) {
            this.getEnemies().gett(c).draw(g);
            if (this.getEnemies().gett(c).hasBeenHit()){
                this.getEnemies().delete(c);}
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
            if (this.getEnemies().gett(i).hitAlien(x, y, false)) {
                return true;
            }
        }

        return false;
    }

/*    public void update(int sp) {
        int wid=560;
        for (int c = 0; c < this.getEnemies().getSize(); c++) {
            if(this.getEnemies().gett(c).getPosX()<wid){
                this.getEnemies().gett(c).setPosX(this.getEnemies().gett(c).getPosX()+this.getSpeed());
                //this.getEnemies().gett(c).updated(delta);
            }else{
                wid=0;
                movedown();
                break;
            }
        }
    }

    public void movedown(){
        int bajar=100;
        for (int c = 0; c < this.getEnemies().getSize(); c++) {
            if(this.getEnemies().gett(c).getPosY()<bajar){
                this.getEnemies().gett(c).setPosY(this.getEnemies().gett(c).getPosY()+this.getSpeed());
                //this.getEnemies().gett(c).updated(delta);
            }else{
                update(-5);
                break;
            }

        }
    }
    public void moveleft(){
        for (int c = 4; c>=0;c--) {
            if(this.getEnemies().gett(c).getPosX()>0){
                this.getEnemies().gett(c).setPosX(this.getEnemies().gett(c).getPosX()-this.getSpeed());
                //this.getEnemies().gett(c).updated(delta);
            }else{
                break;
            }
        }
    }
 for (int a = 4; a>=0; --a){
        if (this.getEnemies().gett(a).getPosX()>bajar){
            this.arr();
            //this.getEnemies().gett(a).setPosX(this.getEnemies().gett(a).getPosX()-400);
        }else{break;}
    }*/






}
