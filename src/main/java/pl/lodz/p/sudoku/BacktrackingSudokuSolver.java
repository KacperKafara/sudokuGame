package pl.lodz.p.sudoku;

public class BacktrackingSudokuSolver implements SudokuSolver {

    @Override
    public boolean solve(SudokuBoard board) {
        int[][] sudokuBoard = board.getBoard();
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudokuBoard[i][j] == 0) {
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
            if (isLayoutCorrect(sudokuBoard, row, col, num)) {
                sudokuBoard[row][col] = num;
                if (solve(board)) {
                    return true;
                } else {
                    sudokuBoard[row][col] = 0;
                }
            }
        }
        return false;
    }

    private boolean isLayoutCorrect(int[][] board, int x, int y, int number) {

        if (!isRowCorrect(board, x, y, number)) {
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

    private boolean isCollumnCorrect(int[][] board, int x, int y, int number) {
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == number) {
                return false;
            }
        }
        return true;
    }

    private boolean isRowCorrect(int[][] board, int x, int y, int number) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == number) {
                return false;
            }
        }
        return true;
    }

    private boolean isBoxCorrect(int[][] board, int x, int y, int number) {
        int boxX = x - (x % 3);
        int boxY = y - (y % 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boxX + i][boxY + j] == number) {
                    return false;
                }
            }
        }
        return true;
    }
}
