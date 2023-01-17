package pl.lodz.p.sudoku;

import java.io.FileNotFoundException;

public interface Dao<T> {

    T read(String name) throws FileNotFoundException, MyException;

    void write(T obj, String name) throws FileNotFoundException, MyException;
}
