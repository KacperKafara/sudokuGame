package pl.lodz.p.sudoku;

public class BacktrackingSudokuSolver implements SudokuSolver {

    SudokuBoard board;

    @Override
    public boolean solve(SudokuBoard board) {
        this.board = board;
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.board.getValue(i, j) == 0) {
                    row = i;
                    col = j;

                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        if (isEmpty) {
            return true;
        }

        for (int num = 1; num <= 9; num++) {
            if (isLayoutCorrect(this.board, row, col, num)) {
                this.board.setValue(row, col, num);
                if (solve(board)) {
                    return true;
                } else {
                    this.board.setValue(row, col, 0);
                }
            }
        }
        return false;
    }

    private boolean isLayoutCorrect(SudokuBoard board, int x, int y, int number) {

        if (isRowCorrect(board, x, y, number)) {
            return false;
        }

        if (!isCollumnCorrect(board, x, y, number)) {
            return false;
        }

        if (!isBoxCorrect(board, x, y, number)) {
            return false;
        }

        return true;
    }

    private boolean isCollumnCorrect(SudokuBoard board, int x, int y, int number) {
        for (int i = 0; i < 9; i++) {
            if (board.getValue(i, y) == number) {
                return false;
            }
        }
        return true;
    }

    private boolean isRowCorrect(SudokuBoard board, int x, int y, int number) {
        for (int i = 0; i < 9; i++) {
            if (board.getValue(x, i) == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isBoxCorrect(SudokuBoard board, int x, int y, int number) {
        int boxX = x - (x % 3);
        int boxY = y - (y % 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getValue(boxX + i, boxY + j) == number) {
                    return false;
                }
            }
        }
        return true;
    }
}
