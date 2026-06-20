import java.util.Scanner;
public class Main {
    static int[][] multiplyMatrices(int[][] A, int[][] B, int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }
    static void displayMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = 2;
        int[][] A = new int[size][size];
        int[][] B = new int[size][size];
        System.out.println("Enter elements of Matrix A (2x2):");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                A[i][j] = input.nextInt();
            }
        }
        System.out.println("Enter elements of Matrix B (2x2):");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                B[i][j] = input.nextInt();
            }
        }
        System.out.println("Matrix A:");
        displayMatrix(A, size);
        System.out.println("Matrix B:");
        displayMatrix(B, size);
        int[][] product = multiplyMatrices(A, B, size);
        System.out.println("Product Matrix:");
        displayMatrix(product, size);
        input.close();
    }
}