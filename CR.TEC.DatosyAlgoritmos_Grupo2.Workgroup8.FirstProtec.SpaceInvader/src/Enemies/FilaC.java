package Enemies;
import Menu_and_game_things.Listas.ListaCircular;
public abstract class FilaC{
    private ListaCircular<Enemy> enemy;
    private int posX, posY, speed;
    private String lineClass;
    private boolean haveBoss;
    public FilaC(int posX, int posY, int speed, int size, int lvl) {
        this.posX = posX;
        this.posY = posY;
        this.speed = speed;
        this.lineClass = "EnemyLine";
        this.haveBoss = false;
    }
    public ListaCircular<Enemy> getEnemies(){return enemy;}
    public void setEnemies(ListaCircular<Enemy> enemy) {
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
