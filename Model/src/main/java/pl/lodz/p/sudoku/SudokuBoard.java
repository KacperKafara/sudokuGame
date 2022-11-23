package pl.lodz.p.sudoku;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SudokuBoard implements Serializable {

    private List<SudokuField> board = Arrays.asList(new SudokuField[81]);
    private List<SudokuRow> row = Arrays.asList(new SudokuRow[9]);
    private List<SudokuColumn> column = Arrays.asList(new SudokuColumn[9]);
    private List<SudokuBox> box = Arrays.asList(new SudokuBox[9]);
    private final SudokuSolver sudokuSolver;


    private List<SudokuField> initBoard() {
        List<SudokuField> result = Arrays.asList(new SudokuField[81]);
        List<SudokuRow> row = Arrays.asList(new SudokuRow[9]);
        List<SudokuColumn> column = Arrays.asList(new SudokuColumn[9]);
        List<SudokuBox> box = Arrays.asList(new SudokuBox[9]);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                result.set(i * 9 + j, new SudokuField());
            }
            row.set(i, new SudokuRow());
            column.set(i, new SudokuColumn());
            box.set(i, new SudokuBox());
        }

        Random rand = new Random();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == 0) {
                    int random = 0;
                    do {
                        random = rand.nextInt(9) + 1;
                    } while (checkRow(result, random));
                    result.get(j).setFieldValue(random);
                } else {
                    result.get(i * 9 + j).setFieldValue(0);
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                row.get(i).setRow(result.get(i * 9 + j), j);
                column.get(j).setColumn(result.get(i * 9 + j), i);
                box.get(i / 3 * 3 + j / 3).setBox(result.get(i * 9 + j), i % 3 * 3 + j % 3);
            }
        }


        this.row = row;
        this.column = column;
        this.box = box;

        return result;
    }

    private boolean checkRow(List<SudokuField> board, int number) {
        for (int i = 0; i < 9; i++) {
            if (board.get(i).getFieldValue() == number) {
                return true;
            }
        }
        return false;
    }

    public List<SudokuField> getBoard() {
        return board;
    }

    public int getValue(int x, int y) {
        return board.get(x * 9 + y).getFieldValue();
    }

    public void setValue(int x, int y, int value) {
        board.get(x * 9 + y).setFieldValue(value);
    }

    public SudokuBoard(SudokuSolver solver) {
        this.sudokuSolver = solver;
        this.board = initBoard();
    }

    public void solveGame() {
        sudokuSolver.solve(this);
    }

    public SudokuRow getRow(int y) {
        return row.get(y);
    }

    public SudokuColumn getColumn(int x) {
        return column.get(x);
    }

    public SudokuBox getBox(int x, int y) {
        return box.get(x / 3 * 3 + y / 3);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("board", board)
                .append("rows", row)
                .append("columns", column)
                .append("boxes", box).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SudokuBoard that = (SudokuBoard) o;

        return new EqualsBuilder()
                .append(board, that.board)
                .append(row, that.row)
                .append(column, that.column)
                .append(box, that.box)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(board)
                .append(row)
                .append(column)
                .append(box)
                .toHashCode();
    }
}
