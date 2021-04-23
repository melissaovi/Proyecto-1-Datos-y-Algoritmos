package Enemies;
import Main.Load;
import Menu_and_game_things.Listas.ListaCircular;

import java.awt.*;
import java.util.Random;

public class AlienD extends FilaD{
    private boolean movingRight = true;
    private int downDistance=50;
    public boolean onlyOnce = true;
    Random rand = new Random();
    int random_boss = rand.nextInt(4);
    public boolean hasboss;
    public  AlienD(int posX, int posY, int speed, int size) {
        super(posX, posY, speed, size);
        int counter = 0;
        this.setEnemies(new ListaCircular<>());
        while(counter < size) {
            Random rand = new Random();
            Enemy enemy = new Enemy(posX+counter*50, posY, 30, 50, speed,1+rand.nextInt(3), Load.imageLoad("/alien (2).png"));
            this.getEnemies().add(enemy);
            counter++;
        }
        this.getEnemies().get(random_boss).Boss();
        this.setHaveBoss(true);
        //hasboss=this.getEnemies().get(random_boss).getBoss();
    }
    public void BubbleSortLine() {
        boolean changed = false;
        int index = 0;
        while(index < this.getEnemies().size()-1) {
            if(this.getEnemies().get(index).getLife() < this.getEnemies().get(index+1).getLife()) {
                this.getEnemies().swap(index, index+1);
                changed = true;
            }
            ++index;
        }
        if(changed) {
            BubbleSortLine();
        }
    }
    /**
     * Dibujar hilera de aliens
     * @param g
     */
    public void draw(Graphics g) {
        for(int c = 0; c < this.getEnemies().size(); c++) {
            this.getEnemies().get(c).draw(g);
            if (this.getEnemies().get(c).hasBeenHit()){
                this.getEnemies().remove(c);
            }
        }
    }
    /**
     * Método para mover a los aliens
     */
    public void moveArmy(){
        if(movingRight){
            for (int i = this.getEnemies().size()-1; i >= 0; i--){
                if (!this.getEnemies().get(i).hasBeenHit()) {
                    if (this.getEnemies().get(i).getPosX() > 556) {
                        movingRight = false;
                        for (int y = 0; y < this.getEnemies().size(); y++) {
                            this.getEnemies().get(y).setPosY(this.getEnemies().get(y).getPosY() + downDistance);
                        }
                        return;
                    }
                } else if (this.getEnemies().get(i).getBoss() && this.getEnemies().get(i).hasBeenHit() && onlyOnce){
                    Random rand = new Random();
                    int random=rand.nextInt(this.getEnemies().size());
                    if(random>=0){
                        this.getEnemies().get(random).Boss();
                        checkShot( 0, 0 );
                    }else {
                        System.out.println(random);
                    }
/*
                    if( this.getEnemies().size() !=1){
                        this.delEnemyNum(i);
                        Random rand = new Random();
                        int random=rand.nextInt(this.getEnemies().size());
                        this.getEnemies().get(random).Boss();
                    }else if(this.getEnemies().size()==1){
                        this.getEnemies().get(0).Boss();
                    }
*/
                }
            }
            for (int i=0;i<this.getEnemies().size();i++){
                this.getEnemies().get(i).setPosX(this.getEnemies().get(i).getPosX()+this.getSpeed());
            }
        }else {
            for (int i = 0; i <this.getEnemies().size(); i++){
                if (!this.getEnemies().get(i).hasBeenHit()){
                    if(this.getEnemies().get(i).getPosX()<0){
                        movingRight=true;
                        for (int y=0;y<this.getEnemies().size();y++){
                            this.getEnemies().get(y).setPosY(this.getEnemies().get(y).getPosY()+downDistance);
                        }
                        return;
                    }
                }
                else if (this.getEnemies().get(i).getBoss() && this.getEnemies().get(i).hasBeenHit() && onlyOnce){
                    Random rand = new Random();
                    int random=rand.nextInt(this.getEnemies().size());
                    if(random>=0){
                        this.getEnemies().get(random).Boss();
                        checkShot( 0, 0 );
                    }else {
                        System.out.println(random);
                    }
                    //onlyOnce = false;
/*                    if( this.getEnemies().size() !=1){
                        this.delEnemyNum(i);
                        Random rand = new Random();
                        int random=rand.nextInt(this.getEnemies().size());
                        this.getEnemies().get(random).Boss();
                    }else if(this.getEnemies().size()==1){
                        this.getEnemies().get(0).Boss();
                    }*/
                }
            }
            for (int i = 0; i <this.getEnemies().size(); i++){
                this.getEnemies().get(i).setPosX(this.getEnemies().get(i).getPosX()-this.getSpeed());
            }
        }
    }
    /**
     * Verificar colision
     * @param x Posicion x
     * @param y Posicion y de la altura de la bala y el aliens
     * @return Boolean
     */
    public boolean checkShot(int x, int y )  {
        for (int i = 0;i<this.getEnemies().size();i++){
            if (this.getEnemies().get(i).hitAlien(x, y, !onlyOnce)) {
                return true;
            }
        }
        return false;
    }
}
