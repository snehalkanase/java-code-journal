package Paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaintGUI extends JFrame {
    private SpringLayout springLayout = new SpringLayout();
    public PaintGUI(){
        super("Paint");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1200, 700));
        pack();
        setLocationRelativeTo(null);

        addGuiComponents();
    }

    private void addGuiComponents(){
        SpringLayout springLayout = new SpringLayout();
        JPanel canvasPanel = new JPanel(springLayout);
        canvasPanel.setLayout(springLayout);

        Canvas canvas = new Canvas(1200, 650);
        canvasPanel.add(canvas);

        springLayout.putConstraint(SpringLayout.NORTH, canvas, 50, SpringLayout.NORTH, canvasPanel);

        //set color
        JButton colorButton = new JButton("Choose Color");
       colorButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              Color c = JColorChooser.showDialog(null, "Choose Color", Color.BLACK);
              colorButton.setBackground(c);
              canvas.setColor(c);
           };
       });
        canvasPanel.add(colorButton);
        springLayout.putConstraint(SpringLayout.NORTH, colorButton, 10, SpringLayout.NORTH, canvasPanel);
        springLayout.putConstraint(SpringLayout.WEST, colorButton, 25, SpringLayout.WEST, canvas);


        //RESET BUTTON

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.resetCanvas();
            }
        });

        canvasPanel.add(resetButton);
        springLayout.putConstraint(SpringLayout.NORTH, resetButton, 10, SpringLayout.NORTH, canvasPanel);
        springLayout.putConstraint(SpringLayout.WEST, resetButton, 150, SpringLayout.WEST, canvas);
        this.getContentPane().add(canvasPanel);
    }
}
