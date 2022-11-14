package pl.lodz.p.sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PartOfTheBoard {
    protected List<SudokuField> fields = Arrays.asList(new SudokuField[9]);
    
    public boolean verify() {
        Set<Integer> fieldsToVerify = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            fieldsToVerify.add(fields.get(i).getFieldValue());
        }
        return fieldsToVerify.size() == 9;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("fields", fields).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PartOfTheBoard that = (PartOfTheBoard) o;

        return new EqualsBuilder()
                .append(fields, that.fields)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(fields)
                .toHashCode();
    }
}
