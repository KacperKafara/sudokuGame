package pl.lodz.p.sudoku;

import java.util.List;

public class SudokuRow extends PartOfTheBoard implements Cloneable {

    public List<SudokuField> getRow() {
        return fields;
    }

    public void setRow(SudokuField field, int fieldInRow) throws IndexOutOfRangeException {
        if (fieldInRow < 0 || fieldInRow > 8) {
            throw new IndexOutOfRangeException("Invalid row out of range " + fieldInRow);
        }
        this.fields.set(fieldInRow, field);
    }

    @Override
    public SudokuRow clone() throws CloneNotSupportedException {
        SudokuRow cl = new SudokuRow();
        for (int i = 0; i < 9; i++) {
            try {
                cl.setRow(fields.get(i).clone(), i);
            } catch (IndexOutOfRangeException e) {
                throw new RuntimeException(e);
            }
        }
        return cl;
    }
}
