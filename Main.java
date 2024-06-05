import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentCollection studentCollection = new StudentCollection();
        studentCollection.loadStudentsFromFile("StudentDetails.csv");
        StudentOperation studentOperation = new StudentOperation(studentCollection);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. View all students' details");
            System.out.println("2. Add a new student to the list");
            System.out.println("3. Search for student details");
            System.out.println("4. Update student details");
            System.out.println("5. Delete a student");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println(studentCollection);
                    break;
                case 2:
                    studentOperation.addStudent();
                    break;
                case 3:
                    studentOperation.searchStudentByID();
                    break;
                case 4:
                    studentOperation.updateStudentDetails();
                    break;
                case 5:
                    studentOperation.removeStudent();
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
