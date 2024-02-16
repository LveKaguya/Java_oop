import java.sql.*;
public class Creation {

public void createStudent(  
String full_name,
double ssci,
double iros,
int year_of_enrolling,
int course,
String financing
) {
    String orderTo  =
    "INSERT INTO students (full_name, ssci, iros, year_of_enrolling, year_of_graduation, course, financing) VALUES (?, ?, ?, ?, ?, ?, ?)";

  try (
    Connection conn = Database_connection.connect();
    PreparedStatement pstmt = conn.prepareStatement(orderTo)
  ) {
    pstmt.setString(1, full_name);
    pstmt.setDouble(2, ssci);
    pstmt.setDouble(3, iros);
    pstmt.setInt(4, year_of_enrolling);
    pstmt.setInt(5, year_of_enrolling + 3);
    pstmt.setInt(6, course);
    pstmt.setString(7, financing);
    pstmt.executeUpdate();
    
    System.out.println("Student " + full_name + "successfully added!");
  } catch (Exception e) {
    System.out.println(e.getMessage());
  }
}
}

