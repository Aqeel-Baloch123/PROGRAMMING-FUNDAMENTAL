import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] matrix = new int[3][3];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = sc.nextInt();
        int[] vector = new int[cols];
        System.out.println("Enter vector elements:");
        for (int i = 0; i < cols; i++)
            vector[i] = sc.nextInt();
        System.out.println("\n--- Scalar Products ---");
        for (int i = 0; i < rows; i++) {
            int scalarProduct = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols; j++) {
                scalarProduct += matrix[i][j] * vector[j];
                sb.append(matrix[i][j]).append("*").append(vector[j]);
                if (j < cols - 1) sb.append(" + ");
            }
            System.out.println("Row " + (i + 1) + " scalar product: " + sb + " = " + scalarProduct);
        }
        sc.close();
    }
}