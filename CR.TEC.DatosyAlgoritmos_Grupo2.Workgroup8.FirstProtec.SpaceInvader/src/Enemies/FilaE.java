package Enemies;

import Menu_and_game_things.Listas.ListaCircularDoble;

public abstract class FilaE{
    private ListaCircularDoble<Enemy> enemy;
    private int posX, posY, speed;
    private String lineClass;
    private boolean haveBoss;
    public FilaE(int posX, int posY, int speed, int size) {
        this.posX = posX;
        this.posY = posY;
        this.speed = speed;
        this.lineClass = "Linea D";
        this.haveBoss = false;
    }
    public ListaCircularDoble<Enemy> getEnemies(){return enemy;}
    public void setEnemies(ListaCircularDoble<Enemy> enemy) {
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
    public void delEnemyNum(int index){
        this.enemy.remove(index);
    }
}
