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
        SudokuRow[] row = new SudokuRow[9];
        SudokuColumn[] column = new SudokuColumn[9];
        SudokuBox[] box = new SudokuBox[9];


        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                result[i][j] = new SudokuField();
            }
            row[i] = new SudokuRow();
            column[i] = new SudokuColumn();
            box[i] = new SudokuBox();
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

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                row[i].setRow(result[i][j],j);
                column[j].setColumn(result[i][j],i);
                box[((i / 3)*3)+(j / 3)].setBox(result[i][j],(i % 3)*3+(j % 3));
            }
        }


        this.row=row;
        this.column=column;
        this.box=box;

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
