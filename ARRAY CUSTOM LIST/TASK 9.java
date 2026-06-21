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
            System.out.println("Array is Full!");
            System.out.println("Regrowing Array...");
            int[] newArray = new int[list.length * 2];
            for (int j = 0; j < size; j++) {
                newArray[j] = list[j];
            }
            list = newArray;
            System.out.println("New Array Capacity: " + list.length);
        }
        System.out.println("Inserting Box ID: " + value);
        list[size] = value;
        size++;
    }
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
    public int getCapacity() {
        return list.length;
    }
    public int getSize() {
        return size;
    }
}
public class Main {
    public static void main(String[] args) {
        ArrayCustomList boxes = new ArrayCustomList();
        System.out.println("Initial Array Capacity: " + boxes.getCapacity());
        boxes.add(101);
        boxes.add(102);
        boxes.add(103);
        boxes.add(104);
        boxes.add(105);
        System.out.println("\nFinal Box IDs Stored:");
        boxes.display();
        System.out.println("Final Array Capacity: " + boxes.getCapacity());
        System.out.println("Total Elements Stored: " + boxes.getSize());
    }
}