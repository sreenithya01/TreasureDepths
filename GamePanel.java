import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private int diverX = 0;
    private int diverY = 0;
    private int oxygen = 50;

    private final int TILE_SIZE = 100;
    private final int ROWS = 5;
    private final int COLS = 5;

    public GamePanel() {
        setFocusable(true);
        requestFocusInWindow();

        // Handle arrow key movement
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                switch (e.getKeyCode()) {
                    case java.awt.event.KeyEvent.VK_UP -> diverY = Math.max(0, diverY - 1);
                    case java.awt.event.KeyEvent.VK_DOWN -> diverY = Math.min(ROWS - 1, diverY + 1);
                    case java.awt.event.KeyEvent.VK_LEFT -> diverX = Math.max(0, diverX - 1);
                    case java.awt.event.KeyEvent.VK_RIGHT -> diverX = Math.min(COLS - 1, diverX + 1);
                }
                oxygen--;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw grid
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                g.drawRect(j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }

        // Draw diver
        g.setColor(Color.BLUE);
        g.fillOval(diverX * TILE_SIZE + 25, diverY * TILE_SIZE + 25, 50, 50);

        // Draw oxygen level
        g.setColor(Color.BLACK);
        g.drawString("Oxygen: " + oxygen, 10, 20);
    }
}
