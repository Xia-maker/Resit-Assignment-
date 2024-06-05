import java.util.*;

public class StudentOperation {
    private final StudentCollection studentCollection;

    public StudentOperation(StudentCollection studentCollection) {
        this.studentCollection = studentCollection;
    }

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Gender (M/F): ");
        char gender = scanner.next().charAt(0);
        System.out.print("Enter Grade: ");
        int grade = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        System.out.print("Enter Year of Admission: ");
        String admission = scanner.nextLine();
        System.out.print("Enter Year of Graduation: ");
        String graduation = scanner.nextLine();

        Student newStudent = new Student(id, name, age, gender, grade, admission, graduation);
        studentCollection.getStudents().add(newStudent);
    }

    public void removeStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student ID to remove: ");
        String id = scanner.nextLine();

        boolean removed = studentCollection.getStudents().removeIf(student -> student.getStudentID().equals(id));
        if (!removed) {
            System.out.println("Student ID not found.");
        }
    }

    public void updateStudentDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine();

        for (Student student : studentCollection.getStudents()) {
            if (student.getStudentID().equals(id)) {
                System.out.print("Enter new name (leave blank to keep current name): ");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()) student.setStudentName(newName);

                System.out.print("Enter new age (0 to keep current age): ");
                int newAge = scanner.nextInt();
                if (newAge != 0) student.setAge(newAge);

                System.out.print("Enter new gender (M/F, leave blank to keep current gender): ");
                scanner.nextLine(); // consume the newline
                String newGender = scanner.nextLine();
                if (!newGender.isEmpty()) student.setGender(newGender.charAt(0));

                System.out.print("Enter new grade (0 to keep current grade): ");
                int newGrade = scanner.nextInt();
                if (newGrade != 0) student.setGrade(newGrade);
                scanner.nextLine(); // consume the newline

                System.out.print("Enter new year of admission (leave blank to keep current year): ");
                String newAdmission = scanner.nextLine();
                if (!newAdmission.isEmpty()) student.setYearOfAdmission(newAdmission);

                System.out.print("Enter new year of graduation (leave blank to keep current year): ");
                String newGraduation = scanner.nextLine();
                if (!newGraduation.isEmpty()) student.setYearOfGraduation(newGraduation);

                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    public void searchStudentByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine();

        for (Student student : studentCollection.getStudents()) {
            if (student.getStudentID().equals(id)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student ID not found.");
    }
}
