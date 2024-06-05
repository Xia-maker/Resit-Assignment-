import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Graduates {
    private final List<Student> students;

    public Graduates(List<Student> students) {
        this.students = students;
    }

    public void printGraduates() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("GraduateStudents.txt"))) {
            writer.write("The graduated students are as follows:\n");
            writer.write("Student ID\tStudent Name\tAge\tGender\tGrade\tYear of Admission\tYear of Graduation\n");
            for (Student student : students) {
                if (Integer.parseInt(student.getYearOfGraduation()) <= 2024) {
                    writer.write(String.format("%s\t%s\t%d\t%c\t%d\t%s\t%s\n", student.getStudentID(), student.getStudentName(),
                            student.getAge(), student.getGender(), student.getGrade(),
                            student.getYearOfAdmission(), student.getYearOfGraduation()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
