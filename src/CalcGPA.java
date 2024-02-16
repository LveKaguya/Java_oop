import java.sql.*;

public class CalcGPA { // Class for calculating student's GPA by inputed ID.
    public void calcGPA(int id) {
        String orderTo = "SELECT iros, ssci FROM students WHERE id = " + id;

        try (
                Connection conn = Database_connection.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(orderTo);
        ) {
            while (rs.next()) {
                double iros = rs.getDouble("iros");
                double ssci = rs.getDouble("ssci");
                double calculatedGPA = calculateGPA(iros, ssci);
                insertGPA(id, calculatedGPA);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private double calculateGPA(double iros, double ssci) { // Calculate the GPA
        double ssciGradePoint = ssci;
       
        double irosGradePoint = iros;
    
        // Calculate GPA based on the average of SSCI and IROS grade points
        double totalGradePoints = ssciGradePoint + irosGradePoint;
        double calcgpa = totalGradePoints / 2.0; // Max gpa must be 4.0.
        return calcgpa;
    }

    private void insertGPA(int id, double gpa) {
        String orderTo = "UPDATE students SET gpa = ? WHERE ID = ?";

        try (
                Connection conn = Database_connection.connect();
                PreparedStatement pstmt = conn.prepareStatement(orderTo)
        ) {
            pstmt.setDouble(1, gpa);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("GPA calculated and updated successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}