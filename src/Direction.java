public record Direction(int dx, int dy) {

    public Direction reflectX() {
        return new Direction(-dx, dy);
    }

    public Direction reflectY() {
        return new Direction(dx, -dy);
    }
}
