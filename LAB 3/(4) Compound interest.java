import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter principal amount: ");
        double P = input.nextDouble();
        System.out.print("Enter annual interest rate (in %): ");
        double r = input.nextDouble() / 100;
        System.out.print("Enter number of years: ");
        int years = input.nextInt();
        System.out.println("Year    Amount");
        for (int t = 1; t <= years; t++) {
            double amount = P * Math.pow(1 + r, t);
            System.out.printf("%d\t%.2f%n", t, amount);
        }
    }
}