package contest;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        if (n <= 20)
            System.out.println(runFactorial(n));

    }

    private static long runFactorial(int num) {
        if (num <= 1) {
            return 1;
        } return num * runFactorial(num-1);
    }
}
