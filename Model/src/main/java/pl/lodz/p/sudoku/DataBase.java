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


}
