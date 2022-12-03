package pl.lodz.p.sudoku;

import java.util.List;

public class SudokuRow extends PartOfTheBoard implements Cloneable {

    public List<SudokuField> getRow() {
        return fields;
    }

    public void setRow(SudokuField field, int fieldInRow) {
        this.fields.set(fieldInRow, field);
    }

    @Override
    public SudokuRow clone() {
        try {
            return (SudokuRow) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
