package Baza_danych;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Polaczenie {

    private static final String URL = "jdbc:mysql://localhost:3306/szkola"; // nazwa bazy
    private static final String USER = "Dyrektor";
    private static final String PASSWORD = "Dyrektor123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
