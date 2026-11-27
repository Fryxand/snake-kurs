package snake;

public record Cell(int x, int y) {
    public Cell moved(Direction direction, int steps) {
        return new Cell(x + direction.dx() * steps, y + direction.dy() * steps);
    }
}