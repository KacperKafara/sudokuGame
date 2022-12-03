package pl.lodz.p.sudoku;

import java.util.List;

public class SudokuColumn extends PartOfTheBoard implements Cloneable {

    public List<SudokuField> getColumn() {
        return fields;
    }

    public void setColumn(SudokuField field, int fieldInColumn) {
        this.fields.set(fieldInColumn, field);
    }

    @Override
    public SudokuColumn clone() {
        try {
            return (SudokuColumn) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
