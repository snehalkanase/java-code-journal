package BrickBreakerGame;

import BrickBreakerGame.engine.GamePanel;
import BrickBreakerGame.utils.Constants;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Brick Breaker Game");
        GamePanel gamePanel = new GamePanel();

        frame.setSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(gamePanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        gamePanel.startGame();
    }
}
