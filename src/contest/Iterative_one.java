package contest;

import java.util.Scanner;

public class Iterative_one {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double result = 1 + chainDivide(n, 1);
        System.out.println(String.format("%.10f", result));
    }

    private static double chainDivide(int n, int i) {
        double result = 0;

        if (n > 0)
            result = 1 / ((i * 2 + 1) + chainDivide(--n, ++i));

        return result;
    }
}
