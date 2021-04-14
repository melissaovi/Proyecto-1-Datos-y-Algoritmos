package Enemies;

import Menu_and_game_things.Listas.DoubleLinkedList;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import static Main.Load.imageLoad;

public class AliensB extends FilaB{
    private boolean switchBoss;
    private boolean movingRight = true;
    private int downDistance=50;
    public boolean onlyOnce = true;
    private int bossIndex;
    public static int cont=0;
    public boolean hasboss;
    public AliensB(int posX, int posY, int speed, int size, int lvl) {
        super(posX, posY, speed, size, lvl);
        int counter = 0;
        this.setEnemies(new DoubleLinkedList<>());
        while (counter < size){
            BufferedImage sprite = imageLoad("/alien (2).png");
            Enemy enemy = new Enemy(posX+counter*50, posY, 30, 50, lvl,0, sprite);
            //System.out.println(enemy);
            this.getEnemies().add(enemy);
            counter++;
        }
        Random rand = new Random();
        int random_boss2 = rand.nextInt(4);
        this.getEnemies().get(random_boss2).Boss();
        this.setHaveBoss(true);
        this.bossIndex=random_boss2;
        hasboss =this.getEnemies().get(random_boss2).getBoss();
    }
    public void draw(Graphics g) {
        for(int c = 0; c < this.getEnemies().size(); c++) {
            this.getEnemies().get(c).draw(g);

        }
    }
    public void moveArmy(){
        if(movingRight){
            for (int i = this.getEnemies().size()-1; i >= 0; i--){
                if (!this.getEnemies().get(i).hasBeenHit()) {
                    if (this.getEnemies().get(i).getPosX() > 556) {
                        movingRight = false;
                        for (int y = 0; y < this.getEnemies().size(); y++) {
                            Random rand = new Random();
                            int random=rand.nextInt(this.getEnemies().size());
                            //System.out.println(random);
                            //System.out.println(this.getEnemies().size());
                            this.getEnemies().get(bossIndex).ChangeBoss();
                            this.getEnemies().get(random).Boss();
                            bossIndex=random;
                            this.getEnemies().get(y).setPosY(this.getEnemies().get(y).getPosY() + downDistance);
                        }System.out.println(bossIndex);
                        return;
                    }

                } else if (this.getEnemies().get(bossIndex).hasBeenHit() && onlyOnce){
                    System.out.println("sí");
                    onlyOnce = false;
                    checkShot( 0, 0 );
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

                else if (this.getEnemies().get(bossIndex).hasBeenHit() && onlyOnce){
                    System.out.println("sí");
                    onlyOnce = false;
                    checkShot( 0, 0 );
                    //this.getEnemies().gett(i).hitAlien(0, 0, !onlyOnce);
                }
            }
            for (int i = 0; i <this.getEnemies().size(); i++){
                this.getEnemies().get(i).setPosX(this.getEnemies().get(i).getPosX()-this.getSpeed());
            }
        }
    }
    public boolean checkShot(int x, int y )  {
        for (int i = 0;i<this.getEnemies().size();i++){
            if (this.getEnemies().get(i).hitAlien(x, y, !onlyOnce)) {
                return true;
            }
        }
        return false;
    }
}
