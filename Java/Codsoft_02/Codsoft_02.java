import java.util.Scanner;

public class Codsoft_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Take marks obtained in each subject
        System.out.println("Enter marks obtained in each subject (out of 100):");
        int totalMarks = 0;
        int numSubjects;
        double averagePercentage;

        System.out.print("Enter the number of subjects: ");
        numSubjects = scanner.nextInt();

        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            totalMarks += scanner.nextInt();
        }

        // Calculate Total Marks
        System.out.println("Total Marks: " + totalMarks);

        // Calculate Average Percentage
        averagePercentage = (double) totalMarks / numSubjects;
        System.out.println("Average Percentage: " + averagePercentage);

        // Grade Calculation
        char grade = calculateGrade(averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    public static char calculateGrade(double percentage) {
        if (percentage >= 90) {
            return 'A';
        } else if (percentage >= 80) {
            return 'B';
        } else if (percentage >= 70) {
            return 'C';
        } else if (percentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
