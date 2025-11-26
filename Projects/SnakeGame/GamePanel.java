package SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    //Grid Settng
    private final int CELL_SIZE = 15;
    private final int GRID_COLS = GameBoard.BOARD_WIDTH / CELL_SIZE;
    private final int GRID_ROWS = GameBoard.BOARD_HEIGHT / CELL_SIZE;

    // snake length
    private LinkedList<Point> snake = new LinkedList<>();

    // Food
    private Point food;
    private Random random = new Random();
    // directions
    private Direction currentDirection = Direction.RIGHT;
    private Direction nextDirection = Direction.RIGHT;

    // Game Engine
    private Timer timer;
    private int DELAY = 120;

    //score
    private int score = 0;
    private boolean gameOver = false;

    public GamePanel() {
        setPreferredSize(new Dimension(GameBoard.BOARD_WIDTH, GameBoard.BOARD_HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        requestFocusInWindow();
        initGame();
        initKeyListener();
    }

    private void initGame() {
        int x = GRID_COLS / 2;
        int y = GRID_ROWS / 2;

        snake.clear();
        snake.add(new Point(x, y));
        snake.add(new Point(x-1, y));
        snake.add(new Point(x-2, y));
        placeFood();
        timer = new Timer(DELAY, this);
        timer.start();
    }

   private void initKeyListener() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_W:
                        if(currentDirection != Direction.DOWN) {
                            nextDirection = Direction.UP;
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                        if(currentDirection != Direction.UP) {
                            nextDirection = Direction.DOWN;
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_A:
                        if(currentDirection != Direction.RIGHT) {
                            nextDirection = Direction.LEFT;
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_D:
                        if(currentDirection != Direction.LEFT) {
                            nextDirection = Direction.RIGHT;
                        }
                        break;
                    case KeyEvent.VK_R:
                        if(gameOver){
                            gameOver = false;
                            score = 0;
                            initGame();
                        }
                        break;
                }
            }
        });
   }

   private void placeFood(){
        while (true){
            int x = random.nextInt(GRID_COLS);
            int y  = random.nextInt(GRID_ROWS);

            Point p = new Point(x, y);
            if(!snake.contains(p)){
                food = p;
                break;
            }
        }
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!gameOver){
            updateGame();
        }
        repaint();
    }
    private void updateGame(){
        currentDirection = nextDirection;

        Point head = snake.getFirst();
        Point newHead = new Point(head.x, head.y);

        switch(currentDirection){
            case UP -> newHead.y--;
            case DOWN -> newHead.y++;
            case LEFT -> newHead.x--;
            case RIGHT -> newHead.x++;
        }
        //wall collision
        if(newHead.x < 0 || newHead.x > GRID_COLS || newHead.y < 0 || newHead.y > GRID_ROWS){
            gameOver = true;
            timer.stop();
            return;
        }
        // self collision
        if(snake.contains(newHead)){
            gameOver = true;
            timer.stop();
            return;
        }

        if (snake.size() == GRID_COLS * GRID_ROWS) {
            gameOver = true;
            timer.stop();
        }
        snake.addFirst(newHead);

        if(newHead.equals(food)){
            score++;
            placeFood();
        }else{
            snake.removeLast();
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw food
        g.setColor(Color.RED);
        g.fillOval(food.x * CELL_SIZE, food.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);

        // draw snake
        g.setColor(Color.GREEN);
        for(Point p : snake) {
            g.fillRect(p.x * CELL_SIZE, p.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        }
        // diaplay score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 10, 20);

        // Game over message
        if(gameOver){
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("GAME OVER", GameBoard.BOARD_WIDTH/2 -150, GameBoard.BOARD_HEIGHT/2);
            g.setFont(new Font("Arial", Font.BOLD, 18));
            g.drawString("Press R to Restart", GameBoard.BOARD_WIDTH/2 -80, GameBoard.BOARD_HEIGHT/2 + 40);

        }

    }
}

