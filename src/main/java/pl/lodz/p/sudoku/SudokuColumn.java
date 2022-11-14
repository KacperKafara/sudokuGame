package pl.lodz.p.sudoku;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SudokuColumn extends PartOfTheBoard {

    public List<SudokuField> getColumn() {
        return fields;
    }

    public void setColumn(SudokuField field, int fieldInColumn) {
        this.fields.set(fieldInColumn, field);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }
}
