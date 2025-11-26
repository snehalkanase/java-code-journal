package BrickBreakerGame.engine;

import BrickBreakerGame.entities.Ball;
import BrickBreakerGame.entities.Brick;
import BrickBreakerGame.entities.Paddle;

public class CollisionDetector {
    public static void checkWallCollision(Ball ball){
        if(ball.getX() < 0 || ball.getX() > 780){
            ball.reverseX();
        }
        if(ball.getY() < 0){
            ball.reverseY();
        }
    }
    public static void checkPaddleCollision(Ball ball, Paddle paddle){
        if(ball.getRect().intersects(paddle.getRect())){
            ball.reverseY();
        }
    }
    public static void checkBrickCollision(Ball ball, Brick[] bricks){
        for(Brick brick : bricks){
            if(brick.isVisible() && ball.getRect().intersects(brick.getRect())){
                ball.reverseY();
                brick.setVisible(false);
            }
        }
    }
}
