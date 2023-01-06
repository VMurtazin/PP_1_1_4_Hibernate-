package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    //private static final String DB_DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb1";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "rootroot";


    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            //System.out.println("connection ok");
        } catch (SQLException e) {
            System.out.println("connection Nok");
            e.printStackTrace();
        }
        return connection;
    }
}
