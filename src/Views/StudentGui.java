package Views;

import Models.Student;

import javax.swing.*;
import java.awt.event.ActionListener;

public class StudentGui extends JFrame{
    private JPanel panel1;
    private JList<Student> studentList;
    private JPanel studentInput;
    private JLabel labelFirstName;
    private JTextField inputFirstName;
    private JLabel labelLastName;
    private JTextField inputLastName;
    private JLabel labelStudentID;
    private JTextField inputStudentID;
    private JPanel studentAction;
    private JButton buttonAddStudent;
    private JButton buttonDelStudent;
    private JButton buttonClear;

    DefaultListModel<Student> studentData;

    public StudentGui() {
        setContentPane(panel1);
        setSize(500, 500);
        setTitle("YO MAMMAA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        studentData = new DefaultListModel<>();
        studentList.setModel(studentData);
    }

    public String getFirstName () {
        return inputFirstName.getText();
    }
    public String getLastName () {
        return inputLastName.getText();
    }
    public String getStudentID () {
        return inputStudentID.getText();
    }
    public Student getSelectedStudent() {
        return studentList.getSelectedValue();
    }

    public void addStudent(Student student) {
        studentData.addElement(student);
    }

    public void removeStudent(Student student) {
        studentData.removeElement(student);
    }

    public void clearForm() {
        inputFirstName.setText("");
        inputLastName.setText("");
        inputStudentID.setText("");
    }

    public void setAddStudentListener (ActionListener listener) {
        buttonAddStudent.addActionListener(listener);
    }

    public void setRemoveStudentListener (ActionListener listener) {
        buttonDelStudent.addActionListener(listener);
    }

    public void setClearListener (ActionListener listener) {
        buttonClear.addActionListener(listener);
    }

    public void showError(String error) {
        JOptionPane.showMessageDialog(null, error);
    }
}
