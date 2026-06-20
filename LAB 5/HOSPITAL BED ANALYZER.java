import java.util.Scanner;
public class Main{
    public static void main(String [] args ){
        Scanner input = new Scanner(System.in);
        int empty=0;
        int occupied=0;
        int [][] beds = new int [5][5];
        for(int i =0 ; i<5; i++){
            System.out.println(" Enter data for ward no " + (i+1) +   "> 0 for empty while 1 for occupied bed");
            for(int j=0; j<5;j++){
beds [i][j] = input.nextInt();
if(beds[i][j]==1){
    occupied+=1;
} else {
    empty += 1;
}
            }
        }
        int emptyseats[] = new int[5];
        int occupiedseats[] = new int[5];
for(int i=0; i<5; i++){
     emptyseats[i]=0;
    emptyseats[i]=0;
     for(int j=0; j<5;j++){
if(beds[i][j]==1){
    occupiedseats[i]=occupiedseats[i] + 1;
} else {
    emptyseats[i]=emptyseats[i] + 1;
}
     }
}
        int maxempty = emptyseats[0];
        int emptyindex=0;
        for(int i=1; i<5; i++){
            if (emptyseats[i] > maxempty) {
                maxempty = emptyseats[i];
                emptyindex = i;
            }
            }
        int maxoccupied = occupiedseats[0];
        int occupiedindex=0;
        for(int i=1; i<5; i++){
            if (occupiedseats[i] > maxoccupied) {
                maxoccupied = occupiedseats[i];
                occupiedindex = i;
    }
}
        System.out.println(" Occupied beds are =" + occupied);
        System.out.println(" Empty  beds are  =" + empty);
        System.out.println(" Most empty beds ward no " + emptyindex + " has = " + maxempty );
        System.out.println(" Most empty beds ward no " + occupiedindex + " has = " + maxoccupied);

    }
}