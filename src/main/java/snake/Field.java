package snake;

import java.util.Collection;

public class Field {
    private final int cols;
    private final int rows;

    public Field(int cols, int rows) {
        if (cols < 1 || rows < 1) {
            throw new IllegalArgumentException("Размер поля должен быть положительным: " + cols + "x" + rows);
        }
        this.cols = cols;
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public Cell center() {
        return new Cell(cols / 2, rows / 2);
    }

    public boolean contains(Cell cell) {
        return cell.x() >= 0 && cell.x() < cols && cell.y() >= 0 && cell.y() < rows;
    }

    public boolean containsAll(Collection<Cell> cells) {
        return cells.stream().allMatch(this::contains);
    }

    public Direction reflect(Cell head, Direction direction) {
        Cell next = head.moved(direction, 1);
        Direction result = direction;
        if (next.x() < 0 || next.x() >= cols) {
            result = result.reflectX();
        }
        if (next.y() < 0 || next.y() >= rows) {
            result = result.reflectY();
        }
        return result;
    }
}