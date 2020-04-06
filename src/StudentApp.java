import java.util.Scanner;

/**
 * Proj6.java
 * Zackary Nichol / Friday 3:30PM lab session
 *
 * Calculates the final grade of a student in a class given all student score information and choice assignment point
 * values. Displays student score information to screen.
 */
public class StudentApp {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        Student[] students = new Student[50];

        System.out.print("Enter total points possible for LABS: ");
        int totalLabPoints = Integer.parseInt(scnr.nextLine());
        System.out.print("Enter total points possible for PROJECTS: ");
        int totalProjectPoints = Integer.parseInt(scnr.nextLine());

        for (int i = 0; i < students.length; i++) {
            System.out.print("\nEnter the student's name (firstname lastname): ");
            String studentName = scnr.nextLine();
            System.out.print("Enter the student's WID: ");
            String studentWID = scnr.nextLine();
            System.out.print("\nEnter student's total for all LABS: ");
            double studentLabTotal = Double.parseDouble(scnr.nextLine());
            System.out.print("Enter student's total for all PROJECTS: ");
            double studentProjectTotal = Double.parseDouble(scnr.nextLine());
            System.out.print("Enter student's score for ZYBOOK: ");
            double studentZybookTotal = Double.parseDouble(scnr.nextLine());
            System.out.print("Enter student's total for the 3 CLASS EXAMS: ");
            double studentExamTotal = Double.parseDouble(scnr.nextLine());
            System.out.print("Enter student's score for the FINAL EXAM: ");
            double studentFinalExamTotal = Double.parseDouble(scnr.nextLine());
            System.out.print("\n");

            students[i] = new Student(
                studentName.substring(0, studentName.indexOf(' ')),
                studentName.substring(studentName.indexOf(' ') + 1), studentWID, studentLabTotal, studentProjectTotal,
                studentZybookTotal, studentExamTotal, studentFinalExamTotal, totalLabPoints, totalProjectPoints
            );

            System.out.println(i + 1 + " Student(s) entered so far.");
            System.out.println("Up to 50 students can be entered.");
            System.out.print("Would you like to enter another student? ('Y' or 'N'): ");

            if (!scnr.nextLine().toLowerCase().equals("y")) {
                System.out.print("\n");
                for (Student student : students) {
                    if (student != null) {
                        System.out.println(student);
                        System.out.println("\tPress enter to display next student...");
                        scnr.nextLine();
                    }
                }
                System.out.println("All students displayed..."); break;
            }

            System.out.print("\n");
        }
    }
}
