package pl.lodz.p.sudoku;

public class SudokuRow {

    private SudokuField[] row;

    public SudokuField[] getRow() {
        return row;
    }

    public void setRow(SudokuField row,int fieldInRow) {
        this.row[fieldInRow] = row;
    }
}
