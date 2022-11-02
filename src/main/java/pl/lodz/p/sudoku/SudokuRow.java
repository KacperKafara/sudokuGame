package pl.lodz.p.sudoku;

public class SudokuRow extends PartOfTheBoard {

    public SudokuField[] getRow() {
        return fields;
    }

    public void setRow(SudokuField row,int fieldInRow) {
        this.fields[fieldInRow] = row;
    }
}
