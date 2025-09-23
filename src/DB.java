import Models.Student;

import java.sql.*;

public class DB {
    public static void main(String[] args) {
        String db = "jdbc:sqlite:sqlite.db";

        try (Connection conn = DriverManager.getConnection(db)) {
            Statement stmt = conn.createStatement(); //Create Connection

            stmt.execute("""
                    CREATE TABLE IF NOT EXISTS Student(
                        firstName varchar(30),
                        lastName varchar(30),
                        studentID int
                    )
                    """);
            stmt.close();

            Student s = new Student("paul", "wroyer", 12345);

            String query = "INSERT INTO Student (firstName, lastName, studentID) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, s.getFirstName());
            ps.setString(2, s.getLastName());
            ps.setInt(3, s.getStudentID());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

}
