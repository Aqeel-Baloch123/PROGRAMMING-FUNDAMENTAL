import java.util.Scanner;
class ArrayCustomList{
    private int[]list;
    private int size;
    ArrayCustomList(){
        list=new int[2];
        size=0;
    }
    public void add(int value){
        if(size==list.length){
            int [] newArray=new int[list.length*2];
            for(int j=0; j<size;j++){
                newArray[j]=list[j];
            }
            list=newArray;
        }
        list[size]=value;
        size++;
    }
    public void delete(int index) {
        if (index > -1 && index < size) {
            for (int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            size--;
            System.out.println(" Book at index 2 deleted successfully");
        } else {
            System.out.println(" Invalid Index");
        }
    }
        public void display(){
            for(int i=0; i<size;i++){
                System.out.print(list[i] +" ");
            }
            System.out.println();
        }
        }
        public class Main{
        public static void main(String[] args ){
            Scanner input=new Scanner(System.in);
            ArrayCustomList books= new ArrayCustomList();
             books.add(11);
            books.add(22);
            books.add(31);
            books.add(41);
            books.add(51);
            books.add(61);
            System.out.println("BOOSK IDS IN LIBRARY   ");
            books.display();
            System.out.println(" Enter index to delete ");
            int index=input.nextInt();
            books.delete(index);
            System.out.println(" Updated Array");
            books.display();
        }
        }




