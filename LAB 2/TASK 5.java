import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(" Enter Speed of the vehicle");
        int speed = input.nextInt();
        if(speed<=60){
            System.out.println(" Safe: You are driving within the speed limit");
        }
         else if(speed <=100){
             System.out.println(" Warning: You are approaching speed limit");
        } else if (speed>100){
             System.out.println(" You are fined for crossing speed limit");
        }
    }
}