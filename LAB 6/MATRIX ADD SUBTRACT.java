import java.util.Scanner;
public class Main {
    static int[][] addMatrices(int[][] A, int[][] B, int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }
    static int[][] subtractMatrices(int[][] A, int[][] B, int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = A[i][j] - B[i][j];
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
        int[][] sum = addMatrices(A, B, size);
        System.out.println("Addition of Matrices (A + B):");
        displayMatrix(sum, size);
        int[][] diff = subtractMatrices(A, B, size);
        System.out.println("Subtraction of Matrices (A - B):");
        displayMatrix(diff, size);
        input.close();
    }
}