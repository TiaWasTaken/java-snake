import javax.swing.*;

public class App {
    public static void main(String[] args) {
        int boardWidth = 600;
        int boardHeight = 600;

        // Create the frame
        JFrame frame = new JFrame("Snake");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        // Center the window on the screen
        frame.setLocationRelativeTo(null);
        // Disable resizing of the window
        frame.setResizable(false);
        // Set default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and add the game panel
        GamePanel gamePanel = new GamePanel(boardWidth, boardHeight);
        frame.add(gamePanel);

        // Adjust the frame size based on its contents
        frame.pack();

        // Set focus on the game panel for key events
        gamePanel.requestFocus();
    }
}
