package BrickBreakerGame.engine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {
    private GamePanel panel;

    public InputHandler(GamePanel panel){
        this.panel = panel;
    }

    public void keyPressed(KeyEvent e) {
        panel.getPaddle().keyPressed(e);
    }
    public void keyReleased(KeyEvent e) {
        panel.getPaddle().keyReleased(e);
    }
}
