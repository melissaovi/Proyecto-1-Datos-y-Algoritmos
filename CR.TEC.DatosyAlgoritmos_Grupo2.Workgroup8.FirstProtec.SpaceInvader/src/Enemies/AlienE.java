package Enemies;

import Main.Load;
import Menu_and_game_things.Listas.ListaCircularDoble;

import java.awt.*;
import java.util.Random;

public class AlienE extends FilaE{
    private double angle;
    private boolean movingRight = true; //Si el alien se esta moviendo a la derecha
    private int downDistance=50;// Distancia de bajada
    public boolean onlyOnce = true;
    public boolean hasboss;
    public AlienE(int posX, int posY, int speed, int size) {
        super(posX, posY, speed, size);
        int cont=0;
        this.setEnemies(new ListaCircularDoble<>());
        while(cont<size) {
            Random rand = new Random();
            Enemy enemy = new Enemy(posX+cont*50, posY, 30, 50, speed,1+rand.nextInt(3), Load.imageLoad("/alien (2).png"));
            this.getEnemies().insertNode(enemy);
            cont++;
        }
        this.getEnemies().get(size/2).Boss();
        this.setHaveBoss(true);
        hasboss =this.getEnemies().get(size/2).getBoss();
    }
    public void draw(Graphics g) {
        for(int c = 0; c < this.getEnemies().getSize(); c++) {
            this.getEnemies().get(c).draw(g);
        }
    }
    /**
     * Mover aliens básicos
     */
    public void moveArmy(){
        if(movingRight){
            for (int i = this.getEnemies().getSize()-1; i >= 0; i--){
                if (!this.getEnemies().get(i).hasBeenHit()){
                    if (this.getEnemies().get(i).getPosX()>456){
                        movingRight=false;
                        for (int y=0;y<this.getEnemies().getSize();y++){
                            this.getEnemies().get(y).setPosY(this.getEnemies().get(y).getPosY()+downDistance);
                        }
                        return;
                    }
                }
            }this.angle+=0.01;
            this.setPosY(this.getPosY()+1);
            for (int i=0;i<this.getEnemies().getSize();i++){
                int dist = this.getEnemies().get(i).getPosX() - this.getPosX();
                int newPosX = (int) (dist * Math.cos(this.angle % 90));
                int newPosY = (int) (dist * Math.sin(this.angle % 90));
                this.getEnemies().get(1).setPosX(this.getPosX()+newPosX);
                this.getEnemies().get(1).setPosY(this.getPosY()+newPosY);
                this.getEnemies().get(0).setPosX((this.getPosX()+newPosX)*2);
                this.getEnemies().get(0).setPosY((this.getPosY()+newPosY)*1);
            }
        }else {
            for (int i = 0; i <this.getEnemies().getSize(); i++){
                if (!this.getEnemies().get(i).hasBeenHit()){
                    if(this.getEnemies().get(i).getPosX()<0){
                        movingRight=true;
                        for (int y=0;y<this.getEnemies().getSize();y++){
                            this.getEnemies().get(y).setPosY(this.getEnemies().get(y).getPosY()+downDistance);
                        }
                        return;
                    }
                }
            }
            for (int i = 0; i <this.getEnemies().getSize(); i++){
                int dist = this.getEnemies().get(i).getPosX() - this.getPosX();
                int newPosX = (int) (dist * Math.cos(this.angle % 90));
                int newPosY = (int) (dist * Math.sin(this.angle % 90));
                this.getEnemies().get(i).setPosX(this.getPosX()-newPosX);
                this.getEnemies().get(i).setPosY(this.getPosY()-newPosY);

                //this.getEnemies().get(i).setPosX(this.getEnemies().get(i).getPosX()-this.getSpeed());
            }
        }
    }

    /**
     * Verificar colision
     * @param x Posicion x
     * @param y Posicion y de la altura de la bala y el aliens
     * @return Boolean
     */
    public boolean checkShot(int x, int y) {
        for (int i = 0;i<this.getEnemies().getSize();i++){
            if (this.getEnemies().get(i).hitAlien(x, y, false)) {
                return true;
            }
        }
        return false;
    }








}
