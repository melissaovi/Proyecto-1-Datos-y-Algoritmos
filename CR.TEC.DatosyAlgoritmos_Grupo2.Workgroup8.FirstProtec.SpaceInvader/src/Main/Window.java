package Main;
import Enemies.*;
import Menu_and_game_things.Score_Table;
import Space_ship.Ship;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Window extends JFrame implements Runnable {
    public static final int WIDTH = 700, HEIGHT = 700;
    private Canvas canvas;
    private Thread thread;
    private boolean running = false;

    Ship ship = null;
    AliensBasic ene;
    AlienA ali;
    AliensB aliensB;
    AlienC alienC;
    AlienD alienD;
    AlienE alienE;
    private BufferStrategy bs;
    private Graphics g;
    private Graphics b;
    // Variables para controlar los fps del juego
    private final int FPS = 10;
    private double TARGETTIME = 1000000000/FPS; // Time measured in nanoseconds
    private double delta = 0; // Almacena el tiempo que ha transcurrido
    private int AVERAGEFPS = FPS;
    public int shotHeight;

    /**
     * Clase ventana
     * <p>
     * Esta es la clase principal.
     */
    public Window(){
        addWindowListener (new java.awt.event.WindowAdapter() {
            @Override public void windowClosing(java.awt.event.WindowEvent windowEvent) { System.exit(0);}});
        setTitle("Space invaders"); // Set a title
        setSize(WIDTH, HEIGHT); // set a size of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Necessary to be able to close the window
        setResizable(false); // To prevent the window from being resized
        setLocationRelativeTo(null); // So that the window is placed in the center of the screen.
        setVisible(true); // To make the window visible
        canvas = new Canvas(); // A canvas is created
        // The dimensions are established
        canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setFocusable(true); // receive keyboard input
        // To add the option to move the ship with the mouse
        // NOTE: It must not be null, the player's object must go here
        ship=new Ship(this);
        canvas.addMouseListener(ship);
        canvas.addMouseMotionListener(ship);
        add(canvas); // The canvas is added to the window
        ene=new AliensBasic(0,0,10,5);
        ali=new AlienA(0,-200,10,5);
        aliensB=new AliensB(0,-400,10,5);
        alienC=new AlienC(0,-600,10,5);
        alienD=new AlienD(0,1000,10,5);
        alienE=new AlienE(0,1000,10,5);
    }
    /**
     * Inicia el método para crear la pantalla pricipal
     */
    public static void main(String[] args) {
        new Window().start(); // call the window
    }


    /**
     * Este método actualiza la pantalla inicial para notar el movimiento
     */
    public void update(){
        ene.moveArmy();
        ali.moveArmy();
        aliensB.moveArmy();
        alienC.moveArmy();
        //alienD.moveArmy();
        //alienE.moveArmy();
        draw();
    }
    /**
     * Este método llama a dibujar los aliens y la nave
     */
    public void draw(){
        bs = canvas.getBufferStrategy();
        if (bs == null){
            canvas.createBufferStrategy(3); // 3 is a number of buffers that the canvas use
            return;
        }
        g = bs.getDrawGraphics();
        // ===== The drawing starts here

        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH, HEIGHT);


        //Draws the players ship
        ship.drawShip(g);
        Score_Table.draw(g);
        ene.draw(g); //Alien Basic
        ali.draw(g); //Alien A
        alienC.draw(g);
        aliensB.draw(g); //Alien B
        //alienD.draw(g);
        //alienE.draw(g);
        g.dispose();
        bs.show();
    }

    private void init(){
        Assets.init(); // con esto cargamos todos los recursos que necesitaramosdesde la
                        // carpeta assets que los carga desde Load
    }
    /**
     * Este método sirve para limitar los frames
     */
    @Override
    public void run() { // Game cycle

        long now = 0;
        long lastTime = System.nanoTime(); //
        int frames = 0;
        long time = 0;

        init();

        while (running){
            now = System.nanoTime();
            delta += (now - lastTime)/TARGETTIME; // esta division nos deberia dar 1
            time += (now - lastTime);
            lastTime = now;

            if (delta >= 1){
                update();
                draw();
                delta--; // con esto tenemos ya el ciclo restringido a 60fps
                frames++;
            }
            if (time >= 1000000000){
                AVERAGEFPS = frames;
                frames = 0;
                time = 0;

                // En caso de querer o necesitar ver los fps a los que corre podemos ejecutar este print
                //System.out.println(AVERAGEFPS);

            }
        }
        stop();
    }
    
    public AliensBasic getAlienArmy() {
        return ene;

    }
    public AlienA getAli(){
        return ali;
    }
    public AliensB getAliensB(){return aliensB;}
    public AlienC getAlienC(){return alienC;}

    /**
     * Metodo para inicializar el hilo.
     */
    private void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    /**
     * Metodo para detener el hilo.
     */
    private void stop(){
        try{
            thread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
