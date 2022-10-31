package pl.lodz.p.sudoku;

public class SudokuField {

    private int value;

    public int getFieldValue() {
        return value;
    }

    public void setFieldValue(int value) {
        //weryfikacja
        this.value = value;
    }
}
