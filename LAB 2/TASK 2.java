import java.util.Scanner;
public class Main{
    public static void main(String [] args ) {
        Scanner input = new Scanner(System.in);
        System.out.println(" ENTER YOUR AGE ");
        int age = input.nextInt();
        System.out.println(" ENTER TICKET PRICE ");
        int price = input.nextInt();
        if(age<18){
            System.out.println(" NOT ELIGIBLE TO WATCH THIS MOVIE");
        } else if (price<700){
            System.out.println(" Insufficient Balance");
        } else if (age>=18 && price >= 700){
            System.out.println(" Ticket Booked Succesfully");
        }
    }
}