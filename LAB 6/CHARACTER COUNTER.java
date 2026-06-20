import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String word = input.nextLine();
        int letters=0;
        for(int i=0; i<word.length(); i++){
            System.out.println(word.charAt(i));
            letters+=1;
        }
        System.out.println(" Total Characters = " + letters);
        input.close();
    }
}