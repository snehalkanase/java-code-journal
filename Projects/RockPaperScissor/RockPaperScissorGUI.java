package RockPaperScissor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissorGUI extends JFrame implements ActionListener{
    JButton rockButton, paperButton, scissorButton;
    JLabel computerChoice;

    RockPaperScissor rockPaperScissor;
    JLabel computerScoreLabel, playerScoreLabel;

    public RockPaperScissorGUI(){
        //super refers to the extended class -- not the implemented interface
        //interface do not have constructor, you can only override its methods
        super("Rock Paper Scissor");
        setSize(450,574);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        rockPaperScissor = new RockPaperScissor();
        addGuiComponents();
    }

    public void addGuiComponents(){
//        create computer label
        computerScoreLabel = new JLabel("Computor Score: 0");
        computerScoreLabel.setBounds(0,43,450,30);
        computerScoreLabel.setFont(new Font("Dialog",Font.BOLD,25));
        computerScoreLabel.setHorizontalAlignment(JLabel.CENTER);
        add(computerScoreLabel);

        computerChoice = new JLabel("?");
        computerChoice.setBounds(175,118,98,81);
        computerChoice.setFont(new Font("Dialog",Font.PLAIN,18));
        computerChoice.setHorizontalAlignment(JLabel.CENTER);
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.black));
        add(computerChoice);

        // create player label
        playerScoreLabel = new JLabel("Player Score: 0");
        playerScoreLabel.setBounds(0,317,450,30);
        playerScoreLabel.setFont((new Font("Dialog",Font.BOLD,25)));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);

        // player buttons
        // Rock button
        rockButton = new JButton("Rock");
        rockButton.setBounds(40, 387,105,81);
        rockButton.setFont(new Font("Dialog",Font.PLAIN,18));
        rockButton.addActionListener(this);
        add(rockButton);

        //Paper button
        paperButton = new JButton("Paper");
        paperButton.setBounds(165, 387, 105,81);
        paperButton.setFont(new Font("Dialog",Font.PLAIN,18));
        paperButton.addActionListener(this);
        add(paperButton);

        //Scissor button
        scissorButton = new JButton("Scissor");
        scissorButton.setBounds(290, 387, 105,81);
        scissorButton.setFont(new Font("Dialog",Font.PLAIN,18));
        scissorButton.addActionListener(this);
        add(scissorButton);
    }

    public void showDialog(String message){
        JDialog dialog = new JDialog(this, "Result", true);
        dialog.setSize(227,124);
        dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
        dialog.setResizable(false);

        JLabel resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Dialog",Font.BOLD,18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dialog.add(resultLabel, BorderLayout.CENTER);

        JButton tryAgainButton = new JButton("Try Again?");
        tryAgainButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                computerChoice.setText("?");

                dialog.dispose();
            }
        });
        dialog.add(tryAgainButton, BorderLayout.SOUTH   );
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String playerChoice = e.getActionCommand().toString();
        String result = rockPaperScissor.playRockPaperScissor(playerChoice);

        computerChoice.setText(rockPaperScissor.getComputerChoice());

        computerScoreLabel.setText("Computer Score: " + rockPaperScissor.getComputerScore());
        playerScoreLabel.setText("Player Score: " + rockPaperScissor.getPlayerScore());

        showDialog(result);
    }
}
