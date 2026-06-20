import java.util.Scanner;
public class Main{
    public static void main(String [] args ) {
        Scanner input = new Scanner(System.in);
        System.out.println(" ENTER  AGE ");
        int age = input.nextInt();
        System.out.println(" Enter Test Score ");
        int score = input.nextInt();
        if(age<5){
            System.out.println(" Too Young for Admission");
        }  if (score<50){
            System.out.println(" Test Score Too Low");
        } if (age>=5 && score>= 50){
            System.out.println(" Admission Approved Succesfully");
        }
    }
}