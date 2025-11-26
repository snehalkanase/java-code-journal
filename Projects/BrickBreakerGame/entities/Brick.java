package BrickBreakerGame.entities;

import BrickBreakerGame.utils.Constants;

import java.awt.*;

public class Brick {
    private int x, y;
    private boolean visible = false;

    public Brick(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void  draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, Constants.BRICK_WIDTH, Constants.BRICK_HEIGHT);
    }
    public Rectangle getRect(){
        return  new Rectangle(x, y, Constants.BRICK_WIDTH, Constants.BRICK_HEIGHT);
    }
    public boolean isVisible() {
        return visible;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
