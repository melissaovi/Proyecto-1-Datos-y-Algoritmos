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
        //this.getEnemies().get(random_boss).Boss();
        //this.setHaveBoss(true);
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
    public void Or(){
        BubbleSortLine();
        System.out.println(this.getEnemies().get(0).getLife());
        System.out.println(this.getEnemies().get(1).getLife());
        System.out.println(this.getEnemies().get(2).getLife());
        System.out.println(this.getEnemies().get(3).getLife());
        System.out.println(this.getEnemies().get(4).getLife());
    }
    public void draw(Graphics g) {
        for(int c = 0; c < this.getEnemies().size(); c++) {
            this.getEnemies().get(c).draw(g);
        }
    }
}
