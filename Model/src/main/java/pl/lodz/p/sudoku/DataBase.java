package pl.lodz.p.sudoku;

import java.sql.*;

public class DataBase {

    Connection connect() {
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/sudoku";
        try {
            connection = DriverManager.getConnection(url,"postgres","root");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    void test() throws SQLException {
        String sql = "SELECT * FROM board";
        Connection connection = this.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        System.out.println(resultSet.getString("name"));
    }


}
