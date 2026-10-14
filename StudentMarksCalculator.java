import java.util.Scanner;

public class StudentMarksCalculator {

    static Scanner sc = new Scanner(System.in);

    static String[] subjects = {
            "Java",
            "Python",
            "Mathematics",
            "HTML",
            "Computer Fundamentals"
    };

    static int[] marks = new int[5];

    public static void main(String[] args) {

        System.out.println("===== STUDENT MARKS CALCULATOR =====");

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        inputMarks();

        int total = calculateTotal();

        double percentage = (total / 500.0) * 100;

        boolean pass = checkPass();

        String grade = calculateGrade(percentage, pass);

        displaySubjectResults();

        System.out.println("\n---------- FINAL RESULT ----------");

        System.out.println("Student Name: " + name);

        System.out.println("Total Marks: " + total + " / 500");

        System.out.println("Percentage: " + percentage + "%");

        System.out.println("Result: " + (pass ? "PASS" : "FAIL"));

        System.out.println("Grade: " + grade);

        displayHighestAndLowest();

        sc.close();
    }

    // Method 1: Input marks
    static void inputMarks() {

        for (int i = 0; i < marks.length; i++) {

            while (true) {

                System.out.print(subjects[i] + ": ");

                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    sc.next();
                    continue;
                }

                int input = sc.nextInt();

                if (input >= 0 && input <= 100) {
                    marks[i] = input;
                    break;
                } else {
                    System.out.println(
                            "Invalid marks! Enter marks between 0 and 100.");
                }
            }
        }
    }

    // Method 2: Calculate total
    static int calculateTotal() {

        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total;
    }

    // Method 3: Check pass or fail
    static boolean checkPass() {

        for (int mark : marks) {

            if (mark < 33) {
                return false;
            }
        }

        return true;
    }

    // Method 4: Calculate grade
    static String calculateGrade(double percentage, boolean pass) {

        if (!pass) {
            return "F";
        } else if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 45) {
            return "D";
        } else {
            return "E";
        }
    }

    // Method 5: Display subject-wise results
    static void displaySubjectResults() {

        System.out.println("\n---------- SUBJECT RESULTS ----------");

        for (int i = 0; i < marks.length; i++) {

            String result = marks[i] >= 33 ? "PASS" : "FAIL";

            System.out.printf(
                    "%-23s: %3d  %s%n",
                    subjects[i],
                    marks[i],
                    result);
        }
    }

    // Method 6: Find highest and lowest marks
    static void displayHighestAndLowest() {

        int highest = marks[0];
        int lowest = marks[0];

        int highestIndex = 0;
        int lowestIndex = 0;

        for (int i = 1; i < marks.length; i++) {

            if (marks[i] > highest) {
                highest = marks[i];
                highestIndex = i;
            }

            if (marks[i] < lowest) {
                lowest = marks[i];
                lowestIndex = i;
            }
        }

        System.out.println("\nHighest Marks: "
                + subjects[highestIndex] + " - " + highest);

        System.out.println("Lowest Marks: "
                + subjects[lowestIndex] + " - " + lowest);
    }
}