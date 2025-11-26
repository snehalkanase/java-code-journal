package SnakeGame;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame {
    public static final int BOARD_WIDTH = 800;
    public static final int BOARD_HEIGHT = 500;

    public GameBoard(){
        super("Snake Game");
        GamePanel gamePanel = new GamePanel();
        add(gamePanel);
        setPreferredSize(new Dimension(BOARD_WIDTH,BOARD_HEIGHT));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }
}
