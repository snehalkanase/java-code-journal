package BrickBreakerGame.engine;

import BrickBreakerGame.entities.Ball;
import BrickBreakerGame.entities.Brick;
import BrickBreakerGame.entities.Paddle;
import BrickBreakerGame.utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {

    private Ball ball;
    private Paddle paddle;
    private Brick[] bricks;
    private Timer timer;

    private int score = 0;
    private boolean gameOver = false;

    public GamePanel(){
        setFocusable(true);
        setBackground(Color.black);
        addKeyListener(new InputHandler(this));
        initGameObject();
    }
    public void initGameObject(){
        ball = new Ball(Constants.WINDOW_WIDTH/2, Constants.WINDOW_HEIGHT/2);
        paddle = new Paddle(Constants.WINDOW_WIDTH / 2 - 50);
        bricks = new Brick[Constants.TOTAL_BRICKS];

        int brickX = 50;
        int brickY = 50;

        for(int i = 0; i < Constants.TOTAL_BRICKS; i++){
            bricks[i] = new Brick(brickX, brickY);

            brickX += Constants.BRICK_WIDTH + 10;
            if((i +1) % Constants.BRICKS_PER_ROW == 0 ){
                brickX = 50;
                brickY = Constants.BRICK_HEIGHT + 10;
            }

        }
    }

    public void startGame(){
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!gameOver){
            paddle.update();
            ball.update();

            CollisionDetector.checkWallCollision(ball);
            CollisionDetector.checkPaddleCollision(ball,  paddle);
            CollisionDetector.checkBrickCollision(ball, bricks);

            for(Brick brick : bricks){
                if(!brick.isVisible()) score++;
            }
            if(ball.getY() > Constants.WINDOW_HEIGHT) gameOver = true;
        }else{

        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        ball.draw(g);
        paddle.draw(g);

        for(Brick brick : bricks){
            if(brick.isVisible()) brick.draw(g);
        }

        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 20, 20);

        if(gameOver){
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 32));
            g.drawString("GAME OVER", Constants.WINDOW_WIDTH / 2 - 120, Constants.WINDOW_HEIGHT / 2);
        }
    }
    public Paddle getPaddle() {
        return paddle;
    }
}
