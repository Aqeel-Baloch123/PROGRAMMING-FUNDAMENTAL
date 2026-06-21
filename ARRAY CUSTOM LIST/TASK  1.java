import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] students = new int[2];
        int count = 0;
        System.out.print("How many student IDs? ");
        int total = input.nextInt();
        for (int i = 0; i < total; i++) {
            if (count == students.length) {
                int[] newArray = new int[students.length * 2];
                for (int j = 0; j < students.length; j++) {
                    newArray[j] = students[j];
                }
                students = newArray;
            }
            System.out.print("Enter Student " + (i + 1) + " ID: ");
            students[count] = input.nextInt();
            count++;
        }
        System.out.println("\nStored Student IDs:");
        for (int i = 0; i < count; i++) {
            System.out.print(students[i] + " ");
        }
        System.out.println();
    }
}