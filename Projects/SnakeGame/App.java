package SnakeGame;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GameBoard().setVisible(true);
        });
    }
}
