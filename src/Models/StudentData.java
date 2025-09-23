package Models;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentData {
    private final String db = "jdbc:sqlite:sqlite.db";


    public StudentData() {
        try (Connection conn = DriverManager.getConnection(db)) {
            Statement stmt = conn.createStatement(); //Create Connection

            stmt.execute("""
                    CREATE TABLE IF NOT EXISTS Student(
                        firstName varchar(30),
                        lastName varchar(30),
                        studentID int unique
                    )
                    """);
            stmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void addStudent(Student student) throws SQLException {
            Connection conn = DriverManager.getConnection(db);
            String query = "INSERT INTO Student (firstName, lastName, studentID) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setInt(3, student.getStudentID());

            ps.execute();
            ps.close();
    }

    public void removeStudent(Student student) {
        try (Connection conn = DriverManager.getConnection(db)) {
            String query = "DELETE FROM Student WHERE studentID = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, student.getStudentID());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = null;
        try (Connection conn = DriverManager.getConnection(db)) {
            String query = "SELECT * FROM Student";
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(query); //Capture result from SELECT * (ALL) FROM Student

            students = new ArrayList<Student>();
            while(set.next()) {
                Student s = new Student(
                  set.getString("firstName"),
                  set.getString("lastName"),
                  set.getInt("studentID")
                );
                students.add(s);
            }

            stmt.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return students;
    }
}
