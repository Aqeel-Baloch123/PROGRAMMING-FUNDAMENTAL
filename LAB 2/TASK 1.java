import java.util.Scanner;
public class Main{
    public static void main(String [] args ){
        Scanner input = new Scanner(System.in);
        System.out.println(" Enter number of units consumed");
        int units = input.nextInt();
        double bill = 0;
        if(units<=50){
           bill = units * .50;
        }else if (units>50 && units<=150){
            bill = (50*.50)+(units-50)*.75;
        } else {
            bill = (units-150)*1;
        }
        System.out.println(" TOTAL WATER BILL = " + bill);
    }
}