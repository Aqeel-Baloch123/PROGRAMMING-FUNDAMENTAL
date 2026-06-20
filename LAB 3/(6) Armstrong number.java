public class Main {
    public static void main(String[] args) {
        System.out.print("Armstrong numbers between 1 and 1000: ");
        for (int num = 1; num <= 1000; num++) {
            int digits = 0;
            int temp = num;
            while (temp != 0) {
                digits++;
                temp /= 10;
            }
            int original = num;
            int sum = 0;
            while (original != 0) {
                int digit = original % 10;
                sum += (int) Math.pow(digit, digits);
                original /= 10;
            }
            if (sum == num) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
}