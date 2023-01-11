package pl.lodz.p.sudoku;

import java.util.List;

public class SudokuBox extends PartOfTheBoard implements Cloneable {

    public List<SudokuField> getBox() {
        return fields;
    }

    public void setBox(SudokuField field, int fieldInBox) throws IndexOutOfRangeException {
        if (fieldInBox < 0 || fieldInBox > 8) {
            throw new IndexOutOfRangeException("Invalid box out of range " + fieldInBox);
        }
        this.fields.set(fieldInBox, field);
    }

    @Override
    public SudokuBox clone() throws CloneNotSupportedException {
        SudokuBox cl = new SudokuBox();
        for (int i = 0; i < 9; i++) {
            try {
                cl.setBox(fields.get(i).clone(), i);
            } catch (IndexOutOfRangeException e) {
                throw new RuntimeException(e);
            }
        }
        return cl;
    }
}
