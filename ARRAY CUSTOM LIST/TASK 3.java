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
    public void search(int x) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (list[i] == x) {
                found = true;
                break;
            }
        }
            if (found) {
                System.out.println("Employee Found");
                System.out.println("Employee ID " + x + " exists in the record.");
            } else {
                System.out.println("Employee Not Found");
                System.out.println("Employee ID " + x + " does not exist in the record.");
            }
    }
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(list[i]);
        }
        System.out.println();
    }
}
    public class Main{
        public static void main(String[] args ){
            Scanner input = new Scanner(System.in);
            ArrayCustomList employee= new ArrayCustomList();
            employee.add(101);
            employee.add(102);
            employee.add(103);
            employee.add(104);
            employee.add(105);
            System.out.println("Employee IDs in Record:");
            employee.display();
            System.out.print("Enter Employee ID to search: ");
            int key = input.nextInt();
            employee.search(key);
        }
    }

