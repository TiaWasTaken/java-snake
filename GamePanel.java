import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private int boardWidth;
    private int boardHeight;
    private int tileSize = 25;

    private Snake snake;
    private Food food;

    private int velocityX;
    private int velocityY;
    private boolean gameOver = false;

    private Timer gameLoop;

    public GamePanel(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.black);
        addKeyListener(this);
        setFocusable(true);

        snake = new Snake(boardWidth, boardHeight, tileSize);
        food = new Food(boardWidth, boardHeight, tileSize);

        velocityX = 0;
        velocityY = 0;

        gameLoop = new Timer(100, this);
        gameLoop.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        // Draw grid
        for (int i = 0; i < boardWidth / tileSize; i++) {
            g.drawLine(i * tileSize, 0, i * tileSize, boardHeight);
            g.drawLine(0, i * tileSize, boardWidth, i * tileSize);
        }

        // Draw food
        g.setColor(Color.red);
        Tile foodTile = food.getFood();
        g.fill3DRect(foodTile.x * tileSize, foodTile.y * tileSize, tileSize, tileSize, true);

        // Draw snake
        g.setColor(Color.green);
        Tile snakeHead = snake.getHead();
        g.fill3DRect(snakeHead.x * tileSize, snakeHead.y * tileSize, tileSize, tileSize, true);
        for (Tile part : snake.getBody()) {
            g.fill3DRect(part.x * tileSize, part.y * tileSize, tileSize, tileSize, true);
        }

        // Draw score or game over
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        if (gameOver) {
            g.setColor(Color.red);
            g.drawString("Game Over: " + snake.getBody().size(), tileSize - 16, tileSize);
        } else if (velocityX == 0 && velocityY == 0) {
            g.setColor(Color.green);
            g.drawString("Press any arrow key to start.", tileSize - 16, tileSize);
        } else {
            g.drawString("Score: " + snake.getBody().size(), tileSize - 16, tileSize);
        }
    }

    public void move() {
        // Check if snake eats food
        if (snake.getHead().equals(food.getFood())) {
            snake.grow();
            food.placeFood(snake.getBody());
        }

        // Move snake
        snake.move(velocityX, velocityY);

        // Check collision with self or boundaries
        if (snake.checkCollisionWithSelf() || isOutOfBounds(snake.getHead())) {
            gameOver = true;
        }
    }

    private boolean isOutOfBounds(Tile tile) {
        return tile.x * tileSize < 0 || tile.x * tileSize >= boardWidth || tile.y * tileSize < 0 || tile.y * tileSize >= boardHeight;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if (gameOver) {
            gameLoop.stop();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP && velocityY != 1) {
            velocityX = 0;
            velocityY = -1;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN && velocityY != -1) {
            velocityX = 0;
            velocityY = 1;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT && velocityX != 1) {
            velocityX = -1;
            velocityY = 0;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && velocityX != -1) {
            velocityX = 1;
            velocityY = 0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
