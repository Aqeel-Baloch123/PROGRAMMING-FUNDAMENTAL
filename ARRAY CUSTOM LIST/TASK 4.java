import java.util.Scanner;
class ArrayCustomList{
    private int [] list;
    private int size;
    ArrayCustomList(){
        list = new int [2];
        size=0;}
        public void add(int value){
            if(size==list.length){
                int [] newArray=new int [size*2];
                for(int j=0; j<size;j++){
                    newArray[j]=list[j];
                }
                list=newArray;
            }
            list[size]=value;
            size++;
        }
        public void display(){
            for(int i=0; i<size;i++){
                System.out.println(list[i]);
            }
            System.out.println();
        }
        public void update(int index, int value){
        if(index>-1&&index<size){
            list[index]=value;
        } else{
            System.out.println("Invalid index!");
        }
        }
    }
    public class Main{
    public static void main(String[] args ){
        Scanner input = new Scanner(System.in);
        ArrayCustomList Contacts= new ArrayCustomList();
        Contacts.add(1111);
        Contacts.add(1122);
        Contacts.add(1133);
        Contacts.add(1144);
        Contacts.add(1155);
        System.out.println(" Current Contacts ");
        Contacts.display();
        System.out.println(" Enter index to update ");
        int index=input.nextInt();
        System.out.println(" Enter new Value ");
        int value= input.nextInt();
        Contacts.update(index,value);
        System.out.println(" Updated Contats");
        Contacts.display();
    }
    }



