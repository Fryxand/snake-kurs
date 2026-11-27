package snake;

import java.util.Random;

public class GameModel {
    public static final int MIN_CELLS = 16;

    private static final int SNAKE_LENGTH = 8;

    private final Random random;
    private final Field field;
    private final Snake snake;

    public GameModel(int cols, int rows) {
        this(cols, rows, new Random());
    }

    public GameModel(int cols, int rows, Random random) {
        if (cols < MIN_CELLS || rows < MIN_CELLS) {
            throw new IllegalArgumentException("Поле слишком мало: " + cols + "x" + rows);
        }
        this.random = random;
        this.field = new Field(cols, rows);
        this.snake = createSnake();
    }

    public void tick() {
        snake.move();
    }

    public Snake getSnake() {
        return snake;
    }

    public Field getField() {
        return field;
    }

    private Snake createSnake() {
        return new Snake(field.center(), SNAKE_LENGTH, Direction.randomDiagonal(random));
    }
}