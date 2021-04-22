package Enemies;
import Menu_and_game_things.Listas.ListasEnlazadas;
public abstract class Aliens1 {
    private  ListasEnlazadas<Enemy> enemy;
    private int posX, posY, speed;
    private String lineClass;
    private boolean haveBoss;
    public Aliens1(int posX, int posY, int speed, int size, int lvl) {
        this.posX = posX;
        this.posY = posY;
        this.speed = speed;
        this.lineClass = "EnemyLine";
        this.haveBoss = false;
    }
    public  ListasEnlazadas<Enemy> getEnemies(){return enemy;}
    public void setEnemies(ListasEnlazadas<Enemy> enemy) {
        this.enemy = enemy;
    }
    public int getPosX() {
        return posX;
    }
    public void setPosX(int posX) {
        this.posX = posX;
    }
    public int getPosY() {
        return posY;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }
    public int getSpeed() {
        return speed;
    }
    public String getLineClass() {
        return lineClass;
    }
    public void setLineClass(String lineClass) {
        this.lineClass = lineClass;
    }
    public boolean isHaveBoss() {
        return haveBoss;
    }
    public void setHaveBoss(boolean haveBoss) {
        this.haveBoss = haveBoss;
    }







/*    public void arrangeLine() {
        for(int c = 0; c < this.getEnemies().getSize(); c++) {
            //this.getEnemies().gett(c).setPosX(0);
            this.getEnemies().gett(c).setPosX(c*50);
            //dist += this.getEnemies().gett(c).getWidth();
        }
        //dist = (840 - this.getEnemies().gett(this.getEnemies().getSize()-1).getPosX() - this.getEnemies().gett(this.getEnemies().getSize()-1).getWidth())/2;
        *//*for(int c = 0; c < this.getEnemies().getSize(); c++) {
            this.getEnemies().gett(c).setPosX(dist + this.getEnemies().gett(c).getPosX());
        }*//*
    }
    public void arr(){
        int dist = 0;
        for(int c = 0; c < this.getEnemies().getSize(); c++) {
            this.getEnemies().gett(c).setPosX(dist);
            dist += 35 + this.getEnemies().gett(c).getWidth();
        }
        dist = (840 - this.getEnemies().gett(this.getEnemies().getSize()-1).getPosX() - this.getEnemies().gett(this.getEnemies().getSize()-1).getWidth())/2;
        for(int c = 0; c < this.getEnemies().getSize(); c++) {
            this.getEnemies().gett(c).setPosX(dist + this.getEnemies().gett(c).getPosX());
        }
    }*/
}

