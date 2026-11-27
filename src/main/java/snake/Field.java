package snake;

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
}