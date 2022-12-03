package pl.lodz.p.sudoku;

import java.util.List;

public class SudokuBox extends PartOfTheBoard implements Cloneable {

    public List<SudokuField> getBox() {
        return fields;
    }

    public void setBox(SudokuField field, int fieldInBox) {
        this.fields.set(fieldInBox, field);
    }

    @Override
    public SudokuBox clone() {
        try {
            return (SudokuBox) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
