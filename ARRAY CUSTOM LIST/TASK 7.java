import java.util.Scanner;
class ArrayCustomList {
    private int[] list;
    private int size;
    ArrayCustomList() {
        list = new int[2];
        size = 0;
    }
    public void add(int value) {
        if (size == list.length) {
            int[] newArray = new int[list.length * 2];
            for (int j = 0; j < size; j++) {
                newArray[j] = list[j];
            }
            list = newArray;
        }
        list[size] = value;
        size++;
    }
    public void access(int index) {
        if (index >= 0 && index < size) {
            System.out.println("Seat Number at index " + index + " = " + list[index]);
        } else {
            System.out.println("Invalid index!");
        }
    }
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayCustomList seats = new ArrayCustomList();
        seats.add(12);
        seats.add(15);
        seats.add(18);
        seats.add(20);
        seats.add(25);
        System.out.println("Booked Seat Numbers:");
        seats.display();
        System.out.print("Enter index to access seat number: ");
        int index = input.nextInt();
        seats.access(index);
    }
}