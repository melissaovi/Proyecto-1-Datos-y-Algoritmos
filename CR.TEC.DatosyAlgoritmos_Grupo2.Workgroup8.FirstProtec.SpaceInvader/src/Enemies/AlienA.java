package Enemies;
import Main.Load;
import Menu_and_game_things.Listas.ListasEnlazadas;
import Menu_and_game_things.Score_Table;

import java.awt.*;
import java.util.Random;

public class AlienA extends Aliens1{
    private boolean movingRight = true; //Si el alien se esta moviendo a la derecha
    private int downDistance=50;// Distancia de bajada
    public boolean onlyOnce = true;
    Random rand = new Random();
    //public boolean hasboss;
    int random_boss = rand.nextInt(4);// Crear jefe random
    public AlienA(int posX, int posY, int speed, int size) {
        super(posX, posY, speed, size);
        int counter = 0;
        this.setEnemies(new ListasEnlazadas<>());
        while (counter < size){
            Enemy enemy = new Enemy(posX+counter*50, posY, 30, 50,speed,0, Load.imageLoad("/alien (2).png"));
            this.getEnemies().insertHead(enemy);
            counter++;
        }
        this.getEnemies().gett(random_boss).Boss();
        this.setHaveBoss(true);
    }
    /**
     * Dibujar hilera de aliens
     * @param g
     */
    public void draw(Graphics g) {
        for(int c = 0; c < this.getEnemies().getSize(); c++) {
            this.getEnemies().gett(c).draw(g);

            if (this.getEnemies().gett(c).hasBeenHit()){
                this.getEnemies().delete(c);

            }

        }
    }
    /**
     * Método para mover a los aliens
     */
    public void moveArmy(){
        if(movingRight){
            for (int i = this.getEnemies().getSize()-1; i >= 0; i--){
                if (!this.getEnemies().gett(i).hasBeenHit()) {
                    if(this.getEnemies().gett(i).getPosY() > 500){
                        System.out.println("gameOver");
                    }
                    if (this.getEnemies().gett(i).getPosX() > 456) {
                        movingRight = false;
                        for (int y = 0; y < this.getEnemies().getSize(); y++) {
                            this.getEnemies().gett(y).setPosY(this.getEnemies().gett(y).getPosY() + downDistance);
                        }
                        return;
                    }
                    /**
                     * Verifica si el jefe a muerto para eliminar la linea (solo se ejecuta una vez de
                     * ser cierto)
                     */
                } else if (this.getEnemies().gett(i).getBoss() && this.getEnemies().gett(i).hasBeenHit() && onlyOnce){

                    Score_Table.setPoint();
                    onlyOnce = false;
                    checkShot( 0, 0 );
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

                else if (this.getEnemies().gett(i).getBoss() && this.getEnemies().gett(i).hasBeenHit() && onlyOnce){
                    System.out.println("sí");
                    Score_Table.setPoint();
                    onlyOnce = false;
                    checkShot( 0, 0 );
        }
            }
            for (int i = 0; i <this.getEnemies().getSize(); i++){
                this.getEnemies().gett(i).setPosX(this.getEnemies().gett(i).getPosX()-this.getSpeed());
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
        for (int i = 0;i<this.getEnemies().getSize();i++){
            if (this.getEnemies().gett(i).hitAlien(x, y, !onlyOnce)) {
                return true;
            }
        }
        return false;
    }
}
