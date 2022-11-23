package pl.lodz.p.sudoku;

import java.io.Serializable;
import java.util.List;

public class SudokuRow extends PartOfTheBoard {

    public List<SudokuField> getRow() {
        return fields;
    }

    public void setRow(SudokuField field, int fieldInRow) {
        this.fields.set(fieldInRow, field);
    }
}
