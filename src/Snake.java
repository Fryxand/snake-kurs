import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Deque;

public class Snake {
    private final Deque<Point> segments = new ArrayDeque<>();
    private Direction direction;

    public Snake(Point head, int length, Direction direction) {
        this.direction = direction;
        for (int i = 0; i < length; i++) {
            segments.addLast(new Point(
                    head.x - direction.dx() * i,
                    head.y - direction.dy() * i));
        }
    }

    public Deque<Point> getSegments() {
        return segments;
    }

    public Point getHead() {
        return segments.peekFirst();
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move() {
        Point head = getHead();
        segments.addFirst(new Point(head.x + direction.dx(), head.y + direction.dy()));
        segments.removeLast();
    }
}