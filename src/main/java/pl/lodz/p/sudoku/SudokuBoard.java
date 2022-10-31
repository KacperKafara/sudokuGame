package pl.lodz.p.sudoku;

import java.util.Random;

public class SudokuBoard {

    private SudokuField[][] board;
    private SudokuRow[] row;
    private SudokuColumn[] column;
    private SudokuBox[] box;
    private final SudokuSolver sudokuSolver;


    private SudokuField[][] initBoard() {
        SudokuField[][] result = new SudokuField[9][9];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                result[i][j] = new SudokuField();
            }
        }

        Random rand = new Random();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                if (i == 0) {
                    int random = 0;
                    do {
                        random = rand.nextInt(9) + 1;
                    } while (sudokuSolver.isRowCorrect(result, i, j, random));
                    result[i][j].setFieldValue(random);
                } else {
                    result[i][j].setFieldValue(0);
                }
            }
        }
        return result;
    }

    public SudokuField[][] getBoard() {
        return board.clone();
    }

    public int getValue(int x, int y) {
        return board[x][y].getFieldValue();
    }

    public void setValue(int x, int y, int value) {
        board[x][y].setFieldValue(value);
    }

    public SudokuBoard(SudokuSolver solver) {
        this.sudokuSolver = solver;
        this.board = initBoard();
    }

    public void solveGame() {
        sudokuSolver.solve(this);
    }

}
