package pl.lodz.p.sudoku;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SudokuBox extends PartOfTheBoard {

    public List<SudokuField> getBox() {
        return fields;
    }

    public void setBox(SudokuField field, int fieldInBox) {
        this.fields.set(fieldInBox, field);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }
}
