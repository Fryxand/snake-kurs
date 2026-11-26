import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.Random;

public class GamePanel extends JPanel {
    private static final int CELL = 20;
    private static final int SNAKE_LENGTH = 8;

    private final Random random = new Random();
    private final Timer timer;
    private Snake snake;
    private int delay = 100;

    public GamePanel() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        setFocusable(true);
        snake = createSnake(40, 30);
        timer = new Timer(delay, e -> tick());
        timer.start();
    }

    private Snake createSnake(int cols, int rows) {
        int dx = random.nextBoolean() ? 1 : -1;
        int dy = random.nextBoolean() ? 1 : -1;
        return new Snake(new Point(cols / 2, rows / 2), SNAKE_LENGTH, new Direction(dx, dy));
    }

    private void tick() {
        snake.move();
        repaint();
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