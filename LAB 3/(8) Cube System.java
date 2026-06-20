import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = input.nextInt();
        System.out.println("Number → Cube");
        for (int i = 1; i <= n; i++) {
            int cube = i * i * i;
            System.out.println(i + " → " + cube);
        }
    }
}