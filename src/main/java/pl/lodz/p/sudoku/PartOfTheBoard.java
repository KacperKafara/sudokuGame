package pl.lodz.p.sudoku;

import java.util.HashSet;
import java.util.Set;

public class PartOfTheBoard {
    protected SudokuField[] fields = new SudokuField[9];
    
    public boolean verify() {
        Set<Integer> fieldsToVerify = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            fieldsToVerify.add(fields[i].getFieldValue());
        }
        return fieldsToVerify.size() == 9;
    }
}
