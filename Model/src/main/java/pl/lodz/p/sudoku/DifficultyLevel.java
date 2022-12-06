package pl.lodz.p.sudoku;

import java.sql.SQLOutput;
import java.util.Random;

public class DifficultyLevel {
    protected int numberOfFieldsToRemove;

    public DifficultyLevel(int numberOfFieldsToRemove) {
        this.numberOfFieldsToRemove = numberOfFieldsToRemove;
    }

    public void removeFields(final SudokuBoard board) {
        Random rand = new Random();
        int x = 0;
        int y = 0;
        for (int i = 0; i < numberOfFieldsToRemove; i++) {
            do {
                x = rand.nextInt(9);
                y = rand.nextInt(9);
            } while (board.getValue(x, y) == 0);
            board.setValue(x, y, 0);
        }
    }
}