import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] matrix = new int[3][3];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                matrix[i][j] = input.nextInt();
        int[] vector = new int[3];
        System.out.println("Enter vector elements:");
        for (int i = 0; i < 3; i++)
            vector[i] = input.nextInt();
        System.out.println("--- Scalar Products ---");
            for (int i = 0; i < 3; i++) {
                int scalarProduct = 0;
                for (int j = 0; j < 3; j++) {
                    scalarProduct += matrix[i][j] * vector[j];
                }
                System.out.println("Row " + (i + 1) + " scalar product: " + scalarProduct);
            }

    }
}