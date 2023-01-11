package pl.lodz.p.sudoku;

import java.util.List;

public class SudokuRow extends PartOfTheBoard implements Cloneable {

    public List<SudokuField> getRow() {
        return fields;
    }

    public void setRow(SudokuField field, int fieldInRow) {
        this.fields.set(fieldInRow, field);
    }

    @Override
    public SudokuRow clone() throws CloneNotSupportedException {
        SudokuRow cl = new SudokuRow();
        for (int i = 0; i < 9; i++) {
            cl.setRow(fields.get(i).clone(), i);
        }
        return cl;
    }
}
