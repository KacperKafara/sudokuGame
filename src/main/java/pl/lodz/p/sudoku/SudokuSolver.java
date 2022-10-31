package pl.lodz.p.sudoku;

public interface SudokuSolver {
    boolean solve(SudokuBoard board);

    boolean isRowCorrect(SudokuField[][] board, int x, int y, int random);
}
