package pl.lodz.p.sudoku;

public interface Dao<T> {

    T read();

    void write(T obj);
}
