import java.util.Scanner;
class ArrayCustomList {
    private int[] list;
    private int size;
    ArrayCustomList() {
        list = new int[8];
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
    public void delete(int id) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (list[i] == id) {
                found = true;
                System.out.println("Deleting Booking ID: " + id);
                for (int j = i; j < size - 1; j++) {
                    list[j] = list[j + 1];
                }
                size--;
                break;
            }
        }
        if (!found) {
            System.out.println("Booking ID " + id + " not found!");
        }
        if (size <= list.length / 2) {
            System.out.println("Stored Elements are Less Than or Equal to Half Capacity");
            System.out.println("Shrinking Array...");
            int[] newArray = new int[list.length / 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = list[i];
            }
            list = newArray;
            System.out.println("New Array Capacity: " + list.length);
        }
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
        Scanner input = new Scanner(System.in);
        ArrayCustomList bookings = new ArrayCustomList();
        bookings.add(201);
        bookings.add(202);
        bookings.add(203);
        bookings.add(204);
        System.out.println("Initial Array Capacity: " + bookings.getCapacity());
        System.out.println("Room Booking IDs Stored:");
        bookings.display();
        System.out.print("How many bookings to delete? ");
        int total = input.nextInt();
        for (int i = 0; i < total; i++) {
            System.out.print("Enter Booking ID to delete: ");
            int id = input.nextInt();
            bookings.delete(id);
        }
        System.out.println("Updated Booking IDs:");
        bookings.display();
        System.out.println("Final Array Capacity: " + bookings.getCapacity());
        System.out.println("Total Elements Stored: " + bookings.getSize());
    }
}