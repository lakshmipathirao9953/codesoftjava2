import java.util.Scanner;

public class Gradecalc {
    public static void main(String[] args) {
        calculateGrades();
    }

    private static void calculateGrades() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Grade Calculator");
        System.out.println("----------------");

        // Input: Take marks obtained in each subject
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        if (numSubjects <= 0) {
            System.out.println("Please enter a valid number of subjects.");
            return;
        }

        int totalMarks = 0;
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in Subject " + i + ": ");
            int marks = scanner.nextInt();

            // Validate marks (assuming marks are out of 100)
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks entered. Marks should be between 0 and 100.");
                return;
            }

            totalMarks += marks;
        }

        // Calculate Total Marks
        System.out.println("\nTotal Marks: " + totalMarks);

        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / numSubjects;
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);

        // Grade Calculation: Assign grades based on the average percentage
        char grade = calculateGrade(averagePercentage);

        // Display Results
        System.out.println("Grade: " + grade);

        // Close the scanner to prevent resource leak
        scanner.close();
    }

    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
