package RockPaperScissor;

import java.util.Random;

public class RockPaperScissor {
    private static final String[] computerChoices = {"Rock", "Paper", "Scissor" };
    private String computerChoice;

    private int computerScore, playerScore;

    private Random random;

    public String getComputerChoice() {
        return computerChoice;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public RockPaperScissor() {
        random = new Random();
    }

    public String playRockPaperScissor(String playerChoice) {
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];

        String result;
        if(computerChoice.equals("Rock")) {
            if(playerChoice.equals("Paper")) {
                result = "Player wins";
                playerScore++;
            } else if(playerChoice.equals("Scissor")) {
                result = "Computer wins";
                computerScore++;
            } else {
                result = "Draw";
            }
        } else if(computerChoice.equals("Paper")) {
            if(playerChoice.equals("Scissor")) {
                result = "Player wins";
                playerScore++;
            } else if(playerChoice.equals("Rock")) {
                result = "Computer wins";
                computerScore++;
            } else {
                result = "Draw";
            }
        } else {
            if(playerChoice.equals("Rock")) {
                result = "Player wins";
                playerScore++;
            } else if(playerChoice.equals("Paper")) {
                result = "Computer wins";
                computerScore++;
            } else {
                result = "Draw";
            }
        }
        return result;
    }
}
