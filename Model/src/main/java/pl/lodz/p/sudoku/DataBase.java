package pl.lodz.p.sudoku;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

    private Connection connection = null;

    public Connection getConnection() {
        return connection;
    }

    public DataBase() {
        try {
            Connection connection = this.connect();
            if (connection != null) {
                this.connection = connection;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection connect() {
        if (this.connection == null) {
            Connection connection = null;
            String url = "jdbc:postgresql://localhost:5432/sudoku";
            try {
                connection = DriverManager.getConnection(url, "postgres", "root");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return connection;
        } else {
            return this.connection;
        }
    }

    public ResultSet selectFromDatabase(String query) throws SQLException {

        Connection connection = this.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }

    public void insertToDatabase(String query) throws SQLException {
        Connection connection = this.connect();
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public int selectBoardId(String name) throws SQLException {
        String sql = "SELECT boardid FROM board WHERE name = '" + name + "';";
        try (ResultSet resultSet = selectFromDatabase(sql)) {
            resultSet.next();
            return resultSet.getInt(1);
        }
    }

    public boolean isBoardOfNameInBase(String name) throws SQLException {
        String sql = "SELECT name FROM board WHERE name = '" + name + "';";
        ResultSet resultSet = selectFromDatabase(sql);
        if (!resultSet.isBeforeFirst()) {
            return false;
        } else {
            return true;
        }
    }

    public int selectValueOfField(int boardId, int x, int y) throws SQLException {
        String sql = "SELECT value FROM field WHERE boardId = 'var' AND x = 'var' AND y = 'var';";
        sql = sql.replaceFirst("var", String.valueOf(boardId));
        sql = sql.replaceFirst("var", String.valueOf(x));
        sql = sql.replaceFirst("var", String.valueOf(y));
        try (ResultSet resultSet = selectFromDatabase(sql)) {
            resultSet.next();
            return resultSet.getInt(1);
        }
    }

    public void insertNewBoardToDatabase(String name) throws SQLException {
        insertToDatabase("INSERT INTO board (name) VALUES ('" + name + "');");
    }

    public void insertNewFieldToDatabase(int boardId, int x, int y, int value) throws SQLException {
        String sql = "INSERT INTO field (boardid,x,y,value) VALUES ('var','var','var','var');";
        sql = sql.replaceFirst("var", String.valueOf(boardId));
        sql = sql.replaceFirst("var", String.valueOf(x));
        sql = sql.replaceFirst("var", String.valueOf(y));
        sql = sql.replaceFirst("var", String.valueOf(value));
        insertToDatabase(sql);
    }
}
