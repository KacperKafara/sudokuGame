package pl.lodz.p.sudoku;

import java.util.List;

public class SudokuColumn extends PartOfTheBoard {

    public List<SudokuField> getColumn() {
        return fields;
    }

    public void setColumn(SudokuField field, int fieldInColumn) {
        this.fields.set(fieldInColumn, field);
    }
}
