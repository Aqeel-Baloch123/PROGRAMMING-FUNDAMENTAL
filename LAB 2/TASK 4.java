import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter amount in USD");
        double usd = input.nextDouble();
        double pkr = usd * 278.5;
        double eur = usd * 0.92;
        double gbp = usd * 0.8;
        System.out.println("USD Amount : " + usd);
        System.out.println("In PKR : " + (int) pkr + " Approx");
        System.out.println("In Euro : " + (int)eur + " Approx");
        System.out.println("In GBP : " + (int)gbp + " Approx");
    }
}