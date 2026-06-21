import java.util.Scanner;
class ArrayCustomList{
    private double []list;
    private int size;
    ArrayCustomList(){
        list= new double[2];
        size=0;
    }
    public void add(double value){
        if(size==list.length){
            double [] newArray= new double [list.length*2];
            for(int i=0; i<list.length;i++){
                newArray[i]=list[i];
            }
            list=newArray;
        }
        list[size]=value;
        size++;
    }
    public void display(){
        for(int i=0; i<size;i++){
            System.out.print(list[i] +" ");
        }
        System.out.println();
    }
    public int getSize(){
        return size;
    }
}
public class Main{
public static void main(String [] args){
Scanner input= new Scanner(System.in);
ArrayCustomList expenses= new ArrayCustomList();
System.out.println(" How many Enpenses ");
int total= input.nextInt();
for(int i=0; i<total; i++){
    System.out.println(" Enter Expense " + (i+1));
    double kharcha= input.nextDouble();
    expenses.add(kharcha);
}
expenses.display();
System.out.println(" Current size " + expenses.getSize());
}
}
