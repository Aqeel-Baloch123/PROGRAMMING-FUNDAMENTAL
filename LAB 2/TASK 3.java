import java.util.Scanner;
public class Main{
    public static void main(String [] args ) {
        Scanner input = new Scanner(System.in);
        System.out.println(" ENTER YOUR AGE ");
        int age = input.nextInt();
        System.out.println(" ENTER MEMBERSHIP FEE ");
        int price = input.nextInt();
        if(age<12){
            System.out.println(" NOT ELIGIBLE FOR MEMBERSHIP");
        } else if (price<500){
            System.out.println(" Insufficient Balance");
        } else if (age>=12 && price >= 500){
            System.out.println(" MEMBERSHIP APPROVED ");
        }
    }
}