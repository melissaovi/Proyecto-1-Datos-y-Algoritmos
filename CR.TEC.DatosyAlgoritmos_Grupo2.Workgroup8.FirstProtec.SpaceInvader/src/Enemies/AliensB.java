package Enemies;
import Menu_and_game_things.Listas.DoubleLinkedList;
import Menu_and_game_things.Score_Table;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import static Main.Load.imageLoad;
//Fix
public class AliensB extends FilaB{
    private boolean switchBoss;
    private boolean movingRight = true;
    private int downDistance=50;
    public boolean onlyOnce = true;
    private int bossIndex;
    public static int cont=0;
    //public boolean hasboss;

    /**
     * @param posX
     * @param posY
     * @param speed
     * @param size
     */
    public AliensB(int posX, int posY, int speed, int size) {
        super(posX, posY, speed, size);
        int counter = 0;
        this.setEnemies(new DoubleLinkedList<>());
        while (counter < size){
            BufferedImage sprite = imageLoad("/alien (2).png");
            Enemy enemy = new Enemy(posX+counter*50, posY, 30, 50,speed,0,sprite);
            //System.out.println(enemy);
            this.getEnemies().add(enemy);
            counter++;
        }
        Random rand = new Random();
        int random_boss2 = rand.nextInt(4);
        this.getEnemies().get(random_boss2).Boss();
        this.setHaveBoss(true);
        this.bossIndex=random_boss2;
        //hasboss =this.getEnemies().get(random_boss2).getBoss();
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
                    if (this.getEnemies().get(i).getPosX() > 456) {
                        movingRight = false;
                        for (int y = 0; y < this.getEnemies().size(); y++) {
                            Random rand = new Random();
                            int random=rand.nextInt(this.getEnemies().size());
                            //this.getEnemies().swap(bossIndex,random); // NO FUNCIONA EL SWAP SE VE RARO
                            this.getEnemies().get(bossIndex).ChangeBoss();
                            this.getEnemies().get(random).Boss();
                            this.bossIndex=random;
                            this.getEnemies().get(y).setPosY(this.getEnemies().get(y).getPosY() + downDistance);
                        }
                        return;
                    }

                } else if (this.getEnemies().get(i).getBoss() && this.getEnemies().get(i).hasBeenHit() && onlyOnce){
                    Score_Table.setPoint();
                    System.out.println("sí");
                    onlyOnce = false;
                    checkShot( 0, 0 );

                }
            }
            for (int i=0;i<this.getEnemies().size();i++){
                //Este cambio rápido parece no tan mala idea
                Random rand = new Random();
                int random=rand.nextInt(this.getEnemies().size());
                //this.getEnemies().swap(bossIndex,random); // NO FUNCIONA EL SWAP SE VE RARO
                if (this.getEnemies().get(bossIndex) != null){ this.getEnemies().get(bossIndex).ChangeBoss();}
                this.getEnemies().get(random).Boss();
                this.bossIndex=random;
                this.getEnemies().get(i).setPosX(this.getEnemies().get(i).getPosX()+this.getSpeed());
            }
        }else {
            for (int i = 0; i <this.getEnemies().size(); i++){
                if (!this.getEnemies().get(i).hasBeenHit()){
                    if(this.getEnemies().get(i).getPosX()<0){
                        movingRight=true;
                        for (int y=0;y<this.getEnemies().size();y++){
                            Random rand = new Random();
                            int random=rand.nextInt(this.getEnemies().size());
                            //this.getEnemies().swap(bossIndex,random); // NO FUNCIONA EL SWAP SE VE RARO
                            if (this.getEnemies().get(bossIndex) != null){ this.getEnemies().get(bossIndex).ChangeBoss();}
                            this.getEnemies().get(random).Boss();
                            this.bossIndex=random;
                            this.getEnemies().get(y).setPosY(this.getEnemies().get(y).getPosY()+downDistance);
                        }
                        return;
                    }
                }

                else if (this.getEnemies().get(i).getBoss() && this.getEnemies().get(i).hasBeenHit() && onlyOnce){
                    System.out.println("sí");
                    onlyOnce = false;
                    checkShot( 0, 0 );
                    Score_Table.setPoint();
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
