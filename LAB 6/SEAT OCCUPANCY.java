import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] seats = new int[3][];
        seats[0] = new int[3];
        seats[1] = new int[2];
        seats[2] = new int[4];
        String[] classNames = {"Economy", "Business", "First Class"};
        for (int i = 0; i < seats.length; i++) {
            System.out.print("Enter seat occupancy for " + classNames[i] + " (1=Booked, 0=Available): ");
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = input.nextInt();
            }
        }
        System.out.println(" Seat Map:");
        for (int i = 0; i < seats.length; i++) {
            System.out.print(classNames[i] + ": ");
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
        input.close();
    }
}