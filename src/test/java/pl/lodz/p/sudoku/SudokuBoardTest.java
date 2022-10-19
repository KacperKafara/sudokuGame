package pl.lodz.p.pk.sudoku;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {

    @Test
    void testFillBoard() {
        SudokuBoard sudoku1 = new SudokuBoard();
        SudokuBoard sudoku2 = new SudokuBoard();
        assertTrue(sudoku1.fillBoard(sudoku1.getBoard()));
        assertTrue(sudoku2.fillBoard(sudoku2.getBoard()));
        int[][] board1 = sudoku1.getBoard();
        int[][] board2 = sudoku2.getBoard();
        assertFalse(Arrays.equals(board1, board2));
    }

    @Test
    void testInitBoard() {
        SudokuBoard sudoku1 = new SudokuBoard();
        SudokuBoard sudoku2 = new SudokuBoard();
        int num1 = 0, num2 = 0;
        int arr1[] = new int[2];
        int arr2[] = new int[2];
        for(int j = 0; j < 9; j++) {
            num1 = sudoku1.getValue(0, j);
            num2 = sudoku2.getValue(0, j);
            if(num1 != num2) break;
        }
        assertNotEquals(num1, num2);
    }

    @Test
    void testIsRowCorrect() {
        SudokuBoard sudoku = new SudokuBoard();
        sudoku.fillBoard(sudoku.getBoard());
        boolean rowCorrect = true;
        Set<Integer> row = new HashSet<Integer>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                row.add(sudoku.getValue(i, j));
            }
            if(sudoku.getBoard()[i].length != row.size()) rowCorrect = false;
            row.clear();
        }
        assertTrue(rowCorrect);
    }

    @Test
    void testIsCollumnCorrect() {
        SudokuBoard sudoku = new SudokuBoard();
        sudoku.fillBoard(sudoku.getBoard());
        boolean colCorrect = true;
        Set<Integer> col = new HashSet<Integer>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                col.add(sudoku.getValue(j, i));
            }
            if(sudoku.getBoard().length != col.size()) colCorrect = false;
            col.clear();
        }
        assertTrue(colCorrect);
    }
}