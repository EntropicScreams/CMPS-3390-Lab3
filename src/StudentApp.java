import Controllers.StudentController;
import Models.StudentData;
import Views.StudentGui;

public class StudentApp {
    public static void main(String[] args) {
        StudentGui view = new StudentGui();
        StudentData model = new StudentData();

        new StudentController(model, view);

        view.setVisible(true);
    }
}
