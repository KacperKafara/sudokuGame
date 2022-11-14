package pl.lodz.p.sudoku;

import java.util.List;

public class SudokuBox extends PartOfTheBoard {

    public List<SudokuField> getBox() {
        return fields;
    }

    public void setBox(SudokuField field, int fieldInBox) {
        this.fields.set(fieldInBox, field);
    }
}
