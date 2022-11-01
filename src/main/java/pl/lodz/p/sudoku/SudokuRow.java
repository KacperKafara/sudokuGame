package pl.lodz.p.sudoku;

public class SudokuRow {

    private SudokuField[] row = new SudokuField[9];

    public SudokuField[] getRow() {
        return row;
    }

    public void setRow(SudokuField row,int fieldInRow) {
        this.row[fieldInRow] = row;
    }
}
