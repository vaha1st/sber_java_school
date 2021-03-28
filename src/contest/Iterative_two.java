package contest;

import java.util.Scanner;

public class Iterative_two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double res = 0;

        for (int x = 1; x <= 5; x++) {
            for (int k = 0; k <= n; k++) {
                res += Math.pow(-1, k + 1) * Math.pow(x, 2 * k + 1) / (runFactorial(k) * (2 * k + 1));
            }
        }
        System.out.println(String.format("%.10f", res));
    }

    private static long runFactorial(int num) {
        if (num <= 1) {
            return 1;
        } return num*runFactorial(num-1);
    }
}
