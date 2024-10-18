import java.util.ArrayList;
import java.util.Random;

public class Snake {
    private ArrayList<Tile> body;
    private Tile head;
    private Random random;
    private int boardWidth;
    private int boardHeight;
    private int tileSize;

    public Snake(int boardWidth, int boardHeight, int tileSize) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.tileSize = tileSize;
        this.random = new Random();
        this.body = new ArrayList<>();
        placeSnake();
    }

    public void placeSnake() {
        head = new Tile(random.nextInt(boardWidth / tileSize), random.nextInt(boardHeight / tileSize));
    }

    public Tile getHead() {
        return head;
    }

    public ArrayList<Tile> getBody() {
        return body;
    }

    public void grow() {
        body.add(new Tile(head.x, head.y));
    }

    public void move(int velocityX, int velocityY) {
        // Move snake body
        for (int i = body.size() - 1; i > 0; i--) {
            body.get(i).x = body.get(i - 1).x;
            body.get(i).y = body.get(i - 1).y;
        }
        if (!body.isEmpty()) {
            body.get(0).x = head.x;
            body.get(0).y = head.y;
        }

        // Move snake head
        head.x += velocityX;
        head.y += velocityY;
    }

    public boolean checkCollisionWithSelf() {
        for (Tile part : body) {
            if (part.equals(head)) {
                return true;
            }
        }
        return false;
    }
}


