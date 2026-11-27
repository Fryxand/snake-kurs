package snake;

import java.util.List;
import java.util.Random;

public record Direction(int dx, int dy) {
    private static final List<Direction> DIAGONALS = List.of(
            new Direction(1, 1),
            new Direction(1, -1),
            new Direction(-1, 1),
            new Direction(-1, -1));

    public Direction reflectX() {
        return new Direction(-dx, dy);
    }

    public Direction reflectY() {
        return new Direction(dx, -dy);
    }

    public static Direction randomDiagonal(Random random) {
        return DIAGONALS.get(random.nextInt(DIAGONALS.size()));
    }
}