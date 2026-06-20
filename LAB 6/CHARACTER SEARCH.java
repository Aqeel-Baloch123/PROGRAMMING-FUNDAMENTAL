import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String word = input.nextLine();
        System.out.print("Enter a character to search: ");
        char ch = input.nextLine().charAt(0);
        int index = -1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.out.println("Position of the character = " + index);
        } else {
            System.out.println("Character not found");
        }
        input.close();
    }
}