package Enemies;
import Main.Load;
import Menu_and_game_things.Listas.ListaCircular;
import java.awt.*;
import java.util.Random;

import static Space_ship.Shot.shotState;
public class AlienC extends FilaC{
    private boolean movingRight = true;
    private int downDistance=50;
    public boolean onlyOnce = true;
    Random rand = new Random();
    int random_boss = rand.nextInt(4);
    public boolean hasboss;

    /**
     * Constructor de aliens
     * @param posX
     * @param posY
     * @param speed
     * @param size
     */
    public AlienC(int posX, int posY, int speed, int size) {
        super(posX, posY, speed, size);
        int counter = 0;
        this.setEnemies(new ListaCircular<>());
        while(counter < size) {
            Enemy enemy = new Enemy(posX+counter*50, posY, 30, 50, speed,0, Load.imageLoad("/alien (2).png"));
            this.getEnemies().add(enemy);
            counter++;
        }
        this.getEnemies().get(random_boss).Boss();
        this.setHaveBoss(true);
        hasboss=this.getEnemies().get(random_boss).getBoss();
    }

    /**
     * Dibujar la hilera de aliens
     * @param g
     */
    public void draw(Graphics g) {
        for(int c = 0; c < this.getEnemies().size(); c++) {
            this.getEnemies().get(c).draw(g);
        }
    }

    /**
     * Mover a los aliens
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
                } else if (this.getEnemies().get(random_boss).hasBeenHit() && onlyOnce){
                    if( this.getEnemies().size() !=1){
                        this.delEnemyNum(i);
                        Random rand = new Random();
                        int random=rand.nextInt(this.getEnemies().size());
                        this.getEnemies().get(random).Boss();
                    }else if(this.getEnemies().size()==1){
                        this.getEnemies().get(0).Boss();
                    }

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
                else if (this.getEnemies().get(random_boss).hasBeenHit() && onlyOnce){
                    if( this.getEnemies().size() !=1){
                        this.delEnemyNum(i);
                        Random rand = new Random();
                        int random=rand.nextInt(this.getEnemies().size());
                        this.getEnemies().get(random).Boss();
                    }else if(this.getEnemies().size()==1){
                        this.getEnemies().get(0).Boss();
                    }
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
                if(this.getEnemies().get(i).getBoss()!=true){
                    System.out.println(this.getEnemies().size());
                    return false;
                }
                shotState=false;
                System.out.println(this.getEnemies().size());
                return true;
            }
        }
        return false;
    }
}
