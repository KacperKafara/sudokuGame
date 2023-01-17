package pl.lodz.p.sudoku;

public class SudokuBoardDaoFactory {

    public Dao<SudokuBoard> createFileSudokuBoardDao(String fileName) {
        FileSudokuBoardDao fileSudokuBoardDao = new FileSudokuBoardDao(fileName);
        return fileSudokuBoardDao;
    }

    public Dao<SudokuBoard> createJdbcSudokuBoardDao() {
        JdbcSudokuBoardDao jdbcSudokuBoardDao = new JdbcSudokuBoardDao();
        return jdbcSudokuBoardDao;
    }
}
