import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Dimension;

public class GameWindow extends JFrame {

    public GameWindow() {
        super("Змейка: отражение от границ");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GamePanel panel = new GamePanel();
        add(panel);
        pack();
        setMinimumSize(new Dimension(300, 300));
        setLocationRelativeTo(null);
        setVisible(true);
        panel.requestFocusInWindow();
    }
}