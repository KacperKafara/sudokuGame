package pl.lodz.p.pk.sudoku;

import java.util.Arrays;

public class Main {
    public static void drawBoard(int[][] board) {
        System.out.println("_____________________________________");
        for (int i = 0;i < 9;i++) {
            System.out.print("|");
            for (int j = 0;j < 9;j++) {
                System.out.print(" " + board[i][j] + " " + "|");
            }
            System.out.println("");
            if (i < 8) {
                System.out.println("|---|---|---|---|---|---|---|---|---|");
            } else {
                System.out.println("|___|___|___|___|___|___|___|___|___|");
            }
        }
    }

    public static void main(String[] args) {

        SudokuBoard sudoku = new SudokuBoard();
        sudoku.fillBoard(sudoku.getBoard());
        drawBoard(sudoku.getBoard());
    }
}