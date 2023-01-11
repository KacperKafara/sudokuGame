package pl.lodz.p.sudoku;

import java.util.List;

public class SudokuColumn extends PartOfTheBoard implements Cloneable {

    public List<SudokuField> getColumn() {
        return fields;
    }

    public void setColumn(SudokuField field, int fieldInColumn) throws IndexOutOfRangeException {
        if (fieldInColumn < 0 || fieldInColumn > 8) {
            throw new IndexOutOfRangeException("Invalid column out of range " + fieldInColumn);
        }
        this.fields.set(fieldInColumn, field);
    }

    @Override
    public SudokuColumn clone() throws CloneNotSupportedException {
        SudokuColumn cl = new SudokuColumn();
        for (int i = 0; i < 9; i++) {
            try {
                cl.setColumn(fields.get(i).clone(), i);
            } catch (IndexOutOfRangeException e) {
                throw new RuntimeException(e);
            }
        }
        return cl;
    }
}
