  import java.sql.*;

public class GetInfo {

    public void getInfo() {
        String orderTo  = "SELECT * FROM students"; // SQL query to select all rows from the 'songs' table

        try (
            Connection conn = Database_connection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(orderTo);
        ) {
            System.out.println("ID || Full name || SCCI || iROS || GPA || Year of enrolling || Year of graduation || Financing");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + ";  " + 
                        rs.getString("full_name") + ";  " +
                        rs.getDouble("ssci") + ";  " +
                        rs.getDouble("iros") + ";  " + 
                        rs.getDouble("gpa") + ";  " + 
                        rs.getInt("year_of_enrolling") + ";  " + 
                        rs.getInt("year_of_graduation") +";  " + 
                        rs.getInt("course") + ";  " +
                        rs.getString("financing") + "."
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
