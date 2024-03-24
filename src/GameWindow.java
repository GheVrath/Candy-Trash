import javax.swing.*;

/**
 * Creates a new game window
 */
public class GameWindow extends JFrame {
    public GameWindow(GamePanel gamePanel) {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(gamePanel);
        this.pack();
        this.setLocationRelativeTo(null);
    }
}
