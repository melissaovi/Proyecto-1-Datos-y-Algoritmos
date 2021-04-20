package Enemies;
import Menu_and_game_things.Listas.ListaCircular;
/**
 * Clase abstracta de los aliens, el molde el cual contiene los metodos para
 * crear las hileras de enemigos de tipo C
 */
public abstract class FilaC{
    private ListaCircular<Enemy> enemy;
    private int posX, posY, speed;
    private String lineClass;
    private boolean haveBoss;
    /**
     * Constructor de los aliens
     * @param posX Posicion x de los aliens
     * @param posY Posicion y de los aliens
     * @param speed Velocidad de los aliens
     * @param size Tamaño de los aliens
     */
    public FilaC(int posX, int posY, int speed, int size) {
        this.posX = posX;
        this.posY = posY;
        this.speed = speed;
        this.lineClass = "EnemyLine";
        this.haveBoss = false;
    }
    /**
     * @return Enemy
     */
    public ListaCircular<Enemy> getEnemies(){return enemy;}

    /**
     * @param enemy
     */
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

    /**
     * @return speed
     */
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

    /**
     * @param haveBoss
     */
    public void setHaveBoss(boolean haveBoss) {
        this.haveBoss = haveBoss;
    }

    /**
     * Método para remover nodo
     * @param index
     */
    public void delEnemyNum(int index){
        this.enemy.remove(index);
    }
}
