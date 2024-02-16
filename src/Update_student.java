import java.sql.*;

public class Update_student {

    CalcGPA calc = new CalcGPA();

    public void updateStudent(int id, double ssci, double iros, int course, String financing){
        String orderTo  = "UPDATE students SET ssci = ?, iros = ?, course = ?, financing = ? WHERE id = " + id;

            try (
                Connection conn = Database_connection.connect();
                PreparedStatement pstmt = conn.prepareStatement(orderTo)
              ) {
                pstmt.setDouble(1, ssci);
                pstmt.setDouble(2, iros);
                pstmt.setInt(3, course);
                pstmt.setString(4, financing);
                pstmt.executeUpdate();

                calc.calcGPA(id);
                
                System.out.println("Student with ID: " + id + " successfully updated!");
              } catch (Exception e) {
                System.out.println(e.getMessage());
              }
    }
}
