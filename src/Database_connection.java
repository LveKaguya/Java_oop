

import java.sql.*; // Include java sql package

public class Database_connection{

    private static final String URL = "jdbc:postgresql://localhost/students_management_system";
    private static final String USER = "postgres";
    private static final String PASSWORD = "ADSR1337a";

    public static Connection connect() {
        Connection conn = null;
        try {
          conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
        return conn;
      }
}
  