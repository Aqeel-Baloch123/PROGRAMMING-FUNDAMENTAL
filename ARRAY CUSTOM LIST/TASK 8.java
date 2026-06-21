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
    public void search(int key) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (list[i] == key) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Mark Found");
        } else {
            System.out.println("Mark Not Found");
        }
    }
    public void update(int index, int newValue) {
        if (index >= 0 && index < size) {
            list[index] = newValue;
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
        ArrayCustomList marks = new ArrayCustomList();
        System.out.print("How many marks? ");
        int total = input.nextInt();
        for (int i = 0; i < total; i++) {
            System.out.print("Enter mark: ");
            int value = input.nextInt();
            marks.add(value);
        }
        System.out.print("Enter mark to search: ");
        int key = input.nextInt();
        marks.search(key);
        System.out.print("Enter index to update: ");
        int index = input.nextInt();
        System.out.print("Enter new mark: ");
        int newMark = input.nextInt();
        marks.update(index, newMark);
        System.out.println("Updated Marks:");
        marks.display();
    }
}