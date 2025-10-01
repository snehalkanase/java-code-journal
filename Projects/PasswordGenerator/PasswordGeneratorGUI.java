package PasswordGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGeneratorGUI extends JFrame {
    PasswordGenerator passwordGenerator;

    public PasswordGeneratorGUI() {
        super("Password Generator");
        setSize(540,574);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        passwordGenerator = new PasswordGenerator();
        addGUIComponents();
    }
    private void addGUIComponents(){

        //title
        JLabel title = new JLabel("Password Generator");
        title.setFont(new Font("Dialog", Font.BOLD, 32));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(0, 10, 540, 39);
        add(title);

        // output
        JTextArea passOutput = new JTextArea();
        passOutput.setEditable(false);
        passOutput.setFont(new Font("Dialog", Font.BOLD, 32));

        //scrollable
        JScrollPane passOutputScroll = new JScrollPane(passOutput);
        passOutputScroll.setBounds(25, 97, 479, 70);

        passOutputScroll.setBorder(BorderFactory.createLineBorder(Color.black));
        add(passOutputScroll);

        //pass length
        JLabel passLength = new JLabel("Password Length: ");
        passLength.setFont(new Font("Dialog", Font.PLAIN, 32));
        passLength.setBounds(25,215,272,39);
        add(passLength);

        //pass length input
        JTextArea passLengthText = new JTextArea();
        passLengthText.setFont(new Font("Dialog", Font.PLAIN, 32));
        passLengthText.setBounds(282, 215, 272, 39);
        passLengthText.setBorder(BorderFactory.createLineBorder(Color.black));
        add(passLengthText);

        //toggle buttons
        //uppercase toggle button
        JToggleButton uppercaseToggleBtn = new JToggleButton("Uppercase");
        uppercaseToggleBtn.setBounds(25,302,225,56);
        uppercaseToggleBtn.setFont(new Font("Dialog", Font.PLAIN, 26));
        add(uppercaseToggleBtn);

        // Lowercase toggle button
        JToggleButton lowercaseToggleBtn = new JToggleButton("Lowercase");
        lowercaseToggleBtn.setBounds(282,302,225,56);
        lowercaseToggleBtn.setFont(new Font("Dialog", Font.PLAIN, 26));
        add(lowercaseToggleBtn);

        //Numbers Toggle Button
        JToggleButton numbersToggleBtn = new JToggleButton("Numbers");
        numbersToggleBtn.setBounds(25,373,225,56);
        numbersToggleBtn.setFont(new Font("Dialog", Font.PLAIN, 26));
        add(numbersToggleBtn);

        //Symnols toggle
        JToggleButton symbolsToggleBtn = new JToggleButton("Symbols");
        symbolsToggleBtn.setBounds(282,373,225,56);
        symbolsToggleBtn.setFont(new Font("Dialog", Font.PLAIN, 26));
        add(symbolsToggleBtn);

        //Generate Button
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialog", Font.BOLD, 26));
        generateButton.setBounds(155, 477, 222, 41);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(passLengthText.getText().length() <= 0 ) return;
                boolean anyToggleSelected = lowercaseToggleBtn.isSelected() ||  uppercaseToggleBtn.isSelected()
                        || numbersToggleBtn.isSelected() ||  symbolsToggleBtn.isSelected();

                int passLength = Integer.parseInt(passLengthText.getText());

                if(anyToggleSelected) {
                    String generatedPassword = passwordGenerator.generatePassword(passLength,
                            uppercaseToggleBtn.isSelected(),
                            lowercaseToggleBtn.isSelected(),
                            numbersToggleBtn.isSelected(),
                            symbolsToggleBtn.isSelected());

                    passOutput.setText(generatedPassword);
                }
            }
        });
        add(generateButton);

    }
}
