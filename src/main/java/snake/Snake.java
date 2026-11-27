package snake;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Snake {
    private final Deque<Cell> segments = new ArrayDeque<>();
    private Direction direction;

    public Snake(Cell head, int length, Direction direction) {
        Objects.requireNonNull(head, "Голова не задана");
        this.direction = Objects.requireNonNull(direction, "Направление не задано");
        if (length < 1) {
            throw new IllegalArgumentException("Длина змейки должна быть не меньше 1: " + length);
        }
        IntStream.range(0, length)
                .mapToObj(i -> head.moved(direction, -i))
                .forEach(segments::addLast);
    }

    public List<Cell> getSegments() {
        return List.copyOf(segments);
    }

    public Cell getHead() {
        return segments.peekFirst();
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = Objects.requireNonNull(direction, "Направление не задано");
    }

    public void move() {
        segments.addFirst(getHead().moved(direction, 1));
        segments.removeLast();
    }
}