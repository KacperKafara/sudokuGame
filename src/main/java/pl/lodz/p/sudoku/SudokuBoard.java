package pl.lodz.p.sudoku;

import java.util.Random;

public class SudokuBoard {

    private final int[][] board;

    private int[][] initBoard() {
        int[][] result = new int[9][9];
        Random rand = new Random();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                if (i == 0) {
                    int random = 0;
                    do {
                        random = rand.nextInt(9) + 1;
                    } while (!isLayoutCorrect(result, i, j, random));

                    result[i][j] = random;
                } else {
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }

    public int[][] getBoard() {
        return board.clone();
    }

    public int getValue(int x, int y) {
        return board[x][y];
    }

    public void setValue(int x, int y, int value) {
        board[x][y] = value;
    }

    public SudokuBoard() {
        board = initBoard();
    }

    public boolean fillBoard(int[][] board) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
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
            if (isLayoutCorrect(board, row, col, num)) {
                board[row][col] = num;
                if (fillBoard(board)) {
                    return true;
                } else {
                    board[row][col] = 0;
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

    private boolean isRowCorrect(int[][] board, int x, int y, int number) {
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == number) {
                return false;
            }
        }
        return true;
    }

    private boolean isCollumnCorrect(int[][] board, int x, int y, int number) {
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
