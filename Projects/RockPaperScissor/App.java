package RockPaperScissor;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
//        RockPaperScissorGUI gui = new RockPaperScissorGUI();
//        gui.setVisible(true);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RockPaperScissorGUI gui = new RockPaperScissorGUI();
                gui.setVisible(true);
            }
        });
    }
}
