import java.io.*;
import java.util.ArrayList;

public class StudentCollection {
    private final ArrayList<Student> students;

    public StudentCollection() {
        students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void loadStudentsFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 7) {
                    Student student = new Student(details[0], details[1], Integer.parseInt(details[2]),
                            details[3].charAt(0), Integer.parseInt(details[4]),
                            details[5], details[6]);
                    students.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Student Collection:\n");
        for (Student student : students) {
            sb.append(student).append("\n");
        }
        return sb.toString();
    }
}
