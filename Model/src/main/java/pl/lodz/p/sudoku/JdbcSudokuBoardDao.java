package pl.lodz.p.sudoku;

import java.sql.SQLException;

public class JdbcSudokuBoardDao implements Dao<SudokuBoard>, AutoCloseable {

    private final DataBase dataBase;

    public JdbcSudokuBoardDao() {
        this.dataBase = new DataBase();
    }

    @Override
    public SudokuBoard read(String name) throws IndexOutOfRangeException {

        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard result = new SudokuBoard(solver);
        try {
            int boardId = dataBase.selectBoardId(name);
            for (int i = 0;i < 9;i++) {
                for (int j = 0;j < 9;j++) {
                    int value = dataBase.selectValueOfField(boardId,i,j);
                    result.setValue(i,j,value);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void write(SudokuBoard obj, String name) throws MyException {

        try {
            dataBase.insertNewBoardToDatabase(name);
            int boardId = dataBase.selectBoardId(name);

            for (int i = 0;i < 9;i++) {
                for (int j = 0;j < 9;j++) {
                    dataBase.insertNewFieldToDatabase(boardId,i,j,obj.getValue(i,j));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void truncate() throws SQLException {
        dataBase.insertToDatabase("truncate board, field");
    }

    @Override
    public void close() throws SQLException {
        this.dataBase.getConnection().close();
    }
}
