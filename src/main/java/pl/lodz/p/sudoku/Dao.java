package pl.lodz.p.sudoku;

public interface Dao<T> {

    SudokuBoard read();

    void write(SudokuBoard obj);
}
