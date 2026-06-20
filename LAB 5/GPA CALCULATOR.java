import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int students = input.nextInt();
        double[][] grades  = new double[students][];
        double[][] credits = new double[students][];
        for (int i = 0; i < students; i++) {
            System.out.print("Enter number of courses for Student " + (i + 1) + ": ");
            int courses = input.nextInt();
            grades[i]  = new double[courses];
            credits[i] = new double[courses];
            System.out.println("Enter grades for Student " + (i + 1) + ":");
            for (int j = 0; j < courses; j++) {
                grades[i][j] = input.nextDouble();
            }
            System.out.println("Enter credits for Student " + (i + 1) + ":");
            for (int j = 0; j < courses; j++) {
                credits[i][j] = input.nextDouble();
            }
        }
        System.out.println();
        for (int i = 0; i < students; i++) {
            double totalWeighted = 0;
            double totalCredits  = 0;
            for (int j = 0; j < grades[i].length; j++) {
                totalWeighted = totalWeighted + (grades[i][j] * credits[i][j]);
                totalCredits  = totalCredits  + credits[i][j];
            }
            double gpa = totalWeighted / totalCredits;
            System.out.println("Student " + (i + 1) + " GPA: " + Math.round(gpa * 100.0) / 100.0);
        }
        input.close();
    }
}