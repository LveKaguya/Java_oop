/**
 * Delete_student
 */
import java.sql.*;
public class Delete_student {
    public void deleteStudent(int id) {
        String orderTo  = "DELETE FROM students WHERE id = ?";
    
        try (
          Connection conn = Database_connection.connect();
          PreparedStatement pstmt = conn.prepareStatement(orderTo)
        ) {
          pstmt.setInt(1, id);
    
          int affectedRows = pstmt.executeUpdate();
          if (affectedRows > 0) {
            System.out.println("Student has been deleted from the database");
          } else {
            System.out.println("Student with ID:" + id + " doesn't exist in this database.");
          }
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      }
    
}