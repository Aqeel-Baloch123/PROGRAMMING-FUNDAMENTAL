public class Main {
    static void printRainfallData(int[][] rainfall) {
        System.out.println("Rainfall Data (in mm):");
        System.out.print("Day ");
        for (int d = 1; d <= 7; d++) {
            System.out.print(d + " ");
        }
        System.out.println();
        for (int i = 0; i < rainfall.length; i++) {
            System.out.print("City " + (i + 1) + ": ");
            for (int j = 0; j < rainfall[i].length; j++) {
                System.out.print(rainfall[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void printAverageRainfall(int[][] rainfall) {
        System.out.println("Average Rainfall:");
        for (int i = 0; i < rainfall.length; i++) {
            int total = 0;
            for (int j = 0; j < rainfall[i].length; j++) {
                total += rainfall[i][j];
            }
            double average = (double) total / rainfall[i].length;
            System.out.println("City " + (i + 1) + ": " + Math.round (average*100/100) + " mm");
        }
    }
    static void printHighestRainfallCity(int[][] rainfall) {
        int highestTotal = 0;
        int highestCity  = 0;
        for (int i = 0; i < rainfall.length; i++) {
            int total = 0;
            for (int j = 0; j < rainfall[i].length; j++) {
                total += rainfall[i][j];
            }
            if (total > highestTotal) {
                highestTotal = total;
                highestCity  = i + 1;
            }
        }
        System.out.println("\nCity with Highest Total Rainfall: City " + highestCity
                + " (Total = " + highestTotal + " mm)");
    }
    public static void main(String[] args) {
        int[][] rainfall = {
                {10, 12, 0, 5,  8,  15, 7 },  // City 1
                { 4,  3, 0, 6,  2,   1, 0 },  // City 2
                {11, 13, 9, 10, 12, 14, 15}   // City 3
        };
        printRainfallData(rainfall);
        printAverageRainfall(rainfall);
        printHighestRainfallCity(rainfall);
    }
}