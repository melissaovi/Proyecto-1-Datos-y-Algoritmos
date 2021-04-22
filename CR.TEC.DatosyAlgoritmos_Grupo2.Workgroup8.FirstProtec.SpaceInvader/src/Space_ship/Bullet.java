package Space_ship;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet implements Move{
    private final int posX;
    private int posY;
    private final int width;
    private final int height;
    private int speed;
    private boolean collide;
    private Rectangle rect;
    private BufferedImage sprite;

    public Bullet(int posX, int posY, int width, int height, int speed, BufferedImage spriteName) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.collide = false;
        this.sprite=spriteName;
        this.rect = new Rectangle(posX, posY, width, height);
    }

    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int getSpeed() {
        return speed;
    }
    public BufferedImage getSprite(){
        return sprite;
    }

    public Rectangle getRect() {
        return rect;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }


    public void setRect() {
        this.rect = new Rectangle(this.getPosX(), this.getPosY(), this.getWidth(), this.getHeight());
    }

    public boolean isColliding(Bullet other) {
        collide = other.getRect().intersects(this.getRect());
        return collide;
    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(this.getSprite(), this.getPosX(), this.getPosY(), this.getWidth(), this.getHeight(), null);
    }
    @Override
    public void move(double delta) {
        this.setPosY(this.getPosY()+this.getSpeed());
        this.setRect();
    }
}
