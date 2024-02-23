import java.io.*;
import java.util.*;

public class Codsoft_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();
        String filename = "students.dat"; // File to store student data

        // Load data from file if exists
        File file = new File(filename);
        if (file.exists()) {
            system.loadFromFile(filename);
        }

        int choice;
        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Save Data to File");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter student details:");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Grade: ");
                    String grade = scanner.nextLine();

                    Student newStudent = new Student(name, rollNumber, grade);
                    system.addStudent(newStudent);
                    break;
                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int rollToRemove = scanner.nextInt();
                    system.removeStudent(rollToRemove);
                    break;
                case 3:
                    System.out.print("Enter roll number to search: ");
                    int rollToSearch = scanner.nextInt();
                    Student foundStudent = system.searchStudent(rollToSearch);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.println("All Students:");
                    system.displayAllStudents();
                    break;
                case 5:
                    system.saveToFile(filename);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
