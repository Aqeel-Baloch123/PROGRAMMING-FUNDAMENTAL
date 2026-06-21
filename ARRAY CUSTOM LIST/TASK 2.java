import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] employ = new int[2];
        int count = 0;
        System.out.println(" How many ids you want to enter");
        int total = input.nextInt();
        for (int i = 0; i < total; i++) {
            if (count == employ.length) {
                int[] newArray = new int[employ.length * 2];
                for (int j = 0; j < employ.length; j++) {
                    newArray[j] = employ[j];
                }
                employ = newArray;
            }
            System.out.println(" Enter id of Employ " + (i + 1));
            employ[count] = input.nextInt();
            count++;
        }
        System.out.println(" Employ stored ids");
        for(int i=0; i<employ.length;i++){
            System.out.print(employ[i]);
            System.out.print(" ");
        }
        System.out.println("");
        System.out.println(" Total employyes stored = " + count);
        System.out.println(" Array size = " + employ.length);
    }
}