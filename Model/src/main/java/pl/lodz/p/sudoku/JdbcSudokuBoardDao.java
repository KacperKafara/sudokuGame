package pl.lodz.p.sudoku;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class JdbcSudokuBoardDao implements Dao<SudokuBoard>, AutoCloseable {

    private DataBase dataBase;

    public JdbcSudokuBoardDao() {
        this.dataBase = new DataBase();
        this.dataBase.connect();
    }

    @Override
    public SudokuBoard read() {

        SudokuBoard result = null;
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                try {
//                    result.set(i, j, dataBase.select("SudokuBoard" + tmp, i, j));
//                    //sudokuBoard.set(i, j, db.select("sudokuBoard", i, j));
//                } catch (MyException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        return result;
    }

    @Override
    public void write(SudokuBoard obj) throws FileNotFoundException, MyException {

    }

    @Override
    public void close() {
    }

    @Override
    public void finalize() {}
}
