package pl.lodz.p.sudoku;

import java.io.FileNotFoundException;

public interface Dao<T> {

    T read() throws FileNotFoundException, MyException;

    void write(T obj) throws FileNotFoundException, MyException;
}
