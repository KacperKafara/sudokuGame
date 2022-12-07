package pl.lodz.p.sudoku;

import java.util.List;

public class SudokuColumn extends PartOfTheBoard implements Cloneable {

    public List<SudokuField> getColumn() {
        return fields;
    }

    public void setColumn(SudokuField field, int fieldInColumn) {
        this.fields.set(fieldInColumn, field);
    }

    @Override
    public SudokuColumn clone() {
        SudokuColumn cl = new SudokuColumn();
        for (int i = 0; i < 9; i++) {
            cl.setColumn(fields.get(i).clone(), i);
        }
        return cl;
    }
}
