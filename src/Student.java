import java.text.DecimalFormat;

/**
 * A student consists only of their name, ID, and test scores.
 */
public class Student {

    private String firstName;
    private String lastName;
    private String WID;
    private double labScore;
    private double projectsScore;
    private double zybooksScore;
    private double examsScore;
    private double finalExamScore;
    private double totalScore;

    private static final double ZYBOOKS_POINTS_TOTAL = 150;
    private static final double EXAMS_POINTS_TOTAL = 150;
    private static final double FINAL_EXAM_POINTS_TOTAL = 100;

    private static final double LAB_WEIGHT = 0.10;
    private static final double PROJECTS_WEIGHT = 0.18;
    private static final double ZYBOOKS_WEIGHT = 0.07;
    private static final double EXAMS_WEIGHT = 0.45;
    private static final double FINAL_EXAM_WEIGHT = 0.20;

    private static final DecimalFormat form = new DecimalFormat("00.0");

    /**
     * Fills the default student with empty values.
     */
    Student() {
        firstName = "no name entered";
        lastName = "no name entered";
        WID = "no WID";
        labScore = 0;
        projectsScore = 0;
        zybooksScore = 0;
        examsScore = 0;
        finalExamScore = 0;
        totalScore = 0;
    }

    /**
     * Creates a new student and assigns all values to given values.
     * @param firstName The first name of the student
     * @param lastName The last name of the student
     * @param WID The WID of the student
     * @param labScore The total lab score of the student
     * @param projectsScore The total projects score of the student
     * @param zybooksScore The total zybooks score of the student
     * @param examsScore The total exams score of the student
     * @param finalExamScore The final exam score of the student
     * @param totalLabPoints The total point value for labs
     * @param totalProjectPoints The total point value for projects
     */
    Student(String firstName, String lastName, String WID, double labScore, double projectsScore,
        double zybooksScore, double examsScore, double finalExamScore, int totalLabPoints,
        int totalProjectPoints
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.WID = WID;
        this.labScore = labScore;
        this.projectsScore = projectsScore;
        this.zybooksScore = zybooksScore;
        this.examsScore = examsScore;
        this.finalExamScore = finalExamScore;
        this.totalScore = calculateOverallAverage(totalLabPoints, totalProjectPoints);
    }

    /**
     * Calculates the total weighted average score of this student
     * @param totalLabPoints The total lab point value
     * @param totalProjectPoints The total project point value
     * @return The totalScore of this student
     */
    private double calculateOverallAverage(int totalLabPoints, int totalProjectPoints) {

        double totalPoints = totalLabPoints + totalProjectPoints +
                ZYBOOKS_POINTS_TOTAL + EXAMS_POINTS_TOTAL + FINAL_EXAM_POINTS_TOTAL;

        double adjustedTotalScore = 0;
        adjustedTotalScore += Double.parseDouble(
                form.format((labScore / totalLabPoints) * (totalPoints * LAB_WEIGHT)));
        adjustedTotalScore += Double.parseDouble(
                form.format((projectsScore / totalProjectPoints) * (totalPoints * PROJECTS_WEIGHT)));
        adjustedTotalScore += Double.parseDouble(
                form.format((zybooksScore / ZYBOOKS_POINTS_TOTAL) * (totalPoints * ZYBOOKS_WEIGHT)));
        adjustedTotalScore += Double.parseDouble(
                form.format((examsScore / EXAMS_POINTS_TOTAL) * (totalPoints * EXAMS_WEIGHT)));
        adjustedTotalScore += Double.parseDouble(
                form.format((finalExamScore / FINAL_EXAM_POINTS_TOTAL) * (totalPoints * FINAL_EXAM_WEIGHT)));

        return (adjustedTotalScore / totalPoints) * 100;
    }

    /**
     * Calculates the letter grade corresponding to the given percent grade
     * @param percentGrade The grade of the student as a percent
     * @return The letter grade corresponding to the percent grade
     */
    private char calculateLetterGrade(double percentGrade) {
        if (percentGrade >= 89.5) return 'A';
        if (percentGrade >= 79.5) return 'B';
        if (percentGrade >= 68.5) return 'C';
        if (percentGrade > 58.5) return 'D';
        return 'F';
    }

    /**
     * @return A string representation of this student
     */
    @Override
    public String toString() {
        return "Student Name: " + lastName + ", " + firstName + "\n" +
                "WID: " + WID + "\n" +
                "Overall %: " + form.format(totalScore) + "%\n" +
                "Final Grade: " + calculateLetterGrade(totalScore);
    }
}
