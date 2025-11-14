package TicTacToe;

import javax.swing.*;

public class App {
public static void main(String[] args){
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            TicTacToeGui gui = new TicTacToeGui();
            gui.setVisible(true);
        }
    });
}
}
