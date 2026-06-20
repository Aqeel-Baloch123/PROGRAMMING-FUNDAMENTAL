import java.util.Scanner;
public class Main{
    public static void main(String [] args ) {
        Scanner input = new Scanner(System.in);
        System.out.println(" Enter recharge Amount");
        int amount = input.nextInt();
        double bonus=0;
        double total=0;
        if(amount<100){
          bonus=0;
          total=amount+bonus;
        } if(amount>99&&amount<201){
            bonus=amount*0.05;
            total=amount+bonus;
        }
        if(amount>200){
            bonus=amount*.1;
            total=bonus+amount;
        }
        System.out.println(" Recharge Amount = " + amount);
        System.out.println(" bonus = " + bonus);
        System.out.println(" Total Balance = " + total);
    }
}