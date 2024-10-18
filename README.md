# 🐍 Snake Game in Java

This project is a simple **Snake game** built using Java and Swing for graphical rendering. The game consists of a snake that moves around the board, eating food and growing longer. The goal is to avoid colliding with the snake's body or the boundaries of the game board.

## ✨ Features
- 🎲 **Randomized snake and food placement**: The snake's initial position and food are randomly placed on the board.
- 🎮 **Smooth snake movement**: Control the snake using the arrow keys and watch it grow as it eats food.
- ❌ **Game Over**: The game ends if the snake collides with its body or the board boundaries.
- 🏆 **Score Tracking**: Keep track of your score as the snake gets longer.

## 🛠️ Project Structure

The project is divided into several classes, each handling a specific component of the game:

- `App.java`: 🏁 The main entry point that sets up the game window (JFrame) and adds the game panel.
- `GamePanel.java`: 🎨 The core game logic and rendering. It manages the game state, listens for keyboard input, and updates the display.
- `Snake.java`: 🐍 Manages the snake's movement, growth, and collisions.
- `Food.java`: 🍎 Handles the placement of food, ensuring it doesn't overlap with the snake.
- `Tile.java`: 📦 Represents individual units (tiles) on the board for both the snake and the food.

## 🚀 How to Run

### Prerequisites
- ☕ **Java Development Kit (JDK) 8 or higher**
- 💻 **IDE or text editor** of your choice

### Steps to Run

1. **Clone the repository**:
    ```bash
    git clone https://github.com/TiaWasTaken/java-snake.git
    ```
    
2. **Compile the project**:
    Navigate to the root of your project where the `.java` files are located and compile the code using the command line or an IDE like IntelliJ IDEA or Eclipse. For the command line, use:
    ```bash
    javac App.java
    ```

3. **Run the project**:
    After compiling, run the application with the following command:
    ```bash
    java App
    ```

    The game window will open, and you can start playing by pressing the arrow keys. 🎉

## 🎮 Controls

- ⬆️⬇️⬅️➡️ **Arrow keys**: Control the movement of the snake (Up, Down, Left, Right).
- The game starts when you press any arrow key and ends when the snake hits itself or the edges of the board.

## 🖼️ Game Screenshot

![Screenshot 2024-10-18 102654](https://github.com/user-attachments/assets/90039fcd-b8ab-40b6-a681-746ac9fe41e3)


## 🔧 How to Modify

### Customizing the Game
- **Board Size**: Adjust the width and height of the game board by modifying the `boardWidth` and `boardHeight` values in `App.java`.
- **Snake Speed**: Change the delay between frames (currently 100 ms) by modifying the timer value in `GamePanel.java`:
    ```java
    gameLoop = new Timer(100, this);
    ```

## 🌟 Future Improvements

- ⚡ Add difficulty levels (increase snake speed as the score increases).
- 🚧 Implement obstacles for the snake to avoid.
- 🏅 Create a high-score system.

## 📜 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

## 🙌 Acknowledgments

- ☕ Java Swing for the graphical interface
- 🕹️ Inspired by the classic Snake game
