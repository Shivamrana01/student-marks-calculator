import java.util.Scanner;

public class StudentMarksCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Heading
        System.out.println("===== STUDENT MARKS CALCULATOR =====");

        // Student name
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        // Array to store marks
        int[] marks = new int[5];

        String[] subjects = {
            "Java",
            "Python",
            "Mathematics",
            "HTML",
            "Computer Fundamentals"
        };

        int total = 0;

        // Input marks
        System.out.println("\nEnter marks out of 100:");

        for (int i = 0; i < marks.length; i++) {

            System.out.print(subjects[i] + ": ");
            marks[i] = sc.nextInt();

            // Validate marks
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks! Enter marks between 0 and 100.");
                sc.close();
                return;
            }

            total = total + marks[i];
        }

        // Calculate percentage
        double percentage = (total / 500.0) * 100;

        // Check pass or fail
        boolean pass = true;

        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 33) {
                pass = false;
                break;
            }
        }

        // Calculate grade
        String grade;

        if (!pass) {
            grade = "F";
        } else if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 45) {
            grade = "D";
        } else {
            grade = "E";
        }

        // Display result
        System.out.println("\n========== RESULT ==========");

        System.out.println("Student Name: " + name);

        System.out.println("Total Marks: " + total + " / 500");

        System.out.println("Percentage: " + percentage + "%");

        if (pass) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }

        System.out.println("Grade: " + grade);

        System.out.println("============================");

        sc.close();
    }
}