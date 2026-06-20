import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int rows = input.nextInt();
        char[][] arr = new char[rows][];
        for (int i = 0; i < rows; i++) {
            System.out.println("Enter number of elements in row " + (i + 1));
            int col = input.nextInt();
            arr[i] = new char[col];
            System.out.println("Enter elements of row " + (i + 1) + " | s=Start  e=End  o=Obstacle  g=Space");
            for (int j = 0; j < col; j++) {
                arr[i][j] = input.next().charAt(0);
            }
        }
        for (int i = 0; i < rows; i++) {
            int Scount = 0;
            int Gcount = 0;
            int Ocount = 0;
            int Ecount = 0;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 's') {
                    Scount += 1;
                } else if (arr[i][j] == 'o') {
                    Ocount += 1;
                } else if (arr[i][j] == 'g') {
                    Gcount += 1;
                } else if (arr[i][j] == 'e') {
                    Ecount += 1;
                }
            }
            System.out.print("MAP " + (i + 1) + " = ");
            if (Scount == 1 && Ecount == 1) {
                System.out.println("Valid | Obstacles: " + Ocount + " | Open: " + Gcount);
            } else if (Scount > 1 && Ecount > 1) {
                System.out.println("Invalid - Multiple S and E detected");
            } else if (Scount > 1) {
                System.out.println("Invalid - Multiple S detected");
            } else if (Ecount > 1) {
                System.out.println("Invalid - Multiple E detected");
            } else if (Scount == 0) {
                System.out.println("Invalid - Missing start point S");
            } else {
                System.out.println("Invalid - Missing end point E");
            }
        }
        input.close();
    }
}