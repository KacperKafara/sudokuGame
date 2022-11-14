package pl.lodz.p.sudoku;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SudokuRow extends PartOfTheBoard {

    public List<SudokuField> getRow() {
        return fields;
    }

    public void setRow(SudokuField field, int fieldInRow) {
        this.fields.set(fieldInRow, field);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }
}
