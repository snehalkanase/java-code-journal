package RollingTwoDice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RollingDiceGui extends JFrame {

    public RollingDiceGui() {
        super("Rolling Double Dice");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(700, 700));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);

        addGuiComponents();
    }

    public void addGuiComponents() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        //Banner
        JLabel bannerImg = ImgService.loadImg("resources/banner.png");
        bannerImg.setBounds(45,25,600,100);
        jPanel.add(bannerImg);

        //dice
        JLabel diceOneImg = ImgService.loadImg("resources/dice1.png");
        diceOneImg.setBounds(100,200,200,200);
        jPanel.add(diceOneImg);

        JLabel diceTwoImg = ImgService.loadImg("resources/dice2.png");
        diceTwoImg.setBounds(390,200,200,200);
        jPanel.add(diceTwoImg);

        //roll button
        Random rand = new Random();
        JButton rollButton = new JButton("Roll");
        rollButton.setBounds(250,550,200,50);
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        jPanel.add(rollButton);

        this.getContentPane().add(jPanel);
    }
}
