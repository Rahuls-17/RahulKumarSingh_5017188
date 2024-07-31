public class MVCPatternTest {
    public static void main(String[] args) {
        Student model = new Student();
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.setStudentName("Rahul");
        controller.setStudentId(1);
        controller.setStudentGrade("A");

        controller.updateView();
    }
}
