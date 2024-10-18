import java.util.ArrayList;
import java.util.Random;

    public class Food {
        private Tile food;
        private Random random;
        private int boardWidth;
        private int boardHeight;
        private int tileSize;

        public Food(int boardWidth, int boardHeight, int tileSize) {
            this.boardWidth = boardWidth;
            this.boardHeight = boardHeight;
            this.tileSize = tileSize;
            this.random = new Random();
            placeFood(new ArrayList<>());
        }

        public void placeFood(ArrayList<Tile> snakeBody) {
            boolean validPositionFood;
            do {
                validPositionFood = true;
                food = new Tile(random.nextInt(boardWidth / tileSize), random.nextInt(boardHeight / tileSize));
                for (Tile part : snakeBody) {
                    if (food.equals(part)) {
                        validPositionFood = false;
                        break;
                    }
                }
            } while (!validPositionFood);
        }

        public Tile getFood() {
            return food;
        }
    }
