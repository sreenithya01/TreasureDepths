import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow() {
        setTitle("Treasure Depths");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen

        GamePanel panel = new GamePanel();
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new GameWindow();
    }
}
