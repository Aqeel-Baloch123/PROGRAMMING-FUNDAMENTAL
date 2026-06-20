import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            System.out.print("Enter number of elements in Row " + (i + 1) + ": ");
            int cols = input.nextInt();
            matrix[i] = new int[cols];
            System.out.print("Enter elements of Row " + (i + 1) + ": ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        int totalScore = 0;
        for (int i = 0; i < matrix.length; i++) {
            int first = matrix[i][0];
            int last  = matrix[i][matrix[i].length - 1];
            totalScore += first + last;
        }
        System.out.println("Total Score: " + totalScore);
        input.close();
    }
}