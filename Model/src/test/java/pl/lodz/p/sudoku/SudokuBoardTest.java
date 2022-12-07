package pl.lodz.p.sudoku;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {

    @Test
    void testFillBoard() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudoku1 = new SudokuBoard(solver);
        SudokuBoard sudoku2 = new SudokuBoard(solver);
        List<SudokuField> board1 = sudoku1.getBoard();
        List<SudokuField> board2 = sudoku2.getBoard();
        assertFalse(board1.equals(board2));

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
            if(9 != row.size()) rowCorrect = false;
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
            if(9 != col.size()) colCorrect = false;
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
            SudokuField f1 = new SudokuField();
            f1.setFieldValue(2);
            sudoku.setField(0, 0, f1);
            assertEquals(2, sudoku.getValue(0, 0));
        } else {
            assertEquals(1, sudoku.getValue(0, 0));
            sudoku.setValue(0, 0, 2);
            assertEquals(2, sudoku.getValue(0, 0));
            SudokuField f1 = new SudokuField();
            f1.setFieldValue(1);
            sudoku.setField(0, 0, f1);
            assertEquals(1, sudoku.getValue(0, 0));
        }
    }

    @Test
    void testVerify() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(solver);
        sudoku.solveGame();
        assertTrue(sudoku.getRow(0).verify());
        assertTrue(sudoku.getColumn(0).verify());
        assertTrue(sudoku.getBox(0, 0).verify());
        if(sudoku.getValue(0, 0) != 1) {
            sudoku.setValue(0, 0, 1);
            assertFalse(sudoku.getRow(0).verify());
        } else {
            sudoku.setValue(0, 0, 2);
            assertFalse(sudoku.getRow(0).verify());
        }

    }

    @Test
    void testGet() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(solver);
        sudoku.solveGame();
        assertEquals(9, sudoku.getRow(0).getRow().size());
        assertEquals(9, sudoku.getColumn(0).getColumn().size());
        assertEquals(9, sudoku.getBox(0, 0).getBox().size());
    }

    @Test
    void testEquals() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(solver);
        sudoku.solveGame();
        SudokuBoard sudoku1 = new SudokuBoard(solver);
        sudoku1.solveGame();
        assertFalse(sudoku.equals(sudoku1));
        assertFalse(sudoku.equals(null));
        assertFalse(sudoku.equals(solver));
        assertTrue(sudoku.equals(sudoku));
        assertFalse(sudoku.getRow(0).equals(sudoku1.getRow(0)));
        assertFalse(sudoku.getRow(0).equals(null));
        assertFalse(sudoku.getRow(0).equals(sudoku1.getColumn(0)));
        assertTrue(sudoku.getRow(0).equals(sudoku.getRow(0)));
        assertTrue(sudoku.getBoard().get(0).equals(sudoku.getBoard().get(0)));
        assertFalse(sudoku.getBoard().get(0).equals(null));
        assertFalse(sudoku.getBoard().get(0).equals(sudoku.getBoard()));
    }

    @Test
    void testToString() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(solver);
        sudoku.solveGame();
        assertEquals(String.valueOf(sudoku), sudoku.toString());
        assertEquals(String.valueOf(sudoku.getRow(0)), sudoku.getRow(0).toString());
    }

    @Test
    void testHashCode() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(solver);
        sudoku.solveGame();
        SudokuBoard sudoku1 = new SudokuBoard(solver);
        sudoku1.solveGame();
        assertNotEquals(sudoku.hashCode(), sudoku1.hashCode());
        assertNotEquals(sudoku.getRow(0).hashCode(), sudoku.getRow(1).hashCode());

        if (sudoku.getValue(0, 0) == 1) {
            sudoku.setValue(0, 0, 2);
            sudoku1.setValue(0, 0, 2);
        } else {
            sudoku.setValue(0, 0, 1);
            sudoku1.setValue(0, 0, 1);
        }

        assertTrue(sudoku.getRow(0).getRow().get(0).equals(sudoku1.getRow(0).getRow().get(0)));
        assertEquals(sudoku.getRow(0).getRow().get(0).hashCode(),
                sudoku1.getRow(0).getRow().get(0).hashCode());

    }

    @Test
    void testRemoveFields() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(solver);
        sudoku.solveGame();
        DifficultyLevel difficultyLevel = DifficultyLevel.HARD;
        difficultyLevel.removeFields(sudoku);
        int sumOfZeros=0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku.getValue(i, j) == 0) {
                    sumOfZeros++;
                }
            }
        }

        assertEquals(sumOfZeros,50);
    }
}