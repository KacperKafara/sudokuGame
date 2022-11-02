package pl.lodz.p.sudoku;

public class SudokuColumn extends PartOfTheBoard {

    public SudokuField[] getColumn() {
        return fields;
    }

    public void setColumn(SudokuField column,int fieldInColumn) {
        this.fields[fieldInColumn] = column;
    }
}
