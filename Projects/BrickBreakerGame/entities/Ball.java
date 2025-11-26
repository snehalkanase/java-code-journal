package BrickBreakerGame.entities;

import java.awt.*;

public class Ball {
    private int x,y;
    private  int dx = -2;
    private int dy = -3;
    private final int size = 20;

    public Ball(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void update(){
        x += dx;
        y += dy;
    }
    public void reverseX(){
       dx = -dx;
    }
    public void reverseY(){
        dy = -dy;
    }
    public void draw(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, size, size);
    }
    public Rectangle getRect(){
        return new Rectangle(x,y,size,size);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
