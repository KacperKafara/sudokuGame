package pl.lodz.p.sudoku;

public class SudokuBox {

    private SudokuField[] box = new SudokuField[9];

    public SudokuField[] getBox() {
        return box;
    }

    public void setBox(SudokuField box,int fieldInBox) {
        this.box[fieldInBox] = box;
    }
}
