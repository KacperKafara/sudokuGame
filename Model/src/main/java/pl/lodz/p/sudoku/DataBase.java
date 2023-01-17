package pl.lodz.p.sudoku;

import java.sql.*;

public class DataBase {

    public Connection connect() {
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/sudoku";
        try {
            connection = DriverManager.getConnection(url,"postgres","root");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
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
        ResultSet resultSet = selectFromDatabase("SELECT boardid FROM board WHERE name = '"+name+"';");
        resultSet.next();
        return  resultSet.getInt(1);
    }

    public int selectValueOfField(int boardId, int x, int y) throws SQLException {
        ResultSet resultSet = selectFromDatabase("SELECT value FROM field WHERE boardId = '"+boardId+"' AND x = '"+x+"' AND y = '"+y+"';");
        resultSet.next();
        return  resultSet.getInt(1);
    }

    public void insertNewBoardToDatabase(String name) throws SQLException {
        insertToDatabase("INSERT INTO board (name) VALUES ('"+name+"');");
    }

    public void insertNewFieldToDatabase(int boardId, int x, int y, int value) throws SQLException {
        insertToDatabase("INSERT INTO field (boardid,x,y,value) VALUES ('"+boardId+"','"+x+"','"+y+"','"+value+"');");
    }
}
