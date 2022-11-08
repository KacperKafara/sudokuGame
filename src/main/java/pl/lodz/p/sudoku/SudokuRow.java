package pl.lodz.p.sudoku;

import java.util.List;

public class SudokuRow extends PartOfTheBoard {

    public List<SudokuField> getRow() {
        return fields;
    }

    public void setRow(SudokuField row,int fieldInRow) {
        this.fields.set(fieldInRow, row);
    }
}
