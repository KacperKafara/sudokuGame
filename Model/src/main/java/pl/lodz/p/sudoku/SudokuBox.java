package pl.lodz.p.sudoku;

import java.util.List;

public class SudokuBox extends PartOfTheBoard implements Cloneable {

    public List<SudokuField> getBox() {
        return fields;
    }

    public void setBox(SudokuField field, int fieldInBox) {
        this.fields.set(fieldInBox, field);
    }

    @Override
    public SudokuBox clone() {
        SudokuBox cl = new SudokuBox();
        for (int i = 0; i < 9; i++) {
            cl.setBox(fields.get(i).clone(), i);
        }
        return cl;
    }
}
