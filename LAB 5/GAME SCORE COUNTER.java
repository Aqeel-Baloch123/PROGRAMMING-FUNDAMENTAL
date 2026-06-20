import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(" Enter number of rows");
        int rows = input.nextInt();
        int[][] matrix = new int[rows][];
        for(int i=0 ; i<rows; i++){
            System.out.println(" Enter number of elements of row " + (i+1));
            int col=input.nextInt();
            matrix[i] = new int[col];
            for(int j=0; j<col;j++){
                 matrix [i][j]= input.nextInt();
            }
        }
        int totalScore = 0;

        for (int i = 0; i < rows; i++) {
            int first = matrix[i][0];
            int last = matrix[i][matrix[i].length - 1];
            totalScore += first + last;
        }
        System.out.println("Total Score: " + totalScore);
    }
}