package pl.lodz.p.sudoku;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompareTest {

    @Test
    void compareTest() {
        SudokuField field1 = new SudokuField();
        field1.setFieldValue(1);
        SudokuField field2 = new SudokuField();
        field2.setFieldValue(2);
        SudokuField field3 = new SudokuField();
        field3.setFieldValue(3);

        assertEquals(-1, field1.compareTo(field2));
        assertEquals(1, field3.compareTo(field1));
        assertEquals(0, field1.compareTo(field1));

        assertThrows(NullPointerException.class, () -> field1.compareTo(null));
    }
}
