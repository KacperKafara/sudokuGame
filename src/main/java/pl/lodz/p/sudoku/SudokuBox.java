package pl.lodz.p.sudoku;

import java.util.List;

public class SudokuBox extends PartOfTheBoard {

    public List<SudokuField> getBox() {
        return fields;
    }

    public void setBox(SudokuField box,int fieldInBox) {
        this.fields.set(fieldInBox, box);
    }
}
