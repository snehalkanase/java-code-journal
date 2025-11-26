package BrickBreakerGame.entities;

import BrickBreakerGame.utils.Constants;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle {
    private int x;
    private final int y = Constants.WINDOW_HEIGHT - 80;
    private final int width = 100;
    private final int height = 10;
    private int dx = 0;

    public Paddle(int x){
        this.x = x;
    }
    public void update(){
        x += dx;
        if(x < 0) x = 0;
        if(x > Constants.WINDOW_WIDTH - width) x = Constants.WINDOW_WIDTH - width;
    }
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }
    public Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_LEFT) dx = -5;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) dx = 5;
    }
    public void keyReleased(KeyEvent e){
        dx = 0;
    }
}
