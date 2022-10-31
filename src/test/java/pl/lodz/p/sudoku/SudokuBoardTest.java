package pl.lodz.p.sudoku;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {

    @Test
    void testFillBoard() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudoku1 = new SudokuBoard(solver);
        SudokuBoard sudoku2 = new SudokuBoard(solver);
        SudokuField[][] board1 = sudoku1.getBoard();
        SudokuField[][] board2 = sudoku2.getBoard();
        assertFalse(Arrays.deepEquals(board1, board2));
    }

    @Test
    void testInitBoard() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudoku1 = new SudokuBoard(solver);
        SudokuBoard sudoku2 = new SudokuBoard(solver);
        int num1 = 0, num2 = 0;
        for (int j = 0; j < 9; j++) {
            num1 = sudoku1.getValue(0, j);
            num2 = sudoku2.getValue(0, j);
            if(num1 != num2) break;
        }
        assertNotEquals(num1, num2);
    }

    @Test
    void testRowCorrect() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(solver);
        sudoku.solveGame();
        boolean rowCorrect = true;
        Set<Integer> row = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                row.add(sudoku.getValue(i, j));
            }
            if(sudoku.getBoard()[i].length != row.size()) rowCorrect = false;
            row.clear();
        }
        assertTrue(rowCorrect);
    }

    @Test
    void testCollumnCorrect() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(solver);
        sudoku.solveGame();
        boolean colCorrect = true;
        Set<Integer> col = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                col.add(sudoku.getValue(j, i));
            }
            if(sudoku.getBoard().length != col.size()) colCorrect = false;
            col.clear();
        }
        assertTrue(colCorrect);
    }

    @Test
    void testBoxCorrect() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(solver);
        sudoku.solveGame();
        boolean boxCorrect = true;
        Set<Integer> col = new HashSet<>();
        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j <= 6; j += 3) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        col.add(sudoku.getValue(i + k, j + l));
                    }
                }
                if(col.size() != 9) boxCorrect = false;
                col.clear();
            }
        }
        assertTrue(boxCorrect);
    }

    @Test
    void testSetValue() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(solver);
        sudoku.solveGame();
        if(sudoku.getValue(0, 0) != 1) {
            assertNotEquals(1, sudoku.getValue(0, 0));
            sudoku.setValue(0, 0, 1);
            assertEquals(1, sudoku.getValue(0, 0));
        } else {
            assertEquals(1, sudoku.getValue(0, 0));
            sudoku.setValue(0, 0, 2);
            assertEquals(2, sudoku.getValue(0, 0));
        }
    }
}