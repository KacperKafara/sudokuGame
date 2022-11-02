package pl.lodz.p.sudoku;

public class SudokuBox extends PartOfTheBoard {

    public SudokuField[] getBox() {
        return fields;
    }

    public void setBox(SudokuField box,int fieldInBox) {
        this.fields[fieldInBox] = box;
    }
}
