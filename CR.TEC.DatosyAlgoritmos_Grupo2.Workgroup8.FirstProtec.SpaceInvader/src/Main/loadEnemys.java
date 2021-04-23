package Main;
import Enemies.*;
import Space_ship.Ship;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class loadEnemys {
    AliensBasic aliBasic;
    AlienA aliA;
    AliensB aliB;
    AlienC aliC;
    AlienD aliD;
    AlienE aliE;
    public Ship ship;
    Random random = new Random();
    private int next = -1;
    private int currentAli = -1;
    private int level = 1;
    private BufferStrategy bs;
    private Graphics g;
    Window w;
    Canvas cv;

    public void orderCreation(Window w, Canvas cv){
        this.w = w;
        this.cv = cv;
        //cv.addMouseListener(ship);
        //cv.addMouseMotionListener(ship);
        //addmouselis();
        ship = new Ship(w);
        aliBasic = new AliensBasic(0,0,10,5);
        aliA = new AlienA(0,0,10,5);
        aliB = new AliensB(0,0,10,5);
        addmouselis();
    }

    public void addmouselis(){
        cv.addMouseListener(ship);
        cv.addMouseMotionListener(ship);
    }

    public void newAliRand(){
        next = random.nextInt(2);
        orderCreation(w,cv);
    }

    public void nextLevel(){
        level += 1;
    }

    public void update() {
        if (level == 1) {
            aliB.moveArmy();
        } else if (level == 2) {
            aliA.moveArmy();
        } else if (level == 3) {
            aliBasic.moveArmy();
        } else if (level == 4) {
            aliE.moveArmy();
        } else if (level == 5) {
            //aliD.moveArmy();
        } else if (level == 6) {
            aliC.moveArmy();
        }
        draw();
    }

    public void draw(){
        bs = cv.getBufferStrategy();
        if (bs == null){
            cv.createBufferStrategy(3); // 3 is a number of buffers that the canvas use
            return;
        }
        g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0,0,w.WIDTH, w.HEIGHT);

        ship.drawShip(g);

        if (level == 1){
            aliB.draw(g);
            aliA.draw(g);
        } else if (level == 2) {
            aliA.draw(g);
            aliBasic.draw(g);
        } else if (level == 3) {
            aliBasic.draw(g);
            aliE.draw(g);
        } else if (level == 4) {
            aliE.draw(g);
            aliD.draw(g);
        } else if (level == 5) {
            aliD.draw(g);
            aliC.draw(g);
        } else if (level == 6) {
            aliC.draw(g);
        } else {
            //WinGame()
        }

        g.dispose();
        bs.show();
    }

    public AliensBasic getAlienArmy() {
        return aliBasic;
    }
    public AlienA getAli(){
        return aliA;
    }
    public AliensB getAliensB(){return aliB;}
    public AlienC getAlienC(){return aliC;}
}
