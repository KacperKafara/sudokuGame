package pl.lodz.p.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SudokuBoard {

    private List<SudokuField> board = Arrays.asList(new SudokuField[81]);
    private SudokuRow[] row;
    private SudokuColumn[] column;
    private SudokuBox[] box;
    private final SudokuSolver sudokuSolver;


    private List<SudokuField> initBoard() {
        List<SudokuField> result = Arrays.asList(new SudokuField[81]);
        SudokuRow[] row = new SudokuRow[9];
        SudokuColumn[] column = new SudokuColumn[9];
        SudokuBox[] box = new SudokuBox[9];


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                result.set(i * 9 + j, new SudokuField());
            }
            row[i] = new SudokuRow();
            column[i] = new SudokuColumn();
            box[i] = new SudokuBox();
        }

        Random rand = new Random();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == 0) {
                    int random = 0;
                    do {
                        random = rand.nextInt(9) + 1;
                    } while (checkRow(result, i, j, random));
                    result.get(i * 9 + j).setFieldValue(random);
                } else {
                    result.get(i * 9 + j).setFieldValue(0);
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                row[i].setRow(result.get(i * 9 + j), j);
                column[j].setColumn(result.get(i * 9 + j), i);
                box[((i / 3) * 3) + (j / 3)].setBox(result.get(i * 9 + j), (i % 3) * 3 + (j % 3));
            }
        }


        this.row = row;
        this.column = column;
        this.box = box;

        return result;
    }

    private boolean checkRow(List<SudokuField> board, int x, int y, int number) {
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
        return row[y];
    }

    public SudokuColumn getColumn(int x) {
        return column[x];
    }

    public SudokuBox getBox(int x, int y) {
        return box[((x / 3) * 3) + (y / 3)];
    }
}
