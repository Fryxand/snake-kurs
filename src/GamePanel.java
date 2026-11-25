import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

public class GamePanel extends JPanel {
    private static final int CELL = 20;
    private static final int SNAKE_LENGTH = 8;

    private final Snake snake;

    public GamePanel() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        setFocusable(true);
        snake = new Snake(new Point(20, 15), SNAKE_LENGTH, new Direction(1, 1));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        boolean isHead = true;
        for (Point p : snake.getSegments()) {
            g2.setColor(isHead ? new Color(120, 255, 120) : new Color(40, 180, 60));
            g2.fillRoundRect(p.x * CELL + 1, p.y * CELL + 1, CELL - 2, CELL - 2, 8, 8);
            isHead = false;
        }
    }
}