package pl.lodz.p.sudoku;

import java.util.List;

public class Main {
    public static void drawBoard(List<SudokuField> board) {
        System.out.println("_____________________________________");
        for (int i = 0;i < 9;i++) {
            System.out.print("|");
            for (int j = 0;j < 9;j++) {
                System.out.print(" " + board.get(i * 9 + j).getFieldValue() + " " + "|");
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
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(solver);
        sudoku.solveGame();
        drawBoard(sudoku.getBoard());

    }
}