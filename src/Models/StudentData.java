package Models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentData {
    private final List<Student> students;
    private String filename;

    public StudentData() {
        students = new ArrayList<>();
        filename = "./student.data";
    }

    public void addStudent (Student student) {
        students.add(student);
    }

    public void removeStudent (Student student) {
        students.remove(student);
    }

    public List<Student> getStudents () {
        return students;
    }

    public void saveData () throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
        out.writeObject(students);
    }

    public void loadData() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        List<Student> loaded = (List<Student>) in.readObject();

        students.clear();
        students.addAll(loaded);

    }
}
