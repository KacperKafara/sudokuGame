package pl.lodz.p.sudoku;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CloneTest {

    @Test
    void cloneFieldTest() {
        SudokuField f1 = new SudokuField();
        f1.setFieldValue(1);
        SudokuField f2 = f1.clone();
        assertEquals(f1.getFieldValue(), f2.getFieldValue());
        f2.setFieldValue(3);
        assertNotEquals(f1.getFieldValue(), f2.getFieldValue());
    }

    @Test
    void cloneRowTest() {
        SudokuRow row1 = new SudokuRow();
        for (int i = 1; i < 10; i++) {
            SudokuField field = new SudokuField();
            field.setFieldValue(i);
            row1.setRow(field, i - 1);
        }
        SudokuRow row2 = row1.clone();
        assertTrue(row1.equals(row2));
        SudokuField field = new SudokuField();
        field.setFieldValue(3);
        row2.setRow(field, 7);
        assertFalse(row1.equals(row2));
    }

    @Test
    void cloneColumnTest() {
        SudokuColumn row1 = new SudokuColumn();
        for (int i = 1; i < 10; i++) {
            SudokuField field = new SudokuField();
            field.setFieldValue(i);
            row1.setColumn(field, i - 1);
        }
        SudokuColumn row2 = row1.clone();
        assertTrue(row1.equals(row2));
        SudokuField field = new SudokuField();
        field.setFieldValue(3);
        row2.setColumn(field, 7);
        assertFalse(row1.equals(row2));
    }

    @Test
    void cloneBoxTest() {
        SudokuBox row1 = new SudokuBox();
        for (int i = 1; i < 10; i++) {
            SudokuField field = new SudokuField();
            field.setFieldValue(i);
            row1.setBox(field, i - 1);
        }
        SudokuBox row2 = row1.clone();
        assertTrue(row1.equals(row2));
        SudokuField field = new SudokuField();
        field.setFieldValue(3);
        row2.setBox(field, 7);
        assertFalse(row1.equals(row2));
    }

    @Test
    void cloneBoardTest() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(solver);
        SudokuBoard sudoku1 = sudoku.clone();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertTrue(sudoku.getField(i, j).equals(sudoku1.getField(i, j)));
            }
        }
        SudokuField field = new SudokuField();
        field.setFieldValue(1);
        sudoku1.setField(0, 0, field);
        assertFalse(sudoku.getField(0, 0).equals(sudoku1.getField(0, 0)));
    }
}
