package snake;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.stream.IntStream;

public class GameView {
    public static final int CELL = 20;

    private static final Color BACKGROUND = Color.BLACK;
    private static final Color HEAD = Color.rgb(120, 255, 120);
    private static final Color BODY = Color.rgb(40, 180, 60);
    private static final int ARC = 8;

    private final Canvas canvas = new Canvas();

    public Canvas getCanvas() {
        return canvas;
    }

    public void draw(Snake snake) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        clear(gc);
        drawSnake(gc, snake);
    }

    private void clear(GraphicsContext gc) {
        gc.setFill(BACKGROUND);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private void drawSnake(GraphicsContext gc, Snake snake) {
        List<Cell> segments = snake.getSegments();
        IntStream.range(0, segments.size())
                .forEach(i -> drawCell(gc, segments.get(i), i == 0 ? HEAD : BODY));
    }

    private void drawCell(GraphicsContext gc, Cell cell, Color color) {
        gc.setFill(color);
        gc.fillRoundRect(cell.x() * CELL + 1, cell.y() * CELL + 1, CELL - 2, CELL - 2, ARC, ARC);
    }
}