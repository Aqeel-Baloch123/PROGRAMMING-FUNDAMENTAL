import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int students = 6;
        int subjects = 4;
        int[][] marks = new int[students][subjects];
     System.out.println(" Enter marks of Students of 6 Students  ");
   for (int i =0; i<students; i++){
       System.out.println(" Enter marks of student " + (i+1));
       for(int j =0; j<subjects; j++){
           System.out.println(" Subject " + (j+1));
           marks [i][j]= input.nextInt();
       }

   }
        int Total[] = new int[students];
        for (int i =0; i<students; i++){
            Total[i]=0;
            for(int j=0; j<subjects; j++){
                Total[i]=Total[i]+marks[i][j];
            }
        }
        double[] Average = new double[subjects];
        for (int j = 0; j < subjects; j++) {
            int subjectSum = 0;
            for (int i = 0; i < students; i++) {
                subjectSum = subjectSum + marks[i][j];
            }
            Average[j] = (double) subjectSum / students;
        }
        int maxTotal = Total[0];
        int topperIndex = 0;
        for (int i = 1; i < students; i++) {
            if (Total[i] > maxTotal) {
                maxTotal = Total[i];
                topperIndex = i;
            }
        }
        System.out.println(" ---------------------- TOTAL--------------");
        for(int i=0; i<students; i++){
            System.out.println(" Student " + (i+1) + " has Total "+ Total[i]+" Marks" );

        }
        System.out.println(" ---------------------- Average--------------");
        for(int i=0; i<subjects; i++){
            System.out.println(" Subject " + (i+1) + " has Average of  "+ Total[i] );}
        System.out.println(" ---------------------- TOPPER--------------");
        System.out.println(" Topper Student is " + (topperIndex+1));
    }
}